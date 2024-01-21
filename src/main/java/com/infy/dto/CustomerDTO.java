package com.infy.dto;
import com.infy.entity.Customer;
import com.infy.entity.Plan;

import java.util.List;

public class CustomerDTO {
    long phoneNo;
    String name;
    int age;
    char gender;
    List<Long> friendAndFamily;
    String password;
    String address;
    PlanDTO currentPlan;

    public long getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(long phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public List<Long> getFriendAndFamily() {
        return friendAndFamily;
    }

    public void setFriendAndFamily(List<Long> friendAndFamily) {
        this.friendAndFamily = friendAndFamily;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public PlanDTO getCurrentPlan() {
        return currentPlan;
    }

    public void setCurrentPlan(PlanDTO currentPlan) {
        this.currentPlan = currentPlan;
    }

    //Converts entity to dto
    public CustomerDTO customerEntityToDTO(Customer customer) {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setName(customer.getName());
        customerDTO.setAge(customer.getAge());
        customerDTO.setAddress(customer.getAddress());
        customerDTO.setGender(customer.getGender());
        PlanDTO planDTO =( new PlanDTO()).planEntityToDTO(customer.getPlan());
        customerDTO.setCurrentPlan(planDTO);
        return customerDTO;
    }

    //Convert dto to entity
    public Customer customerDtoToEntity(CustomerDTO customerDTO){
        Customer customer = new Customer();
        customer.setPhoneNo(customerDTO.getPhoneNo());
        customer.setName(customerDTO.getName());
        customer.setPassword(customerDTO.getPassword());
        customer.setAge(customerDTO.getAge());
        customer.setAddress(customerDTO.getAddress());
        customer.setGender(customerDTO.getGender());
        Plan plan = (new PlanDTO()).planDTOToEntity(customerDTO.getCurrentPlan());
        customer.setPlan(plan);
        return customer;
    }
}
