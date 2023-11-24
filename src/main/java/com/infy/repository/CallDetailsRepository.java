package com.infy.repository;

import com.infy.entity.CallDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CallDetailsRepository extends JpaRepository<CallDetails,Long> {
    List<CallDetails> findByCalledById(long calledBy);
}
