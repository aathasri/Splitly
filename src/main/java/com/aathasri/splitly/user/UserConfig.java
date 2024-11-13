package com.aathasri.splitly.user;

import com.aathasri.splitly.plan.Plan;
import com.aathasri.splitly.plan.PlanRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;


@Configuration
public class UserConfig {


    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository) {
        return args -> {
            User user1 = new User(
                    "Test User 1",
                    "tester1",
                    "testUser1@gmail.com"
            );
            User user2 = new User(
                    "Test User 2",
                    "tester2",
                    "testUser2@gmail.com"
            );

            userRepository.saveAll(
                    List.of(user1, user2)
            );
        };
    };
}
