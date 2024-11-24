package com.aathasri.splitly.friendship;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Service
public class FriendshipService {

    private final FriendshipRepository friendshipRepository;

    @Autowired
    public FriendshipService(FriendshipRepository friendshipRepository) {
        this.friendshipRepository = friendshipRepository;
    }

    public List<Friendship> getFriendship() {
        return friendshipRepository.findAll();
    }

    public void addNewFriendship(Friendship friendship) {

        //TODO Check if friendship exists already
        friendshipRepository.save(friendship);
    }

    public void deleteFriendship(Long friendshipId) {
        boolean exists = friendshipRepository.existsById(friendshipId);
        if (!exists) {
            throw new IllegalStateException("Friendship with id " + friendshipId + " does not exist");
        }
        friendshipRepository.deleteById(friendshipId);
    }

    @Transactional
    public void updateFriendship(Long friendshipId, Long senderId, Long recieverId, LocalDate requestDate, FriendshipStatus friendshipStatus) {
        Friendship friendship = friendshipRepository.findById(friendshipId)
                .orElseThrow(() -> new IllegalStateException(
                        "friendship with id " + " does not exist"
                ));

        if (senderId != null && senderId > 0 && !Objects.equals(friendship.getSenderId(), senderId)) {
            friendship.setSenderId(senderId);
        }

        if (recieverId != null && recieverId > 0 && !Objects.equals(friendship.getReceiverId(), recieverId)) {
            friendship.setReceiverId(recieverId);
        }

        if (requestDate != null && requestDate.equals(friendship.getRequestDate())) {
            if (requestDate.isAfter(LocalDate.now())) {
                throw new IllegalStateException("request date cannot be in the future");
            }
            if (requestDate.isBefore(LocalDate.now().minusYears(1))) {
                throw new IllegalStateException("request dat cannot be more than 1 year in the past");
            }
        }

        if (friendshipStatus != null && !friendshipStatus.equals(friendship.getStatus())) {
            throw new IllegalStateException("invalid friendship status");
        }
    }



}
