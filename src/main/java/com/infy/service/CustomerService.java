package com.infy.service;

import com.infy.dto.CallDetailsDTO;
import com.infy.dto.CustomerDTO;
import com.infy.dto.FriendFamilyDTO;
import com.infy.dto.LoginDTO;
import com.infy.entity.CallDetails;
import com.infy.entity.Customer;
import com.infy.entity.FriendFamily;
import com.infy.exception.NoSuchCustomerException;
import com.infy.repository.CallDetailsRepository;
import com.infy.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
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

    public CustomerDTO getCustomerProfile(String phoneNo) throws NoSuchCustomerException {
        CustomerDTO customerDTO = null;
        Optional<Customer> cust = customerRepository.findById(Long.parseLong(phoneNo));
        if(cust.isPresent())
            customerDTO = (new CustomerDTO()).customerEntityToDTO(cust.get());
        else {
            throw new NoSuchCustomerException("Customer does not exist :" + phoneNo);
        }
        return customerDTO;
    }

    public List<CallDetailsDTO> getCustomerCallDetails(Long phoneNo) {
        List<CallDetails> callDetailList = callDetailsRepository.findByCalledBy(phoneNo);
        List<CallDetailsDTO> callDetailsDTOList = new ArrayList<>();
        for(CallDetails callDetail : callDetailList ) {
           callDetailsDTOList.add((new CallDetailsDTO()).callDetailsEntityToDTo(callDetail));
        }
        return callDetailsDTOList;
    }

    public void saveFriend(Long phoneNo, FriendFamilyDTO friendFamilyDTO) {
        FriendFamily friendFamily = friendFamilyDTO.friendFamilyDTOToEntity();
        List<FriendFamily> friendFamilyList = new ArrayList<>();
        friendFamilyList.add(friendFamily);

        Customer c = customerRepository.findById(phoneNo).get();
        c.setFriendFamilyList(friendFamilyList);

    }
}
