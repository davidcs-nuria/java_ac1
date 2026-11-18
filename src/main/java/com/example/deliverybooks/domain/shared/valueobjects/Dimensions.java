package com.example.deliverybooks.domain.shared.valueobjects;
import java.math.BigDecimal;

public final class Dimensions {
    public Distance height, width, length;

    public Dimensions (Distance height, Distance width, Distance length) {
        this.setHeight(height);
        this.setWidth(width);
        this.setLength(length);
    }

    public Distance getHeight() {
        return height;
    }

    public void setHeight(Distance height) {
        this.height = height;
    }

    public Distance getWidth() {
        return width;
    }

    public void setWidth(Distance width) {
        this.width = width;
    }

    public Distance getLength() {
        return length;
    }

    public void setLength(Distance length) {
        this.length = length;
    }

    public BigDecimal getVolume () {
        BigDecimal tmpWh = this.width.getMillimetersPerUnit();
        BigDecimal tmpLn = this.length.getMillimetersPerUnit();
        BigDecimal tmpHt = this.height.getMillimetersPerUnit();

        return tmpLn.multiply(tmpWh.multiply(tmpHt));
    }
}
