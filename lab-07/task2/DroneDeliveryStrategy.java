package task2;

import java.math.BigDecimal;

public class DroneDeliveryStrategy  implements ShippingCostStrategy {

    @Override
    public BigDecimal calculateCost(Parcel parcel) {
        return new BigDecimal("10.00")
            .add(parcel.getWeightKg().multiply(new BigDecimal("2.00")));
    }
}

