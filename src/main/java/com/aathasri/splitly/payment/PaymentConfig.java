package com.aathasri.splitly.payment;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class PaymentConfig {

    @Bean
    CommandLineRunner commandLineRunner(PaymentRepository repository) {
        return args -> {
            Payment payment1 = new Payment(
                    1L,
                    2L,
                    1L,
                    BigDecimal.valueOf(10.99),
                    LocalDate.now(),
                    "e-transfer",
                    PaymentStatus.INPROGRESS,
                    false
            );

            repository.saveAll(
                    List.of(payment1)
            );
        };
    }

}
