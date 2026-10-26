package variant5_payrollsystem;

import java.math.BigDecimal;

public class EmployeePayrollData {
    private String employeeId;
    private String fullName;
    private String taxId;
    private BigDecimal baseHourlyRate;
    private int hoursWorked;
    private BigDecimal bonusAmount;
    private String bankCardNumber;

    public String getEmployeeId() { return employeeId; }
    public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getTaxId() { return taxId; }
    public void setTaxId(String taxId) { this.taxId = taxId; }

    public BigDecimal getBaseHourlyRate() { return baseHourlyRate; }
    public void setBaseHourlyRate(BigDecimal baseHourlyRate) { this.baseHourlyRate = baseHourlyRate; }

    public int getHoursWorked() { return hoursWorked; }
    public void setHoursWorked(int hoursWorked) { this.hoursWorked = hoursWorked; }

    public BigDecimal getBonusAmount() { return bonusAmount; }
    public void setBonusAmount(BigDecimal bonusAmount) { this.bonusAmount = bonusAmount; }

    public String getBankCardNumber() { return bankCardNumber; }
    public void setBankCardNumber(String bankCardNumber) { this.bankCardNumber = bankCardNumber; }
}