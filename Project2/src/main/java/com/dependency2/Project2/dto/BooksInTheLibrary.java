package com.dependency2.Project2.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

//@Data
//@Builder
public class BooksInTheLibrary implements Serializable {
    @NotNull
    private Integer bookId;
    private String bookName;
    private String bookWriter;
    private String bookSummary;
    private String bookCategory;
    public BooksInTheLibrary(){}

    public BooksInTheLibrary(Integer bookId, String bookName, String bookWriter, String bookSummary, String bookCategory) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookWriter = bookWriter;
        this.bookSummary = bookSummary;
        this.bookCategory = bookCategory;
//        BooksInTheLibrary booksInTheLibrary=BooksInTheLibrary.d
    }

    public Integer getBookId() {

        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookWriter() {
        return bookWriter;
    }

    public void setBookWriter(String bookWriter) {
        this.bookWriter = bookWriter;
    }

    public String getBookSummary() {
        return bookSummary;
    }

    public void setBookSummary(String bookSummary) {
        this.bookSummary = bookSummary;
    }

    public String getBookCategory() {
        return bookCategory;
    }

    public void setBookCategory(String bookCategory) {
        this.bookCategory = bookCategory;
    }
}


