package com.infy.dto;

import com.infy.entity.FriendFamily;

public class FriendFamilyDTO {
    long phoneNo;
    long friendAndFamily;

    public FriendFamilyDTO() {
    }

    public FriendFamilyDTO(long phoneNo, long friendAndFamily) {
        this.phoneNo = phoneNo;
        this.friendAndFamily = friendAndFamily;
    }

    public long getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(long phoneNo) {
        this.phoneNo = phoneNo;
    }

    public long getFriendAndFamily() {
        return friendAndFamily;
    }

    public void setFriendAndFamily(long friendAndFamily) {
        this.friendAndFamily = friendAndFamily;
    }
    //convert dto to entity
    public FriendFamily friendFamilyDTOToEntity()
    {
        FriendFamily friendFamily = new FriendFamily();
        friendFamily.setPhoneNo(this.getPhoneNo());
        friendFamily.setFriendFamily(this.getFriendAndFamily());
        return friendFamily;
    }

}
