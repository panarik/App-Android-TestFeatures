package com.github.panarik.smartFeatures.data.chat;

public class ChatUser {

    private String userName;
    private String userEmail;
    private String userId;
    private int avatarMockUpResource;

    //конструктор с полями null
    public ChatUser() {
    }

    public ChatUser(String userName, String userEmail, String userId, int avatarMockUpResource) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.userId = userId;
        this.avatarMockUpResource = avatarMockUpResource;
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

    public int getAvatarMockUpResource() {
        return avatarMockUpResource;
    }

    public void setAvatarMockUpResource(int avatarMockUpResource) {
        this.avatarMockUpResource = avatarMockUpResource;
    }
}


