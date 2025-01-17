package com.aathasri.splitly.membership;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

@Entity
@Table
public class Membership {
    @Id
    @SequenceGenerator(
            name = "membership_sequence",
            sequenceName = "membership_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "membership_sequence"
    )
    private Long id;
    @NotNull(message = "membership planId cannot be null")
    @Positive(message = "membership planId must be positive")
    private Long planId;
    @NotNull(message = "membership memberId cannot be null")
    @Positive(message = "membership memberId must be positive")
    private Long memberId;
    @NotNull(message = "membership isAdmin cannot be null")
    private Boolean isAdmin;
    @Positive(message = "membership amount due cannot be null")
    private BigDecimal amountDue;
    @Positive(message = "membership share must be positive")
    private Double share;

    public Membership() {
    }

    public Membership(Long id, Long planId, Long memberId, Boolean isAdmin, double share) {
        this.id = id;
        this.planId = planId;
        this.memberId = memberId;
        this.isAdmin = isAdmin;
        this.share = share;
    }

    public Membership(Long planId, Long memberId, Boolean isAdmin, double share) {
        this.planId = planId;
        this.memberId = memberId;
        this.isAdmin = isAdmin;
        this.share = share;
    }

    public void copyFrom(Membership membership) {
        this.planId = membership.getPlanId();
        this.memberId = membership.getMemberId();
        this.isAdmin = membership.getIsAdmin();
        this.share = membership.getShare();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPlanId() {
        return planId;
    }

    public void setPlanId(Long planId) {
        this.planId = planId;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Boolean admin) {
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
