package org.BookStore.Controllers;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.BookStore.Books.Book;

public class BookValidators {

    public boolean isValidBookId(int bookId) {
        return bookId > 0;
    }

    public boolean isValidAuthor(String author) {
        String regex = "^[a-zA-Z'\\s-]+$";
        return matchesRegex(author, regex);
    }

    public boolean isValidTitle(String title) {
        String regex = "^[a-zA-Z0-9\\s-]+$";
        return matchesRegex(title, regex);
    }

    public boolean isValidCoverImg(String coverImg) {
        return coverImg != null && !coverImg.trim().isEmpty();
    }

    public boolean isValidCategory(List<String> category) {
        return category != null && !category.isEmpty();
    }

    public boolean isValidDescription(String description) {
        return description != null && !description.trim().isEmpty();
    }

    public boolean isValidPrice(int price) {
        return price > 0;
    }

    public boolean isValidQuantity(int quantity) {
        return quantity >= 0;
    }

    public boolean isValidAvgRev(float avgRev) {
        return avgRev<=5.0;
    }


    private boolean matchesRegex(String input, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }
}

