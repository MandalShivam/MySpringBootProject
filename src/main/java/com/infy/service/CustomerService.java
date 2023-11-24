package com.infy.service;

import com.infy.dto.CallDetailsDTO;
import com.infy.dto.CustomerDTO;
import com.infy.dto.FriendFamilyDTO;
import com.infy.dto.LoginDTO;
import com.infy.entity.CallDetails;
import com.infy.entity.Customer;
import com.infy.repository.CallDetailsRepository;
import com.infy.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CallDetailsRepository callDetailsRepository;

    public void createCustomer(CustomerDTO customerDTO) {
        Customer cust =customerDTO.customerDtoToEntity(customerDTO);
        customerRepository.save(cust);
    }

    public boolean login(LoginDTO loginDTO) {
        Optional<Customer> cust = customerRepository.findById(loginDTO.getPhoneNo());
        if(cust.isPresent() && cust.get()!=null && loginDTO.getPassword().equals(cust.get().getPassword())){
            return true;
        }
        return false;
    }

    public CustomerDTO getCustomerProfile(Long phoneNo) {
        CustomerDTO customerDTO = null;
        Optional<Customer> cust = customerRepository.findById(phoneNo);
        if(cust.isPresent())
            customerDTO = (new CustomerDTO()).customerEntityToDTO(cust.get());
        return customerDTO;
    }

    public List<CallDetailsDTO> getCustomerCallDetails(Long phoneNo) {
        List<CallDetails> callDetailList = callDetailsRepository.findByCalledById(phoneNo);
        List<CallDetailsDTO> callDetailsDTOList = new ArrayList<>();
        for(CallDetails callDetail : callDetailList ) {
           callDetailsDTOList.add((new CallDetailsDTO()).callDetailsEntityToDTo(callDetail));
        }
        return callDetailsDTOList;
    }

    public void saveFriend(Long phoneNo, FriendFamilyDTO friendFamilyDTO) {


    }
}
