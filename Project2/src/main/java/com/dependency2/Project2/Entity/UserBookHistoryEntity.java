package com.dependency2.Project2.Entity;

import com.dependency2.Project2.dto.UserBookHistory;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="History")
public class UserBookHistoryEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer transactionId;




    //@OneToOne
    //@JoinColumn(name="userId", nullable=false)
    //private UserBookHistory user;
  //  @ManyToOne
   // @JoinColumn(name="bookId", nullable=false)
    private Integer userid;
    private String issueDate;
    private String returnDate;
    private Integer bookid;
//    public Integer getTransactionId() {
//        return transactionId;
//    }
//
//    public void setTransactionId(Integer transactionId) {
//        this.transactionId = transactionId;
//    }

//    public Integer getBook() {
//        return bookid;
//    }
//
//    public void setBook(Integer book) {
//        this.bookid = bookid;
//    }

    public UserBookHistoryEntity(){

    }

    public UserBookHistoryEntity(Integer userId, String isueDate, String returnDate, Integer bookId, Integer transactionId){
        this.userid=userId;
        this.issueDate=isueDate;
        this.returnDate=returnDate;
        this.bookid=bookId;
        this.transactionId=transactionId;

    }


    public UserBookHistoryEntity(Integer transactionId, Integer userId, Integer bookId, String isueDate, String returnDate){ }

    public Integer getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public Integer getBookid() {
        return bookid;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
    }

    //    public Integer getUser() {
//        return userid;
//    }
//
//    public void setUser(Integer userid) {
//        this.userid = userid;
//    }
//
////    public UserBookHistoryEntity(Integer transactionId,Integer userid, Integer bookid, String issueDate, String returnDate) {
////        this.transactionId = transactionId;
////        this.userid = userid;
////        this.bookid = bookid;
////        this.issueDate = issueDate;
////        this.returnDate = returnDate;
////    }
//
//    public String getIssueDate() {
//        return issueDate;
//    }
//
//    public void setIssueDate(String issueDate) {
//        this.issueDate = issueDate;
//    }
//
//    public String getReturnDate() {
//        return returnDate;
//    }
//
//    public void setReturnDate(String returnDate) {
//        this.returnDate = returnDate;
//    }
}
