package com.aathasri.splitly.friendship;

import java.time.LocalDate;

public class Friendship {

    private long id;
    private long senderId;
    private long receiverId;
    private LocalDate requestDate;
    private FriendshipStatus status;

    public Friendship() {
    }

    public Friendship(long id, long senderId, long receiverId, LocalDate requestDate, FriendshipStatus status) {
        this.id = id;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.requestDate = requestDate;
        this.status = status;
    }

    public Friendship(long senderId, long receiverId, LocalDate requestDate, FriendshipStatus status) {
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.requestDate = requestDate;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getSenderId() {
        return senderId;
    }

    public void setSenderId(long senderId) {
        this.senderId = senderId;
    }

    public long getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(long receiverId) {
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
