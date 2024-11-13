package com.aathasri.splitly.friendship;

import java.time.LocalDate;

public class Friendship {

    private Long id;
    private Long senderId;
    private Long receiverId;
    private LocalDate requestDate;
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
