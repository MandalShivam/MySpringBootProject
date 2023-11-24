package com.infy.dto;

import com.infy.entity.Plan;

public class PlanDTO {
    Integer planId;

    String planName;

    Integer nationalRate;

    Integer localRate;

    public Integer getPlanId() {
        return planId;
    }

    public void setPlanId(Integer planId) {
        this.planId = planId;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public Integer getNationalRate() {
        return nationalRate;
    }

    public void setNationalRate(Integer nationalRate) {
        this.nationalRate = nationalRate;
    }

    public Integer getLocalRate() {
        return localRate;
    }

    public void setLocalRate(Integer localRate) {
        this.localRate = localRate;
    }

    //converts entity to dto
    public PlanDTO planEntityToDTO(Plan plan) {
        PlanDTO planDTO = new PlanDTO();
        planDTO.setLocalRate(plan.getLocalRate());
        planDTO.setNationalRate(plan.getNationalRate());
        planDTO.setPlanName(plan.getPlanName());
        planDTO.setPlanId(plan.getPlan_id());
        return planDTO;
    }

    //converts dto to entity
    public Plan planDTOToEntity(PlanDTO planDTO) {
        Plan plan = new Plan();
        plan.setPlan_id(planDTO.getPlanId());
        plan.setPlanName(planDTO.getPlanName());
        plan.setLocalRate(planDTO.getLocalRate());
        plan.setNationalRate(planDTO.getNationalRate());
        return plan;
    }

    @Override
    public String toString() {
        return "PlanDTO{" +
                "planId=" + planId +
                ", planName='" + planName + '\'' +
                ", nationalRate=" + nationalRate +
                ", localRate=" + localRate +
                '}';
    }
}
