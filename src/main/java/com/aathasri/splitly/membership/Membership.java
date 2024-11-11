package com.aathasri.splitly.membership;

import java.math.BigDecimal;

public class Membership {

    private int id;
    private int planId;
    private int memberId;
    private Boolean isAdmin;
    private BigDecimal amountDue;
    private double share;

    public Membership(int id, int planId, int memberId, Boolean isAdmin, BigDecimal amountDue, double share) {
        this.id = id;
        this.planId = planId;
        this.memberId = memberId;
        this.isAdmin = isAdmin;
        this.amountDue = amountDue;
        this.share = share;
    }

    public Membership(int planId, int memberId, Boolean isAdmin, BigDecimal amountDue, double share) {
        this.planId = planId;
        this.memberId = memberId;
        this.isAdmin = isAdmin;
        this.amountDue = amountDue;
        this.share = share;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPlanId() {
        return planId;
    }

    public void setPlanId(int planId) {
        this.planId = planId;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    public BigDecimal getAmountDue() {
        return amountDue;
    }

    public void setAmountDue(BigDecimal amountDue) {
        this.amountDue = amountDue;
    }

    public double getShare() {
        return share;
    }

    public void setShare(double share) {
        this.share = share;
    }

    @Override
    public String toString() {
        return "Membership{" +
                "id=" + id +
                ", planId=" + planId +
                ", memberId=" + memberId +
                ", isAdmin=" + isAdmin +
                ", amountDue=" + amountDue +
                ", share=" + share +
                '}';
    }
}
