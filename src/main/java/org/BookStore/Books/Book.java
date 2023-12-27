package org.BookStore.Books;
import java.util.*;


public class Book {

    private static List<Book> ListOfBooks;
    private static List<String> ListOfBookCategory;
    private int bookId;
    private String author;
    private String title;
    private String coverimg;
    private List<String> category;
    private String description;
    private int price;
    private int quantity;
    private float avgrev;


    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getCategory() {
        return category;
    }

    public void setCategory(List<String> category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getAvgrev() {
        return avgrev;
    }

    public void setAvgrev(float avgrev) {
        this.avgrev = avgrev;
    }

    public String getCoverimg() {
        return coverimg;
    }

    public void setCoverimg(String coverimg) {
        this.coverimg = coverimg;
    }

    public static List<Book> getListOfBooks(){
        return ListOfBooks;
    }
    public static List<String> getListOfBookCategory(){
        return ListOfBookCategory;
    }

    public static void setListOfBookCategory(List<String> listOfBookCategory) {
        ListOfBookCategory = listOfBookCategory;
    }

    public static void setListOfBooks(List<Book> list){
        ListOfBooks=list;
    }

    public static Book getBookById(int bookId) {
        if (ListOfBooks == null || ListOfBooks.isEmpty()) {
            return null;
        }

        Collections.sort(ListOfBooks, (b1, b2) -> Integer.compare(b1.getBookId(), b2.getBookId()));

        int low = 0;
        int high = ListOfBooks.size() - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int midBookId = ListOfBooks.get(mid).getBookId();

            if (midBookId == bookId) {
                return ListOfBooks.get(mid);
            } else if (midBookId < bookId) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }
    public static Book getBookByName(String bookName) {
        if (ListOfBooks == null || ListOfBooks.isEmpty()) {
            return null;
        }

        Collections.sort(ListOfBooks, Comparator.comparing(Book::getTitle));

        int low = 0;
        int high = ListOfBooks.size() - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            String midBookName = ListOfBooks.get(mid).getTitle();

            int comparisonResult = midBookName.compareToIgnoreCase(bookName);

            if (comparisonResult == 0) {
                return ListOfBooks.get(mid);
            } else if (comparisonResult < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return null;
    }
    public void printBookData() {
        System.out.println("Book ID: " + bookId);
        System.out.println("Author: " + author);
        System.out.println("Title: " + title);
        System.out.println("Cover Image: " + coverimg);
        System.out.println("Category: " + category);
        System.out.println("Description: " + description);
        System.out.println("Price: $" + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Average Review: " + avgrev);
    }

}
