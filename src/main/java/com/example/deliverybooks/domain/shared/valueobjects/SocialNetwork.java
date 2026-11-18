package com.example.deliverybooks.domain.shared.valueobjects;

public enum SocialNetwork {
    FACEBOOK("Facebook"),
    INSTAGRAM("Instagram"),
    LINKEDIN("LinkedIn"),
    TIKTOK("TikTok"),
    YOUTUBE("YouTube"),
    TWITTER("Twitter"),;

    private final String network;

    SocialNetwork(String network) {
        this.network = network;
    }

    public String getNetwork() {
        return this.network;
    }
}
