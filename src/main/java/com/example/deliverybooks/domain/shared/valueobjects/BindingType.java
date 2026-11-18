package com.example.deliverybooks.domain.shared.valueobjects;

public enum BindingType {
    HARD_COVER("Hard Cover"),
    SOFT_COVER("Soft Cover");

    private final String binding;

    BindingType(String binding) {
        this.binding = binding;
    }

    public String getBinding() {
        return binding;
    }
}
