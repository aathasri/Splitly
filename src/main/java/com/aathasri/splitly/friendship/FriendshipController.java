package com.aathasri.splitly.friendship;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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
                                 @RequestParam(required = false) Long senderId,
                                 @RequestParam(required = false) Long recieverId,
                                 @RequestParam(required = false) LocalDate requestDate,
                                 @RequestParam(required = false) FriendshipStatus status) {
    friendshipService.updateFriendship(friendshipId, senderId, recieverId, requestDate, status);
    }


}
