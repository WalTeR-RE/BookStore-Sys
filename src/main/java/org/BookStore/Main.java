package org.BookStore;


import javax.swing.*;
import java.net.Socket;
import java.sql.Connection;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.*;
import java.io.IOException;
import java.util.stream.Collectors;

import com.sendgrid.*;
import org.BookStore.Authentication.ForgetPassword;
import org.BookStore.Books.Book;
import org.BookStore.Database.Authentication;
import org.BookStore.Database.*;
import org.BookStore.Services.Adminstration.AdminServices;
import org.BookStore.Services.Client;
import org.BookStore.updater.*;
import org.BookStore.Services.*;
import org.BookStore.users.*;
import org.BookStore.Authentication.*;


public class Main {
    public static void main(String[] args) throws Exception {
        SplashScreen splash = new SplashScreen();
        splash.setVisible(true);
        Thread thr = null;
        try {
            AtomicReference<updater> up = new AtomicReference<>(null);
            thr = new Thread(() -> {
                up.set(new updater());
            });
            thr.start();
        } catch (Exception e) {
        }
        Thread.State state = thr.getState();
        while (!(state == Thread.State.TERMINATED))
            state = thr.getState();

        Thread.sleep(1500);
        splash.setVisible(false);
        splash.dispose();
        //JOptionPane.showMessageDialog(null, "Tester Is Here");
        /*dbconnection db = new dbconnection();
        db.TestDbConnection();*/

        /*
        Crypto cr = new Crypto();
        String Data = "CurrentVersion: 1.0\nIsNewUpdate: True";
        System.out.println(cr.encrypt(Data));*/

        //updater up = new updater();

        //String username = "Osama";
        //String password = "OsamaTest";
        /*System.out.println(Crypto.MD5(password));
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-YYYY")));*/
        //org.BookStore.Authentication.Login.AuthenticationStatus St = org.BookStore.Authentication.Login.Authenticate("","OsamaTest","Osama@Osama.Osama");
        //System.out.println(St);


       /*Register.RegistrationStatus rs = Register.Register("Osama",
                "Osama@Osama.Osama",
                "P@SSW0RDhere123",
                "P@SSW0RDhere123",
                "",
                "Pet Name?",
                "Yummi",
                20,
                "Male"
                );

        System.out.println(rs);*/

        /*Loader.LoadBooks();
        Book book = Book.getListOfBooks().get(0);
        currentuser.getInstance().setRole(Roles.Owner);
        currentuser.getInstance().setName("Osama");
        currentuser.getInstance().setUuid("0bc5901d-d90e-3a94-a0be-648ced6a7ab2");
        currentuser.getInstance().setPhonenumber("");
        currentuser.getInstance().setPoints(300);
        SearchBook.setFoundBooks("Life");
        for(Book x : SearchBook.getFoundBooks())
            System.out.println(x.getTitle());*/


        //TicketService.TicketStatus stat = TicketService.CreateTicket(currentuser.getInstance(),"TESTER IS HER E FOR REAL","TESTER IS HER E FOR REAL");
        //System.out.println(stat);
        //PlaceOrder.OrderStatus stat = PlaceOrder.Placeorder(currentuser.getInstance(),"67 halima","Egypt",3,7,
        //        LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-YYYY")),Book.getBookById(7).getPrice(),"welcome");
        //System.out.println(stat);
        /*Socket soc = new Socket("localhost",1280);
        Client client = new Client(soc,currentuser.getInstance().getName());
        client.Listener();
        client.SendMessage("",true);
        client.SendMessage("Heck I s True!",false);
        client.SendMessage("Powerrrrrr Is Such A thing",false);
        client.SendMessage("Meowwwwwwww 4 The Win!!",false);*/
        //AdminServices.BanStatus Stat = AdminServices.BanUserChat(currentuser.getInstance(),"asamaaly70@gmail.com","","0","TestFunction");
        //System.out.println(Stat);
        /*book.setCategory(Arrays.asList("Action, Comedy , Anime , Hecker No, Heck Yeah"));
        book.setAvgrev(2f);
        UpdateBook.UpdateBookStatus stat = UpdateBook.UpdateBook(currentuser.getInstance(),book);
        AddBook.AddBookStatus stat2 = AddBook.AddBook(currentuser.getInstance(),"HeckTheWorld","Life Is Shit",Arrays.asList("Hack, Drama, Queen, Slice of Life"),"Here we go","Path/Imag.png",
                100,3,3.3f);
        DeleteBook.DeleteBookStatus stat3 = DeleteBook.DeleteBook(currentuser.getInstance(),0,2f);
        DeleteBook.DeleteBookStatus stat4 = DeleteBook.DeleteBook(currentuser.getInstance(),4,0);
        System.out.println(stat);
        System.out.println(stat2);
        System.out.println(stat3);
        System.out.println(stat4);*/

        Login loginframe=new Login();
        ImageIcon image;
        image = new ImageIcon(loginframe.getClass().getResource("/Images/icons8-book-94.png"));
        loginframe.setIconImage(image.getImage());
        loginframe.setVisible(true);
        loginframe.pack();
        loginframe.setResizable(false);
        loginframe.setLocationRelativeTo(null);



       /*ForgetPassword fs = new ForgetPassword();

       ForgetPassword.ForgetPasswordResponseStatus sta =
               fs.SendResetRequestByPhoneNumber("","What is your favorite color?", "Cyan", "P@SSW0RDhere123", "P@SSW0RDhere123");

            System.out.println(sta);
*/
        //ForgetPassword.SendResetMail("asamaaly70@gmail.com","Osama","15536");


    }


}

