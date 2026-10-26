package variant5_payrollsystem;

import java.math.BigDecimal;

public class TaxCalculator {
    private static final BigDecimal PIT_RATE = new BigDecimal("0.18");
    private static final BigDecimal MILITARY_LEVY_RATE = new BigDecimal("0.015");

    public BigDecimal calculatePit(BigDecimal gross) {
        return gross.multiply(PIT_RATE);
    }

    public BigDecimal calculateMilitaryLevy(BigDecimal gross) {
        return gross.multiply(MILITARY_LEVY_RATE);
    }
}