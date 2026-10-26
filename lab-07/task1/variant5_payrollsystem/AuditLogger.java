package variant5_payrollsystem;

import java.io.FileWriter;
import java.io.IOException;
import java.time.Instant;

public class AuditLogger {

    public void log(EmployeePayrollData emp, PayrollResult result) {
        String logEntry = String.format(
                "[%s] Audit Payroll: EmpID=%s, Gross=%.2f, Net=%.2f, Taxes=%.2f%n",
                Instant.now().toString(), emp.getEmployeeId(),
                result.grossSalary(), result.netSalary(), result.totalTaxes());

        try (FileWriter writer = new FileWriter("payroll_audit.log", true)) {
            writer.write(logEntry);
        } catch (IOException e) {
            System.err.println("Помилка логування аудиту: " + e.getMessage());
        }
    }
}