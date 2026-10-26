package variant5_payrollsystem;

import java.math.BigDecimal;

public record PayrollResult(
        BigDecimal baseSalary,
        BigDecimal bonus,
        BigDecimal grossSalary,
        BigDecimal pitTax,
        BigDecimal militaryTax,
        BigDecimal totalTaxes,
        BigDecimal netSalary) {
}