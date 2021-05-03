package com.aaqanddev.jwdnd.c1.review.model;

public class ChatMessage {
    private String username;
    private String msg;

    public ChatMessage(String username, String alteredMsg) {
        this.username = username;
        this.msg = alteredMsg;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return username + ": " + msg;
    }
}
