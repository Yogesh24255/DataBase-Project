package com.dependency2.Project2.Controller;

import com.dependency2.Project2.Services.LibraryService;
import com.dependency2.Project2.dto.BooksInTheLibrary;
import com.dependency2.Project2.dto.UserBookHistory;
import com.dependency2.Project2.dto.UserOfLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LibraryMangementControler {

    @Autowired
    LibraryService libraryService;

    @PostMapping("/Book")
    public void addBook(@RequestBody BooksInTheLibrary booksInTheLibrary){
        libraryService.addBook (booksInTheLibrary);
    }
    @PostMapping("/User")
    public void addUser(@RequestBody UserOfLibrary userOfLibrary){
        libraryService.addUser (userOfLibrary);
    }
    @GetMapping("/Book1")
    public List<BooksInTheLibrary>getBooksInTheLibrary(){
        return libraryService.getBooksInTheLibrary ();
    }

    @PostMapping("/History")
    public void addIssue(@RequestBody UserBookHistory userBookHistory){

        libraryService.addIssue (userBookHistory);
    }

    @PutMapping("/History1")
    public void addReturnDate(@RequestBody UserBookHistory userBookHistory){
        libraryService.addReturnDate (userBookHistory);
    }
    @GetMapping("/Book2")
    public BooksInTheLibrary addPopularBook(){
        return libraryService.addPopularBook ();
    }
    @GetMapping("/User1")
    public UserOfLibrary getBookWriterWithMaxUser(){
        return libraryService.getBookWriterWithMaxUser ();
    }


}
