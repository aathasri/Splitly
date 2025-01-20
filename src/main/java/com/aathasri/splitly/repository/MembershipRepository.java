package com.aathasri.splitly.repository;

import com.aathasri.splitly.model.Membership;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MembershipRepository extends JpaRepository<Membership, Long> {

    @Query("SELECT m FROM Membership m WHERE m.planId = :planId")
    List<Membership> findMembershipsForPlan(@Param("planId") Long planId);

}
