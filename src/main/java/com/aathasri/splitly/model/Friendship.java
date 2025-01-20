package com.aathasri.splitly.model;

import com.aathasri.splitly.enums.FriendshipStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

@Entity
@Table
public class Friendship {

    @Id
    @SequenceGenerator(
            name = "friendship_sequence",
            sequenceName = "friendship_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "friendship_sequence"
    )
    private Long id;
    @NotNull(message = "friendship senderId cannot be null")
    @Positive(message = "friendship senderId must be positive")
    private Long senderId;
    @NotNull(message = "friendship receiverId cannot be null")
    @Positive(message = "friendship receiverId must be positive")
    private Long receiverId;
    @NotNull(message = "friendship request date cannot be null")
    @PastOrPresent(message = "friendship request date cannot be in the future")
    private LocalDate requestDate;
    @NotNull(message = "friendship status cannot be null")
    private FriendshipStatus status;

    public Friendship() {
    }

    public Friendship(Long id, Long senderId, Long receiverId, LocalDate requestDate, FriendshipStatus status) {
        this.id = id;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.requestDate = requestDate;
        this.status = status;
    }

    public Friendship(Long senderId, Long receiverId, LocalDate requestDate, FriendshipStatus status) {
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.requestDate = requestDate;
        this.status = status;
    }

    public void copyFrom(Friendship friendship) {
        this.senderId = friendship.senderId;
        this.receiverId = friendship.receiverId;
        this.requestDate = friendship.requestDate;
        this.status = friendship.status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public Long getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Long receiverId) {
        this.receiverId = receiverId;
    }

    public LocalDate getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(LocalDate requestDate) {
        this.requestDate = requestDate;
    }

    public FriendshipStatus getStatus() {
        return status;
    }

    public void setStatus(FriendshipStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Friendship{" +
                "id=" + id +
                ", senderId=" + senderId +
                ", receiverId=" + receiverId +
                ", requestDate=" + requestDate +
                ", status=" + status +
                '}';
    }
}
