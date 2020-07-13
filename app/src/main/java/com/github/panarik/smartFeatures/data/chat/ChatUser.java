package com.github.panarik.smartFeatures.data.chat;

public class ChatUser {

    private String userName;
    private String userEmail;
    private String userId;

    //конструктор с полями null
    public ChatUser() {
    }

    public ChatUser(String userName, String userEmail, String userId) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
