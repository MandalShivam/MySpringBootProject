package com.infy.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Date;

public class CallDetails {
    @Id
    @GeneratedValue
    private long id;
    @Column(nullable = false)
    private long calledBy;
    @Column(nullable = false)
    private Date calledOn;
    @Column(nullable = false)
    private long calledTo;
    @Column(nullable = false)
    private int duration;

    public CallDetails() {
    }

    public long getCalledTo() {
        return calledTo;
    }

    public void setCalledTo(long calledTo) {
        this.calledTo = calledTo;
    }

    public CallDetails(long id, long calledBy, Date calledOn, long calledTo, int duration) {
        this.id = id;
        this.calledBy = calledBy;
        this.calledOn = calledOn;
        this.calledTo = calledTo;
        this.duration = duration;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCalledBy() {
        return calledBy;
    }

    public void setCalledBy(long calledBy) {
        this.calledBy = calledBy;
    }

    public Date getCalledOn() {
        return calledOn;
    }

    public void setCalledOn(Date calledOn) {
        this.calledOn = calledOn;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
