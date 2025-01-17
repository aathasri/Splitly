package com.aathasri.splitly.payment;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table
public class Payment {
    @Id
    @SequenceGenerator(
            name = "payment_sequence",
            sequenceName = "payment_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "payment_sequence"
    )
    private Long id;
    @NotNull(message = "payment payerId cannot be null")
    @Positive(message = "payment payerId must be positive")
    private Long payerId;
    @NotNull(message = "payment recipientId cannot be null")
    @Positive(message = "payment recipientId must be positive")
    private Long recipientId;
    @NotNull(message = "payment planId cannot be null")
    @Positive(message = "payment planId must be positive")
    private Long planId;
    @NotNull(message = "payment amount cannot be null")
    @Positive(message = "payment amount must be greater than 0")
    private BigDecimal amount;
    @NotNull(message = "payment date cannot be null")
    @PastOrPresent(message = "payment date cannot be in the future")
    private LocalDateTime date;
    @Size(max = 120, message = "payment method must not exceed 120 characters")
    private String method;
    @NotNull(message = "payment status cannot be null")
    private PaymentStatus status;
    @NotNull(message = "payment toPlan cannot be null")
    private Boolean toPlan;

    public Payment() {
    }

    public Payment(Long id, Long payerId, Long recipientId, Long planId, BigDecimal amount, LocalDateTime date, String method, PaymentStatus status, Boolean toPlan) {
        this.id = id;
        this.payerId = payerId;
        this.recipientId = recipientId;
        this.planId = planId;
        this.amount = amount;
        this.date = date;
        this.method = method;
        this.status = status;
        this.toPlan = toPlan;
    }

    public Payment(Long payerId, Long recipientId, Long planId, BigDecimal amount, LocalDateTime date, String method, PaymentStatus status, Boolean toPlan) {
        this.payerId = payerId;
        this.recipientId = recipientId;
        this.planId = planId;
        this.amount = amount;
        this.date = date;
        this.method = method;
        this.status = status;
        this.toPlan = toPlan;
    }

    public void copyFrom(Payment payment) {
        this.payerId = payment.getPayerId();
        this.recipientId = payment.getRecipientId();
        this.planId = payment.getPlanId();
        this.amount = payment.getAmount();
        this.date = payment.getDate();
        this.method = payment.getMethod();
        this.status = payment.getStatus();
        this.toPlan = payment.getToPlan();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        return "Payment{" +
                "id=" + id +
                ", payerId=" + payerId +
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
