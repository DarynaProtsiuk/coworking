package variant5_payrollsystem;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        EmployeePayrollData emp = new EmployeePayrollData();
        emp.setEmployeeId("EMP-001");
        emp.setFullName("Іваненко Іван Іванович");
        emp.setTaxId("1234567890");
        emp.setBaseHourlyRate(new BigDecimal("250.00"));
        emp.setHoursWorked(160);
        emp.setBonusAmount(new BigDecimal("2000.00"));
        emp.setBankCardNumber("0000000000000000");

        new PayrollProcessor().calculateAndProcessSalary(emp);
    }
}