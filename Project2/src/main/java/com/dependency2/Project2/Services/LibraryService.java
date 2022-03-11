package com.dependency2.Project2.Services;

import com.dependency2.Project2.dto.BooksInTheLibrary;
import com.dependency2.Project2.dto.UserBookHistory;
import com.dependency2.Project2.dto.UserOfLibrary;


import java.util.List;

public interface LibraryService {
    public void addBook(BooksInTheLibrary booksInTheLibrary);
    public void addUser(UserOfLibrary userOfLibrary);
    public List<BooksInTheLibrary> getBooksInTheLibrary();
    public void addIssue(UserBookHistory userBookHistory);
    public void addReturnDate(UserBookHistory userBookHistory);
    public BooksInTheLibrary addPopularBook();
    public UserOfLibrary getBookWriterWithMaxUser();
}
