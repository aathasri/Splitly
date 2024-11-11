package com.aathasri.splitly.friendship;

import java.time.LocalDate;

public class Friendship {

    private int id;
    private int senderId;
    private int receiverId;
    private LocalDate requestDate;
    private FriendshipStatus status;

    public Friendship(int id, int senderId, int receiverId, LocalDate requestDate, FriendshipStatus status) {
        this.id = id;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.requestDate = requestDate;
        this.status = status;
    }

    public Friendship(int senderId, int receiverId, LocalDate requestDate, FriendshipStatus status) {
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.requestDate = requestDate;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSenderId() {
        return senderId;
    }

    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    public int getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(int receiverId) {
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
