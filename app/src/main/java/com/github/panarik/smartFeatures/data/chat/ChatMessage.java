package com.github.panarik.smartFeatures.data.chat;

public class ChatMessage {

    private String text;
    private String name;
    private String sender; //отправитель сообщения
    private String recipient; //получатель сообщения
    private String imageUrl;
    private Boolean isMine; //сообщение отправлено или получено


    public ChatMessage() {
    }

    public ChatMessage(String text, String name, String sender, String recipient, String imageUrl, Boolean isMine) {
        this.text = text;
        this.name = name;
        this.sender = sender;
        this.recipient = recipient;
        this.imageUrl = imageUrl;
        this.isMine = isMine;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }


    public Boolean getIsMine() {
        return isMine;
    }

    public void setIsMine(Boolean mine) {
        isMine = mine;
    }
}
