package com.aathasri.splitly.repository;

import com.aathasri.splitly.model.Friendship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FriendshipRepository extends JpaRepository<Friendship, Long> {

    @Query("SELECT f FROM Friendship f WHERE f.senderId = :userId OR f.receiverId = :userId")
    List<Friendship> findFriendshipsByUserId(@Param("userId") Long userId);
}
