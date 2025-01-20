package com.aathasri.splitly.config;

import com.aathasri.splitly.model.Plan;
import com.aathasri.splitly.repository.PlanRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.Currency;
import java.util.Locale;
import java.util.List;

@Configuration
public class PlanConfig {

    @Bean
    CommandLineRunner commandLineRunnerPlan(PlanRepository repository) {
        return args -> {
            Plan spotifyTest = new Plan(
                    "Spotify",
                    BigDecimal.valueOf(10.99),
                    Currency.getInstance(Locale.CANADA),
                    LocalDate.now().plusDays(15),
                    Period.of(0,1, 0)
            );
            Plan netflixTest = new Plan(
                    "Netflix",
                    BigDecimal.valueOf(15.99),
                    Currency.getInstance(Locale.CANADA),
                    LocalDate.now().plusMonths(2),
                    Period.of(1,0,0)
            );

            repository.saveAll(
                    List.of(spotifyTest, netflixTest)
            );
        };
    };
}