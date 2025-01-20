package com.aathasri.splitly.config;

import com.aathasri.splitly.model.Payment;
import com.aathasri.splitly.repository.PaymentRepository;
import com.aathasri.splitly.enums.PaymentStatus;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Configuration
public class PaymentConfig {

    @Bean
    CommandLineRunner commandLineRunnerPayment(PaymentRepository repository) {
        return args -> {
            Payment payment1 = new Payment(
                    1L,
                    2L,
                    1L,
                    BigDecimal.valueOf(10.99),
                    LocalDateTime.now(),
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
