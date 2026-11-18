package com.example.deliverybooks.functionals_manual;

import com.example.deliverybooks.domain.shared.valueobjects.WebSite;

public class WebSiteTest {
    public static void main(String[] args) {
        try {
            WebSite website = new WebSite("https://www.google.com");
            System.out.println("Website: " + website.getValue());
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }

        try {
            WebSite website = new WebSite("www.google.com");
            System.out.println("Website: " + website.getValue());
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }

        try {
            WebSite website = new WebSite("google.com");
            System.out.println("Website: " + website.getValue());
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }

        try {
            WebSite website = new WebSite("google");
            System.out.println("Website: " + website.getValue());
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}
