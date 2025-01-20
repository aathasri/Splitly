package com.aathasri.splitly.config;

import com.aathasri.splitly.repository.MembershipRepository;
import com.aathasri.splitly.model.Membership;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class MembershipConfig {

    @Bean
    CommandLineRunner commandLineRunnerMembership(MembershipRepository repository) {
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
