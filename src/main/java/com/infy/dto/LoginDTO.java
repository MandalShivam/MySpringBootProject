package com.infy.dto;

public class LoginDTO {
    long phoneNo;
    String password;

    public LoginDTO() {
    }

    public LoginDTO(long phoneNo, String password) {
        this.phoneNo = phoneNo;
        this.password = password;
    }

    public long getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(long phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginDTO{" +
                "phoneNo=" + phoneNo +
                ", password='" + password + '\'' +
                '}';
    }
}
