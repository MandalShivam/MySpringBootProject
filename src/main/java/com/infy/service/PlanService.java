package com.infy.service;

import com.infy.dto.PlanDTO;
import com.infy.entity.Plan;
import com.infy.repository.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class PlanService {

    @Autowired
    PlanRepository planRepository;

     public List<PlanDTO> getAllPlans() {
         PlanDTO planDTO = new PlanDTO();
         List<PlanDTO> planDTOList = new ArrayList<>();
         for(Plan plan : planRepository.findAll()) {
             planDTOList.add(planDTO.planEntityToDTO(plan));
         }
         return planDTOList;

     }
}
