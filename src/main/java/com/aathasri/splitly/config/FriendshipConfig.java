package com.aathasri.splitly.config;

import com.aathasri.splitly.repository.FriendshipRepository;
import com.aathasri.splitly.enums.FriendshipStatus;
import com.aathasri.splitly.model.Friendship;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class FriendshipConfig {

    @Bean
    CommandLineRunner commandLineRunnerFriendship(FriendshipRepository repository) {
        return args -> {
            Friendship friends = new Friendship(
                    1L,
                    2L,
                    LocalDate.now().minusDays(5),
                    FriendshipStatus.ACCEPTED
            );

            repository.saveAll(
                    List.of(friends)
            );
        };



    }

}
