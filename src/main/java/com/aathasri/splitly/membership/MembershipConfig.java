package com.aathasri.splitly.membership;

import com.aathasri.splitly.plan.Plan;
import com.aathasri.splitly.plan.PlanRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.Currency;
import java.util.List;
import java.util.Locale;

@Configuration
public class MembershipConfig {

    @Bean
    CommandLineRunner commandLineRunner(MembershipRepository repository) {
        return args -> {
            Membership spotifyMember1 = new Membership(
                    1L,
                    1L,
                    true,
                    0.25
            );

            Membership spotifyMember2 = new Membership(
                    1L,
                    2L,
                    false,
                    0.50
            );

            repository.saveAll(
                    List.of(spotifyMember1, spotifyMember2)
            );
        };
    };



}
