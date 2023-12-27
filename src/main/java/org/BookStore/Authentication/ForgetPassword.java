package org.BookStore.Authentication;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Email;
import com.sendgrid.helpers.mail.objects.Personalization;
import org.BookStore.Cryptography.Crypto;
import org.BookStore.Database.Authentication;
import org.BookStore.Database.*;
import org.BookStore.Controllers.validators;

import javax.swing.*;
import java.security.SecureRandom;
import java.sql.*;

import java.io.IOException;

public class ForgetPassword {

    public enum ForgetPasswordRequestStatus {
        OK,
        FAIL,
        NOTFOUND,
        MAILERROR,
        WEALREADYSENTYOUOTP,
        DBERROR
    }

    public enum ForgetPasswordResponseStatus {
        OK,
        FAIL,
        WRONGOTP,
        SESSIONEXPIRED,
        ACCOUNTLOCKED,
        DBERROR
    }

    public enum ForgetPasswordMailStatus {
        OK,
        FAIL
    }

    static Connection conn = null;
    static dbconnection dbcon = null;

    private String generateSecureOTP() {
        String Chars = "0123456789";
        SecureRandom rnd = new SecureRandom();
        StringBuilder OTP = new StringBuilder(6);

        for (int i = 0; i < 6; i++)
            OTP.append(Chars.charAt(rnd.nextInt(Chars.length())));

        return OTP.toString();
    }

    public ForgetPasswordRequestStatus ResetPasswordRequest(String email, String phonenumber) {
        if (email.isEmpty() & phonenumber.isEmpty())
            return ForgetPasswordRequestStatus.FAIL;

        try {
            dbconnection dbcon = dbconnection.getInstance();
            conn = dbcon.getConnection();
            if (!email.isEmpty()) {

                String Query = Authentication.getUserByEmail_Query();

                PreparedStatement ps = conn.prepareStatement(Query);

                ps.setString(1, email);

                ResultSet rs = ps.executeQuery();

                if (!rs.next())
                    return ForgetPasswordRequestStatus.NOTFOUND;
                else {
                    String OTP = generateSecureOTP();
                    String username = rs.getString("username");

                    rs = ps.executeQuery();
                    if (rs.next()) {
                        if (!(rs.getString("OTP") == null))
                            if (!rs.getString("OTP").isEmpty())
                                return ForgetPasswordRequestStatus.WEALREADYSENTYOUOTP;
                    }
                    String Query2 = Authentication.getResetPasswordByEmail_Query();

                    PreparedStatement ps2 = conn.prepareStatement(Query2);

                    ps2.setString(1, OTP);
                    ps2.setString(2, email);

                    ps2.executeUpdate();

                    ForgetPasswordMailStatus stat = SendResetMail(email, username, OTP);

                    if (stat != ForgetPasswordMailStatus.OK)
                        return ForgetPasswordRequestStatus.MAILERROR;

                    return ForgetPasswordRequestStatus.OK;
                }

            } else {
                String Query = Authentication.getUserByPhonenumber_Query();
                PreparedStatement ps = conn.prepareStatement(Query);
                ps.setString(1, phonenumber);
                ResultSet rs = ps.executeQuery();
                if (!rs.next())
                    return ForgetPasswordRequestStatus.NOTFOUND;
                else
                    return ForgetPasswordRequestStatus.OK;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "There Is An Error Occured\nWe Will Fix It Soon!");;
            return ForgetPasswordRequestStatus.DBERROR;
        } finally {
            if (dbcon != null)
                dbcon.closeConnection(conn);
        }
    }

