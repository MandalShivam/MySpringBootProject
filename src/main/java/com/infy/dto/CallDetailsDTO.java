package com.infy.dto;

import com.infy.entity.CallDetails;

import java.util.Date;

public class CallDetailsDTO {
    long calledBy;

    long calledTo;

    Date calledOn;

    int duration;

    public CallDetailsDTO() {
    }

    public CallDetailsDTO(long calledBy, long calledTo, Date calledOn, int duration) {
        this.calledBy = calledBy;
        this.calledTo = calledTo;
        this.calledOn = calledOn;
        this.duration = duration;
    }

    public long getCalledBy() {
        return calledBy;
    }

    public void setCalledBy(long calledBy) {
        this.calledBy = calledBy;
    }

    public long getCalledTo() {
        return calledTo;
    }

    public void setCalledTo(long calledTo) {
        this.calledTo = calledTo;
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

    //convert entity to dto
    public CallDetailsDTO callDetailsEntityToDTo(CallDetails callDetails) {
        CallDetailsDTO callDetailsDTO = new CallDetailsDTO();
        callDetailsDTO.setCalledBy(callDetails.getCalledBy());
        callDetailsDTO.setCalledOn(callDetails.getCalledOn());
        callDetailsDTO.setCalledTo(callDetails.getCalledTo());
        callDetailsDTO.setDuration(callDetails.getDuration());
        return callDetailsDTO;

    }
}
