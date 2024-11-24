package com.aathasri.splitly.friendship;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class FriendshipConfig {

    @Bean
    CommandLineRunner commandLineRunner(FriendshipRepository repository) {
        return args -> {
            Friendship friends = new Friendship(
                    1L,
                    2L,
                    LocalDate.of(2024,12,25),
                    FriendshipStatus.ACCEPTED
            );

            repository.saveAll(
                    List.of(friends)
            );
        };



    }

}
