package com.example.deliverybooks.functionals_manual;

import com.example.deliverybooks.domain.shared.valueobjects.SocialMediaProfile;
import com.example.deliverybooks.domain.shared.valueobjects.SocialNetwork;
import com.example.deliverybooks.domain.shared.valueobjects.WebSite;

public class SocialNetworkTest {
    public static void main(String[] args) {
        try {
            SocialMediaProfile sn = new SocialMediaProfile(SocialNetwork.TWITTER, new WebSite("https://www.youtube.com"));
            System.out.println(sn.toString());
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}