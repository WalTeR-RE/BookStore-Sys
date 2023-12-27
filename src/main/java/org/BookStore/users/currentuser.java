package org.BookStore.users;
import org.BookStore.users.Roles;

import java.util.Dictionary;
import java.util.List;


public class currentuser {

    public static class CartItem{
        private int BookId;
        private int Quantity;
        private int Price;

        public int getBookId() {
            return BookId;
        }

        public void setBookId(int bookId) {
            BookId = bookId;
        }

        public int getQuantity() {
            return Quantity;
        }

        public void setQuantity(int quantity) {
            Quantity = quantity;
        }

        public int getPrice() {
            return Price;
        }

        public void setPrice(int price) {
            Price = price;
        }
    }
    private static currentuser instance;
    private currentuser(){
        // to prevent obtaining an instance using constructor
    }

    public static currentuser getInstance(){
        if(instance==null)
            instance = new currentuser();

        return instance;
    }
    private int AccountId;
    private String Email;
    private Roles Role;
    private boolean Active;
    private String Created;
    private String uuid;
    private String Name;
    private int Age;
    private String Gender;
    private String Phonenumber;
    private String SecurityQuestion;
    private String SecurityAnswer;
    private int Points;
    private boolean Online;

    private List<CartItem> Cart;

    public List<CartItem> getCart() {
        return Cart;
    }

    public void setCart(List<CartItem> cart) {
        Cart = cart;
    }

    public int getAccountId() {
        return AccountId;
    }

    public void setAccountId(int accountId) {
        AccountId = accountId;
    }
    public Roles getRole() {
        return Role;
    }
    public void setRole(Roles role) {
        Role = role;
    }
    public String getEmail() {
        return Email;
    }
    public void setEmail(String email) {
        Email = email;
    }
    public boolean isActive() {
        return Active;
    }
    public void setActive(boolean active) {
        Active = active;
    }
    public String getCreated() {
        return Created;
    }
    public void setCreated(String created) {
        Created = created;
    }
    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getPhonenumber() {
        return Phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        Phonenumber = phonenumber;
    }

    public String getSecurityQuestion() {
        return SecurityQuestion;
    }

    public void setSecurityQuestion(String securityQuestion) {
        SecurityQuestion = securityQuestion;
    }

    public String getSecurityAnswer() {
        return SecurityAnswer;
    }

    public void setSecurityAnswer(String securityAnswer) {
        SecurityAnswer = securityAnswer;
    }

    public int getPoints() {
        return Points;
    }

    public void setPoints(int points) {
        Points = points;
    }

    public boolean isOnline() {
        return Online;
    }

    public void setOnline(boolean online) {
        Online = online;
    }

    public boolean IsOwner(){
        return Role == Roles.Owner;
    }
    public boolean IsAdmin(){
        return Role == Roles.Owner || Role == Roles.Admin;
    }
    public boolean IsManager(){
        return Role == Roles.Owner || Role == Roles.Admin || Role == Roles.Manager;
    }

    public void logout() {
        AccountId = 0;
        Email = null;
        Role = null;
        Active = false;
        Created = null;
        uuid = null;
        Name = null;
        Age = 0;
        Gender = null;
        Phonenumber = null;
        SecurityQuestion = null;
        SecurityAnswer = null;
        Points = 0;
        Online = false;

        if (Cart != null) {
            Cart.clear();
        }

    }
    public void printUserData() {
        System.out.println("User Data:");
        System.out.println("AccountId: " + AccountId);
        System.out.println("Email: " + Email);
        System.out.println("Role: " + Role);
        System.out.println("Active: " + Active);
        System.out.println("Created: " + Created);
        System.out.println("UUID: " + uuid);
        System.out.println("Name: " + Name);
        System.out.println("Age: " + Age);
        System.out.println("Gender: " + Gender);
        System.out.println("Phonenumber: " + Phonenumber);
        System.out.println("SecurityQuestion: " + SecurityQuestion);
        System.out.println("SecurityAnswer: " + SecurityAnswer);
        System.out.println("Points: " + Points);
        System.out.println("Online: " + Online);
    }
}
