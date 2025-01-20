package com.aathasri.splitly.controller;

import com.aathasri.splitly.service.FriendshipService;
import com.aathasri.splitly.model.Friendship;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/friendship")
public class FriendshipController {

    private final FriendshipService friendshipService;

    @Autowired
    public FriendshipController(FriendshipService friendshipService) {
        this.friendshipService = friendshipService;
    }


    @GetMapping
    public List<Friendship> getFriendship() {
        return friendshipService.getFriendship();
    }

    @PostMapping
    public void registerNewFriendship(@RequestBody Friendship friendship) {
        friendshipService.addNewFriendship(friendship);
    }

    @DeleteMapping(path = "{friendshipId}")
    public void deleteFriendship(@PathVariable("friendshipId") Long friendshipId) {
        friendshipService.deleteFriendship(friendshipId);
    }

    @PutMapping(path = "{friendshipId}")
    public void updateFriendship(@PathVariable("friendshipId") Long friendshipId,
                                 @Valid @RequestBody Friendship friendship) {
    friendshipService.updateFriendship(friendshipId, friendship);
    }


}
