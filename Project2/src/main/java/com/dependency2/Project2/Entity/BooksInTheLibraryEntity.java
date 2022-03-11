package com.dependency2.Project2.Entity;

import com.dependency2.Project2.dto.BooksInTheLibrary;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Book")
public class BooksInTheLibraryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="bookId",nullable=false)
    public Integer bookId;

    public String bookName;

    public String bookWriter;

    public String bookSummary;

    public String bookCategory;


    public BooksInTheLibraryEntity(){}
    public BooksInTheLibraryEntity(@NotNull Integer bookId, String bookName, String bookWriter, String bookSummary, String bookCategory) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookWriter = bookWriter;
        this.bookSummary = bookSummary;
        this.bookCategory = bookCategory;
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
