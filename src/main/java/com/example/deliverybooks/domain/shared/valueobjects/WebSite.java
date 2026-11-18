package com.example.deliverybooks.domain.shared.valueobjects;

import java.util.regex.Pattern;

public record WebSite(
    String url
) {
    private static final Pattern REGEX_URL = Pattern.compile("^(https?:\\/\\/)?(?:www\\.)?[-a-zA-Z0-9@:%._\\+~#=]{1,256}\\.[a-zA-Z0-9()]{1,6}\\b(?:[-a-zA-Z0-9()@:%_\\+.~#?&\\/=]*)$");
    public WebSite {
        if (url == null || url.isEmpty() || !REGEX_URL.matcher(url).matches()){
                throw new IllegalArgumentException(
                    "El formato de la URL introducida no es correcto."
                );
            }
    }

    public String getValue () {
        return url;
    }
}
