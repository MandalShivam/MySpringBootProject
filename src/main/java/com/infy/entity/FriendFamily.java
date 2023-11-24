package com.infy.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.criteria.CriteriaBuilder;

@Entity
public class FriendFamily {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(name = "phone_no")
    private long phoneNo;
    @Column(name = "friend_and_family")
    private long friendFamily;

    public FriendFamily() {
    }

    public FriendFamily(Integer id, long phoneNo, long friendFamily) {
        this.id = id;
        this.phoneNo = phoneNo;
        this.friendFamily = friendFamily;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public long getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(long phoneNo) {
        this.phoneNo = phoneNo;
    }

    public long getFriendFamily() {
        return friendFamily;
    }

    public void setFriendFamily(long friendFamily) {
        this.friendFamily = friendFamily;
    }
}
