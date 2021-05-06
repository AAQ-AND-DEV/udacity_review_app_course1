package com.aaqanddev.jwdnd.c1.review.model;

public class ChatMessage {
    private Integer messageid;
    private String username;
    private String messagetext;

    public ChatMessage(Integer messageid, String username, String messagetext) {
        this.messageid = messageid;
        this.username = username;
        this.messagetext = messagetext;
    }

    public Integer getMessageid() {
        return messageid;
    }

    public void setMessageid(Integer messageid) {
        this.messageid = messageid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessagetext() {
        return messagetext;
    }

    public void setMessagetext(String messagetext) {
        this.messagetext = messagetext;
    }

    @Override
    public String toString() {
        return username + ": " + messagetext;
    }
}
