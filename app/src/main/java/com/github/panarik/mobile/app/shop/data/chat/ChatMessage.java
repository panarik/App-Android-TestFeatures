package com.github.panarik.mobile.app.shop.data.chat;

public class ChatMessage {

    String text;
    String name;
    String imegeUrl;

    public ChatMessage() {
    }

    public ChatMessage(String text, String name, String imegeUrl) {
        this.text = text;
        this.name = name;
        this.imegeUrl = imegeUrl;
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

    public String getImegeUrl() {
        return imegeUrl;
    }

    public void setImegeUrl(String imegeUrl) {
        this.imegeUrl = imegeUrl;
    }
}
