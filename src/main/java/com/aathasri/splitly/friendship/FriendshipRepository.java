package com.aathasri.splitly.friendship;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FriendshipRepository extends JpaRepository<Friendship, Long> {

    @Query("SELECT f FROM Friendship WHERE f.senderId = :userId OR f.recieverId = :userId")
    List<Friendship> findFriendshipsByUserID(@Param("userId") Long userId);
}
