package com.infy.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer {
    @Id
    @Column(name = "phoneNo", nullable = false)
    private Long phoneNo;
    @Column(nullable = false,length = 50)
    private String name;
    @Column(nullable = false,length = 50)
    private String address;
    @Column(nullable = false)
    private int age;
    @Column(nullable = false,length = 50)
    private String password;
    @Column(nullable = false,length = 1)
    private char gender;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "plan_id")
    private Plan plan;

    @OneToMany(cascade = CascadeType.MERGE)
    private List<FriendFamily> friendFamilyList = new ArrayList<>();

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }

    public List<FriendFamily> getFriendFamilyList() {
        return friendFamilyList;
    }

    public void setFriendFamilyList(List<FriendFamily> friendFamilyList) {
        this.friendFamilyList = friendFamilyList;
    }




    public Customer() {
    }

    public Customer(Long phoneNo, String name, String address, int age, String password, char gender) {
        this.phoneNo = phoneNo;
        this.name = name;
        this.address = address;
        this.age = age;
        this.password = password;
        this.gender = gender;
    }

    public Long getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(Long phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }
}
