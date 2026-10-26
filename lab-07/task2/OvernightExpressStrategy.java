package task2;

import java.math.BigDecimal;

public class OvernightExpressStrategy  implements ShippingCostStrategy{
    @Override
    public BigDecimal calculateCost(Parcel parcel) {
        // $50 терміновий нічний тариф + $3.00 за кг
       return new BigDecimal("50.00").add(parcel.getWeightKg().multiply(new BigDecimal("3.00")));
    }
}
