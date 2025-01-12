package com.aathasri.splitly.membership;

import com.aathasri.splitly.payment.PaymentDTO;
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
    public void registerMembership(@RequestBody Membership membership) {
        membershipService.addNewMembership(membership);
    }

    @DeleteMapping(path = "{membershipId}")
    public void deleteMembership(@PathVariable("membershipId") Long membershipId) {
        membershipService.deleteMembership(membershipId);
    }

    @PutMapping(path = "{membershipId}")
    public void updateMembership(@PathVariable("membershipId") Long membershipId,
                                 @RequestParam(required = false) Long planId,
                                 @RequestParam(required = false) Long memberId,
                                 @RequestParam(required = false) Boolean isAdmin,
                                 @RequestParam(required = false) Double share
                                 ) {
        membershipService.updateMembership(membershipId, planId, memberId, isAdmin, share);
    }





//    @PostMapping
//    public void registerMembership(@RequestBody MembershipDTO membershipDTO) {
//        membershipService.addNewMembership(membershipDTO);
//    }


//    @PutMapping(path = "{membershipId}")
//    public void updateMembership(@PathVariable("membershipId") Long membershipId,
//                                 @Valid @RequestParam(required = false) PaymentDTO paymentDTO
//    ) {
//        membershipService.updateMembership(membershipId, paymentDTO);
//    }
}
