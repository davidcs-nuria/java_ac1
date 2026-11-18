package com.example.deliverybooks.domain.shared.valueobjects;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class DistanceRegister implements Comparable<DistanceRegister> {

    // Escala de 9 decimales para proteger los restos decimales en divisiones complejas
    private static final int SCALE = 9;
    private static final RoundingMode ROUNDING_MODE = RoundingMode.HALF_UP;

    private final BigDecimal distanceInMillimeters;

    /**
     * Constructor por defecto. Si no se especifica nada,
     * inicializa la distancia en 0 milímetros.
     */
    public DistanceRegister() {
        this.distanceInMillimeters = BigDecimal.ZERO.setScale(SCALE, ROUNDING_MODE);
    }

    /**
     * Constructor principal. Recibe el valor y la unidad de distancia,
     * convirtiéndolo y almacenándolo internamente en milímetros.
     */
    public DistanceRegister(BigDecimal value, Distance unit) {
        Objects.requireNonNull(value, "Value cannot be null");
        Objects.requireNonNull(unit, "Unit cannot be null");

        if (value.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Distance cannot be negative.");
        }

        // Conversión interna instantánea a milímetros (valor * factor de la unidad)
        BigDecimal calculatedMillimeters = value.multiply(unit.getMillimetersPerUnit());
        this.distanceInMillimeters = calculatedMillimeters.setScale(SCALE, ROUNDING_MODE);
    }

    /**
     * Devuelve el valor numérico de la distancia en la unidad especificada.
     */
    public BigDecimal getValueIn(Distance targetUnit) {
        Objects.requireNonNull(targetUnit, "Target unit cannot be null");
        return this.distanceInMillimeters.divide(targetUnit.getMillimetersPerUnit(), SCALE, ROUNDING_MODE);
    }

    /**
     * Función estática independiente para convertir un valor directamente
     * de una unidad origen a otra unidad destino.
     */
    public static BigDecimal convert(BigDecimal value, Distance sourceUnit, Distance targetUnit) {
        Objects.requireNonNull(value, "Value cannot be null");
        Objects.requireNonNull(sourceUnit, "Source unit cannot be null");
        Objects.requireNonNull(targetUnit, "Target unit cannot be null");

        if (value.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Distance cannot be negative.");
        }

        BigDecimal millimeters = value.multiply(sourceUnit.getMillimetersPerUnit());
        return millimeters.divide(targetUnit.getMillimetersPerUnit(), SCALE, ROUNDING_MODE);
    }

    /**
     * Compara esta distancia con otra. 
     * Retorna estrictamente:
     *  -1 si esta distancia es menor que la dada.
     *   0 si son exactamente iguales.
     *   1 si esta distancia es superior a la dada.
     */
    @Override
    public int compareTo(DistanceRegister other) {
        if (other == null) {
            return 1;
        }

        int rawResult = this.distanceInMillimeters.compareTo(other.distanceInMillimeters);

        if (rawResult < 0) {
            return -1;
        } else if (rawResult > 0) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DistanceRegister other = (DistanceRegister) o;
        return this.compareTo(other) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(distanceInMillimeters);
    }

    @Override
    public String toString() {
        return distanceInMillimeters.stripTrailingZeros().toPlainString() + " " + Distance.MILLIMETER.getAbbreviation();
    }
}
