package com.dependency2.Project2.Entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="users")
public class UserOfLibraryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="UserId",nullable=false)

    @NotNull
    public Integer userId;
    public String userName;
    public String address;
    public Long phoneNo;
    public UserOfLibraryEntity(){}

    public UserOfLibraryEntity(@NotNull Integer userId, String userName, String address, Long phoneNo) {
        this.userId = userId;
        this.userName = userName;
        this.address = address;
        this.phoneNo = phoneNo;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(Long phoneNo) {
        this.phoneNo = phoneNo;
    }
}
