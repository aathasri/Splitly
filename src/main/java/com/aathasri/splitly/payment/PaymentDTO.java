package com.aathasri.splitly.payment;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.LocalDateTime;

// USED FOR CREATING AND UPDATING ONLY
public class PaymentDTO {
    @NotNull
    @Positive(message = "payerId must be positive")
    private Long payerId;
    @NotNull
    @Positive(message = "recipientId must be positive")
    private Long recipientId;
    @NotNull
    @Positive(message = "planId must be positive")
    private Long planId;
    @NotNull(message = "Payment amount cannot be null")
    @Positive(message = "Payment amount must be greater than 0")
    private BigDecimal amount;
    @NotNull
    private LocalDateTime date;
    @Size(max = 120, message = "Payer ID must not exceed 120 characters")
    private String method;
    @NotNull
    private PaymentStatus status;
    @NotNull
    private Boolean toPlan;

    public PaymentDTO(Long payerId, Long recipientId, Long planId, BigDecimal amount, LocalDateTime date, String method, PaymentStatus status, Boolean toPlan) {
        this.payerId = payerId;
        this.recipientId = recipientId;
        this.planId = planId;
        this.amount = amount;
        this.date = date;
        this.method = method;
        this.status = status;
        this.toPlan = toPlan;
    }

    public PaymentDTO(Payment payment) {
        this.payerId = payment.getPayerId();
        this.recipientId = payment.getRecipientId();
        this.planId = payment.getPlanId();
        this.amount = payment.getAmount();
        this.date = payment.getDate();
        this.method = payment.getMethod();
        this.status = payment.getStatus();
        this.toPlan = payment.getToPlan();
    }

    public Long getPayerId() {
        return payerId;
    }

    public void setPayerId(Long payerId) {
        this.payerId = payerId;
    }

    public Long getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(Long recipientId) {
        this.recipientId = recipientId;
    }

    public Long getPlanId() {
        return planId;
    }

    public void setPlanId(Long planId) {
        this.planId = planId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }

    public Boolean getToPlan() {
        return toPlan;
    }

    public void setToPlan(Boolean toPlan) {
        this.toPlan = toPlan;
    }

    @Override
    public String toString() {
        return "PaymentDTO{" +
                "payerId=" + payerId +
                ", recipientId=" + recipientId +
                ", planId=" + planId +
                ", amount=" + amount +
                ", date=" + date +
                ", method='" + method + '\'' +
                ", status=" + status +
                ", toPlan=" + toPlan +
                '}';
    }
}
