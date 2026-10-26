package variant5_payrollsystem;

import java.math.BigDecimal;

public class PayrollCalculator {
    private final TaxCalculator taxCalculator = new TaxCalculator();

    public PayrollResult calculate(EmployeePayrollData emp) {
        BigDecimal baseSalary = emp.getBaseHourlyRate()
                .multiply(BigDecimal.valueOf(emp.getHoursWorked()));
        BigDecimal bonus = emp.getBonusAmount();
        BigDecimal grossSalary = baseSalary.add(bonus);

        BigDecimal pitTax = taxCalculator.calculatePit(grossSalary);
        BigDecimal militaryTax = taxCalculator.calculateMilitaryLevy(grossSalary);
        BigDecimal totalTaxes = pitTax.add(militaryTax);

        BigDecimal netSalary = grossSalary.subtract(totalTaxes);

        return new PayrollResult(baseSalary, bonus, grossSalary,
                pitTax, militaryTax, totalTaxes, netSalary);
    }
}