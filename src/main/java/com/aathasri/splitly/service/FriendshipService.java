package com.aathasri.splitly.service;

import com.aathasri.splitly.exception.ValidationException;
import com.aathasri.splitly.model.Friendship;
import com.aathasri.splitly.repository.FriendshipRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    public List<Friendship> getFriendshipByUserId(Long userId) {
        return this.friendshipRepository.findFriendshipsByUserId(userId);
    }

    public void addNewFriendship(Friendship friendship) {

        validateFriendship(friendship);

        friendshipRepository.save(friendship);
    }

    public void deleteFriendship(Long friendshipId) {
        boolean exists = friendshipRepository.existsById(friendshipId);
        if (!exists) {
            throw new IllegalStateException("Friendship with id " + friendshipId + " does not exist");
        }
        friendshipRepository.deleteById(friendshipId);
    }

    public Set<Long> findFriends(Long userId){
        List<Friendship> friendships = getFriendshipByUserId(userId);
        Set<Long> friends = new HashSet<>();

        for (Friendship f: friendships) {
            friends.add(f.getReceiverId());
            friends.add(f.getReceiverId());
            friends.remove(userId);
        }

        return friends;
    }

    @Transactional
    public void updateFriendship(Long friendshipId, Friendship updatedFriendship) {
        Friendship originalFriendship = friendshipRepository.findById(friendshipId)
                .orElseThrow(() -> new IllegalStateException(
                        "friendship with id " + " does not exist"
                ));

        validateFriendship(updatedFriendship);

        originalFriendship.copyFrom(updatedFriendship);
    }

    private void validateFriendship(Friendship friendship) {
        ValidationException ve = new ValidationException();

        if (friendship.getReceiverId().equals(friendship.getSenderId())) {
            ve.addErrors("friendship between the same user cannot exist");
        }

        if (checkDuplicateFriendship(friendship)) {
            ve.addErrors("friendship between " + friendship.getSenderId() + " and " + friendship.getReceiverId() + " already exists");
        }

        if (ve.hasErrors()) {
            throw ve;
        }
    }

    private Boolean checkDuplicateFriendship(Friendship friendship){
        Set<Long> friends = findFriends(friendship.getSenderId());
        return friends.contains(friendship.getReceiverId());
    }
}
