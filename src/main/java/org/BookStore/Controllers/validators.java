package org.BookStore.Controllers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class validators {

    public boolean isValidUsername(String username) {
        String regex = "^[a-zA-Z'-]+$";
        return matchesRegex(username, regex);
    }

    public boolean isValidPassword(String password) {
        String regex = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[@#$%^&+=!])(?!.*\\s).{12,}$";
        return matchesRegex(password, regex);
    }

    public boolean isValidPhoneNumber(String phoneNumber) {
        String regex = "^(\\+)?(010|012|015|011)[0-9]{8}$";
        return matchesRegex(phoneNumber, regex);
    }

    public boolean isValidEmail(String email) {
        String regex = "^[a-zA-Z0-9_.+&*-]{1,150}@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return matchesRegex(email, regex);
    }

    public boolean isValidSecurityQuestion(String securityQuestion) {
        return !securityQuestion.trim().isEmpty();
    }

    public boolean isValidSecurityAnswer(String securityAnswer) {
        return !securityAnswer.trim().isEmpty();
    }

    public boolean isValidGender(String gender) {
        String Gender = gender.trim();
        return "Male".equals(Gender) || "Female".equals(Gender);
    }

    private boolean matchesRegex(String input, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

}
