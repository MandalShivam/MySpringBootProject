package com.infy.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.criteria.CriteriaBuilder;

@Entity
public class Plan {
    @Id
    @Column(name = "plan_id",nullable = false)
    private Integer plan_id;
    @Column(name = "plan_name",nullable = false)
    private String planName;
    @Column(name = "national_rate" ,nullable = false)
    private Integer nationalRate;
    @Column(name = "local_rate",nullable = false)
    private Integer localRate;

    public Plan() {
    }

    public Integer getPlan_id() {
        return plan_id;
    }

    public void setPlan_id(Integer plan_id) {
        this.plan_id = plan_id;
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

    public Plan(Integer plan_id, String planName, Integer nationalRate, Integer localRate) {
        this.plan_id = plan_id;
        this.planName = planName;
        this.nationalRate = nationalRate;
        this.localRate = localRate;
    }
}
