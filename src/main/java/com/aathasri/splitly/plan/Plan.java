package com.aathasri.splitly.plan;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.util.Currency;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Plan {
    @Id
    @SequenceGenerator(
            name = "plan_sequence",
            sequenceName = "plan_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "plan_sequence"
    )
    private Long id;
    @NotNull(message = "plan name cannot be null")
    @Size(max = 25, message = "plan name must not exceed 25 characters")
    private String name;
    @NotNull(message = "plan price amount cannot be null")
    @Positive(message = "plan price must be greater than 0")
    private BigDecimal price;
    @NotNull(message = "plan currency cannot be null")
    private Currency currency;
    @NotNull(message = "plan payment date cannot be null")
    @FutureOrPresent(message = "plan payment date cannot be in the past")
    private LocalDate paymentDate;
    @NotNull(message = "plan payment interval cannot be null")
    private Period paymentInterval;
    @Min(value = 1, message = "plan total shares cannot be less than 1")
    private Double totalShares;

    public Plan() {
    }

    public Plan(Long id, String name, BigDecimal price, Currency currency, LocalDate paymentDate, Period paymentInterval) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.currency = currency;
        this.paymentDate = paymentDate;
        this.paymentInterval = paymentInterval;
    }

    public Plan(String name, BigDecimal price, Currency currency, LocalDate paymentDate, Period paymentInterval) {
        this.name = name;
        this.price = price;
        this.currency = currency;
        this.paymentDate = paymentDate;
        this.paymentInterval = paymentInterval;
    }

    public void copyFrom(Plan plan){
        this.name = plan.name;
        this.price = plan.price;
        this.currency = plan.currency;
        this.paymentDate = plan.paymentDate;
        this.paymentInterval = plan.paymentInterval;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Period getPaymentInterval() {
        return paymentInterval;
    }

    public void setPaymentInterval(Period paymentInterval) {
        this.paymentInterval = paymentInterval;
    }

    public Double getTotalShares() {
        return totalShares;
    }

    public void setTotalShares(Double totalShares) {
        this.totalShares = totalShares;
    }

    @Override
    public String toString() {
        return "Plan{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", monthlyPrice=" + price +
                ", currency=" + currency +
                ", paymentDate=" + paymentDate +
                ", paymentInterval=" + paymentInterval +
                '}';
    }
}
