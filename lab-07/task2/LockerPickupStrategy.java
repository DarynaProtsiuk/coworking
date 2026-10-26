package task2;

import java.math.BigDecimal;

public class LockerPickupStrategy  implements ShippingCostStrategy {
    // Фіксована ціна $3.00 до 5 кг, понад 5 кг — $0.80 за кожен додатковий кг
    @Override
    public BigDecimal calculateCost(Parcel parcel) {
        if (parcel.getWeightKg().compareTo(new BigDecimal("5.00")) <= 0) {
            return new BigDecimal("3.00");
        } else {
            BigDecimal extraWeight = parcel.getWeightKg().subtract(new BigDecimal("5.00"));
            return new BigDecimal("3.00").add(extraWeight.multiply(new BigDecimal("0.80")));
        }
    }
}
