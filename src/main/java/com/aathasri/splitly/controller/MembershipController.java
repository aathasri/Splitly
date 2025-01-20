package com.aathasri.splitly.controller;

import com.aathasri.splitly.service.MembershipService;
import com.aathasri.splitly.model.Membership;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/membership")
public class MembershipController {

    private final MembershipService membershipService;

    @Autowired
    public MembershipController(MembershipService membershipService) {
        this.membershipService = membershipService;
    }

    @GetMapping
    public List<Membership> getMemberships() {
        return membershipService.getMemberships();
    }

    @PostMapping
    public void registerMembership(@Valid @RequestBody Membership membership) {
        membershipService.addNewMembership(membership);
    }

    @DeleteMapping(path = "{membershipId}")
    public void deleteMembership(@PathVariable("membershipId") Long membershipId) {
        membershipService.deleteMembership(membershipId);
    }

    @PutMapping(path = "{membershipId}")
    public void updateMembership(@PathVariable("membershipId") Long membershipId,
                                 @Valid @RequestBody Membership membership
                                 ) {
        membershipService.updateMembership(membershipId, membership);
    }
}
