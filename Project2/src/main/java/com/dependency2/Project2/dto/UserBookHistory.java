package com.dependency2.Project2.dto;


import javax.persistence.Id;
import java.io.Serializable;

public class UserBookHistory implements Serializable {
    @Id
    private Integer transactionId;
    private Integer userId;
    private Integer bookId;
    private String isueDate;
    private String returnDate;
    public UserBookHistory(){}
    public UserBookHistory(Integer transactionId, Integer userId, Integer bookId, String isueDate, String returnDate) {
        this.transactionId = transactionId;
        this.userId = userId;
        this.bookId = bookId;
        this.isueDate = isueDate;
        this.returnDate = returnDate;
    }

    public Integer getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getIsueDate() {
        return isueDate;
    }

    public void setIsueDate(String isueDate) {
        this.isueDate = isueDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }
}
//Library management system
//
//
//
//User
//--id
//--name
//--address
//--phoneNumber
//
//
//
//Books
//--id
//--name
//--writer
//--summary
//--category
//
//
//
//UserBookHistory
//--userid
//--bookid
//--startdate
//--enddate
//
//
//
//API to add a new book
//API to add a new user
//API to issue a book
//API to return a book
//API to get most popular books all information
//API to get users info who has taken more books
//
//
//
//
//Custom Exceptions
//Response object
//
//
//
//Use postgres
//
//
//
//Once the basic implementations are done use redis as a cache
//
//
//
//push to new git project