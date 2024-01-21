package com.infy.controller;

import com.infy.dto.PlanDTO;
import com.infy.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class PlanController {

    @Autowired
    PlanService planService;

    @GetMapping("/plans")
    public List<PlanDTO> getAllPlans() {
        return planService.getAllPlans();
    }
}
