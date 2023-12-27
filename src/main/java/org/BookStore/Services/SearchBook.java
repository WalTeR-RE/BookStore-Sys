package org.BookStore.Services;
import org.BookStore.Database.*;
import org.BookStore.Books.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class SearchBook {

    private static List<Book> FoundBooks;

    public static List<Book> getFoundBooks() {
        return FoundBooks;
    }

    public static void setFoundBooks(String BookName) {
        List<Book> AllBooks = Book.getListOfBooks();
        List<Book> FoundBook = new ArrayList<>();
        FoundBook = AllBooks.stream().filter(book -> book.getTitle().startsWith(BookName))
                .collect(Collectors.toList());

        FoundBooks = FoundBook;
    }
}