    public ForgetPasswordMailStatus SendResetMail(String user_email, String username, String OTP) {

        String apiKey = System.getenv("SEND_GRID_API_KEY");
        String to = user_email;
        String from = "bookstorecompany02@gmail.com";
        String templateId = "d-ec85c2caa3104127af4dd04b61612752";

        Mail mail = new Mail();
        mail.setFrom(new Email(from));
        mail.setSubject("Reset Password Mail");

        Personalization personalization = new Personalization();
        personalization.addTo(new Email(to));

        personalization.addDynamicTemplateData("first_name", username);
        personalization.addDynamicTemplateData("OTP", OTP);

        mail.addPersonalization(personalization);
        mail.setTemplateId(templateId);
        SendGrid sg = new SendGrid(apiKey);
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);
            return ForgetPasswordMailStatus.OK;
        } catch (IOException ex) {
            return ForgetPasswordMailStatus.FAIL;
        }
    }

    public ForgetPasswordResponseStatus SendResetRequestByOTP(String user_email, String OTP, String NewPassword, String NewPasswordConfirmation) {
        validators v = new validators();

        if (!v.isValidEmail(user_email))
            return ForgetPasswordResponseStatus.FAIL;
        if (!v.isValidPassword(NewPassword))
            return ForgetPasswordResponseStatus.FAIL;
        if (!NewPassword.equals(NewPasswordConfirmation))
            return ForgetPasswordResponseStatus.FAIL;

        String Query = Authentication.getUserByEmail_Query();
        String Query2 = Authentication.getUpdateOTPCounter_Query();
        String Query3 = Authentication.getWrongResetCounter_Query();
        String Query4 = Authentication.getAccountActive_Query();
        String Query5 = Authentication.getUpdateUserPassword_Query(user_email);
        String Query6 = Authentication.getResetPasswordByEmail_Query();
        try {
            dbcon = dbconnection.getInstance();
            conn = dbcon.getConnection();

            PreparedStatement get_user_statement = conn.prepareStatement(Query);
            PreparedStatement update_otp_counter_statement = conn.prepareStatement(Query2);
            PreparedStatement wrong_reset_counter_statement = conn.prepareStatement(Query3);
            PreparedStatement active_account_statement = conn.prepareStatement(Query4);
            PreparedStatement update_password_statement = conn.prepareStatement(Query5);
            PreparedStatement update_otp_statement = conn.prepareStatement(Query6);

            get_user_statement.setString(1, user_email);
            ResultSet rs = get_user_statement.executeQuery();

            if (rs.next()) {
                String otp = rs.getString("OTP");
                int reset_counter = rs.getInt("ResetCounter");
                int wrong_reset_counter = rs.getInt("WrongResetCounter");
                if (wrong_reset_counter >= 5) {
                    active_account_statement.setString(1, "0");
                    active_account_statement.setString(2, user_email);

                    active_account_statement.executeUpdate();
                    return ForgetPasswordResponseStatus.ACCOUNTLOCKED;
                }

                if (reset_counter >= 4 && !otp.equals(OTP)) {
                    update_otp_counter_statement.setString(1, "0");
                    update_otp_counter_statement.setString(2, user_email);
                    wrong_reset_counter_statement.setString(1, String.valueOf(wrong_reset_counter + 1));
                    wrong_reset_counter_statement.setString(2, user_email);
                    update_otp_statement.setString(1, "");
                    update_otp_statement.setString(2, user_email);


                    update_otp_statement.executeUpdate();
                    update_otp_counter_statement.executeUpdate();
                    wrong_reset_counter_statement.executeUpdate();

                    return ForgetPasswordResponseStatus.SESSIONEXPIRED;
                }


                if (otp.equals(OTP)) {
                    update_otp_counter_statement.setString(1, "0");
                    update_otp_counter_statement.setString(2, user_email);
                    wrong_reset_counter_statement.setString(1, "0");
                    wrong_reset_counter_statement.setString(2, user_email);
                    update_password_statement.setString(1, Crypto.MD5(NewPassword));
                    update_password_statement.setString(2, user_email);
                    update_otp_statement.setString(1, "");
                    update_otp_statement.setString(2, user_email);

                    update_otp_counter_statement.executeUpdate();
                    wrong_reset_counter_statement.executeUpdate();
                    update_password_statement.executeUpdate();
                    update_otp_statement.executeUpdate();

                    return ForgetPasswordResponseStatus.OK;
                }

                update_otp_counter_statement.setString(1, String.valueOf(rs.getInt("ResetCounter") + 1));
                update_otp_counter_statement.setString(2, user_email);

                update_otp_counter_statement.executeUpdate();


                return ForgetPasswordResponseStatus.WRONGOTP;

            } else return ForgetPasswordResponseStatus.FAIL;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "There Is An Error Occured\nWe Will Fix It Soon!");;
            return ForgetPasswordResponseStatus.DBERROR;
        } finally {
            if (dbcon != null) {
                dbcon.closeConnection(conn);
            }
        }

    }


    public ForgetPasswordResponseStatus SendResetRequestByPhoneNumber(String phonenumber, String Question, String Answer, String NewPassword, String NewPasswordConfirmation) {
        validators v = new validators();

        if (!v.isValidPhoneNumber(phonenumber))
            return ForgetPasswordResponseStatus.FAIL;
        if (!v.isValidPassword(NewPassword))
            return ForgetPasswordResponseStatus.FAIL;
        if (!NewPassword.equals(NewPasswordConfirmation))
            return ForgetPasswordResponseStatus.FAIL;

        String Query = Authentication.getUserByPhonenumber2_Query();
        String Query2 = Authentication.getUpdateOTPCounter_Query();
        String Query3 = Authentication.getWrongResetCounter_Query();
        String Query4 = Authentication.getAccountActive_Query();
        String Query5 = Authentication.getUpdateUserPassword_Query("");
        String Query6 = Authentication.getSecurityQues_Ans_Query();
        try {
            dbcon = dbconnection.getInstance();
            conn = dbcon.getConnection();

            PreparedStatement get_user_statement = conn.prepareStatement(Query);
            PreparedStatement update_otp_counter_statement = conn.prepareStatement(Query2);
            PreparedStatement wrong_reset_counter_statement = conn.prepareStatement(Query3);
            PreparedStatement active_account_statement = conn.prepareStatement(Query4);
            PreparedStatement update_password_statement = conn.prepareStatement(Query5);
            PreparedStatement security_answer_statement = conn.prepareStatement(Query6);

            get_user_statement.setString(1, phonenumber);
            ResultSet rs = get_user_statement.executeQuery();

            if (rs.next()) {
                String answer = rs.getString("SecurityQuesAns");
                int reset_counter = rs.getInt("ResetCounter");
                int wrong_reset_counter = rs.getInt("WrongResetCounter");
                String user_email = rs.getString("Email");
                if (wrong_reset_counter >= 5) {
                    active_account_statement.setString(1, "0");
                    active_account_statement.setString(2, user_email);

                    active_account_statement.executeUpdate();
                    return ForgetPasswordResponseStatus.ACCOUNTLOCKED;
                }

                if (reset_counter >= 4 && !answer.equals(Answer)) {
                    update_otp_counter_statement.setString(1, "0");
                    update_otp_counter_statement.setString(2, user_email);
                    wrong_reset_counter_statement.setString(1, String.valueOf(wrong_reset_counter + 1));
                    wrong_reset_counter_statement.setString(2, user_email);


                    update_otp_counter_statement.executeUpdate();
                    wrong_reset_counter_statement.executeUpdate();

                    return ForgetPasswordResponseStatus.SESSIONEXPIRED;
                }

                if (!Question.equals(rs.getString("SecurityQues"))) {
                    update_otp_counter_statement.setString(1, String.valueOf(rs.getInt("ResetCounter") + 1));
                    update_otp_counter_statement.setString(2, user_email);

                    update_otp_counter_statement.executeUpdate();


                    return ForgetPasswordResponseStatus.WRONGOTP;
                } else {
                    if (answer.equals(Answer)) {
                        update_otp_counter_statement.setString(1, "0");
                        update_otp_counter_statement.setString(2, user_email);
                        wrong_reset_counter_statement.setString(1, "0");
                        wrong_reset_counter_statement.setString(2, user_email);
                        update_password_statement.setString(1, Crypto.MD5(NewPassword));
                        update_password_statement.setString(2, user_email);

                        update_otp_counter_statement.executeUpdate();
                        wrong_reset_counter_statement.executeUpdate();
                        update_password_statement.executeUpdate();

                        return ForgetPasswordResponseStatus.OK;
                    }
                    update_otp_counter_statement.setString(1, String.valueOf(rs.getInt("ResetCounter") + 1));
                    update_otp_counter_statement.setString(2, user_email);

                    update_otp_counter_statement.executeUpdate();


                    return ForgetPasswordResponseStatus.WRONGOTP;
                }


            } else return ForgetPasswordResponseStatus.FAIL;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "There Is An Error Occured\nWe Will Fix It Soon!");;
            return ForgetPasswordResponseStatus.DBERROR;
        } finally {
            if (dbcon != null) {
                dbcon.closeConnection(conn);
            }
        }
    }
}



