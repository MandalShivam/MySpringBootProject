package com.infy.dto;
import com.infy.entity.Customer;
import com.infy.entity.Plan;
import jakarta.validation.constraints.*;

import java.util.List;

public class CustomerDTO {
    @Pattern(regexp = "[0-9]{10}", message="{customer.phoneNo.invalid}")
    String phoneNo;
    @NotNull
    String name;
    @Min(1)
    int age;
    @Pattern(regexp = "[FfMm]",message = "{customer.gender.invalid}")
    String gender;
    @NotNull
    List<Long> friendAndFamily;
    @NotNull
    String password;
    @NotNull
    String address;
    @NotNull
    PlanDTO currentPlan;

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
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
        customerDTO.setPhoneNo(customer.getPhoneNo());
        customerDTO.setName(customer.getName());
        customerDTO.setAge(customer.getAge());
        customerDTO.setAddress(customer.getAddress());
        customerDTO.setGender(Character.toString(customer.getGender()));
        PlanDTO planDTO =( new PlanDTO()).planEntityToDTO(customer.getPlan());
        customerDTO.setCurrentPlan(planDTO);
        return customerDTO;
    }

    //Checking branch
    //Convert dto to entity
    public Customer customerDtoToEntity(CustomerDTO customerDTO){
        Customer customer = new Customer();
        customer.setPhoneNo(Long.parseLong(customerDTO.getPhoneNo()));
        customer.setName(customerDTO.getName());
        customer.setPassword(customerDTO.getPassword());
        customer.setAge(customerDTO.getAge());
        customer.setAddress(customerDTO.getAddress());
        customer.setGender(customerDTO.getGender().charAt(0));
        Plan plan = (new PlanDTO()).planDTOToEntity(customerDTO.getCurrentPlan());
        customer.setPlan(plan);
        return customer;
    }
}
