package com.aathasri.splitly.plan;

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
    CommandLineRunner commandLineRunner(PlanRepository repository) {
        return args -> {
            Plan spotifyTest = new Plan(
                    "Spotify",
                    BigDecimal.valueOf(10.99),
                    Currency.getInstance(Locale.CANADA),
                    LocalDate.of(2024, Month.JANUARY, 1),
                    Period.of(0,4,0)
            );
            Plan netflixTest = new Plan(
                    "Netflix",
                    BigDecimal.valueOf(15.99),
                    Currency.getInstance(Locale.CANADA),
                    LocalDate.of(2024, Month.JUNE, 15),
                    Period.of(0,1,0)
            );

            repository.saveAll(
                    List.of(spotifyTest, netflixTest)
            );
        };
    };
}