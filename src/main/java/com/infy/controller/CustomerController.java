package com.infy.controller;

import com.infy.dto.CallDetailsDTO;
import com.infy.dto.CustomerDTO;
import com.infy.dto.FriendFamilyDTO;
import com.infy.dto.LoginDTO;
import com.infy.exception.NoSuchCustomerException;
import com.infy.service.CustomerService;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@Validated
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/customers")
    public String createCustomer(@RequestBody CustomerDTO customerDTO) {
        customerService.createCustomer(customerDTO);
        return "Customer is created successfully";
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginDTO loginDTO) {
        if (customerService.login(loginDTO))
          return "login successfull";
        return "login failed";
    }

    @GetMapping("/customers/{phoneNo}")
    public CustomerDTO getCustomerProfile(@PathVariable("phoneNo") @Pattern(regexp = "[0-9]{10}",
            message="{customer.phoneNo.invalid}")  String phoneNo) throws NoSuchCustomerException {
        return (CustomerDTO) customerService.getCustomerProfile(phoneNo);
    }

    @GetMapping("/customers/{phoneNo}/callDetails")
    public List<CallDetailsDTO> getCustomerCallDetails(@PathVariable  long phoneNo) {
        return customerService.getCustomerCallDetails(phoneNo);
      //  gfhfhjgjh
    }

    @GetMapping("/customers/{phoneNo}/friends")
    public String saveFriend(@PathVariable long phoneNo, @RequestBody FriendFamilyDTO friendFamilyDTO) {
        customerService.saveFriend(phoneNo,friendFamilyDTO);
        return "friend and family saved successfully";
    }
}
