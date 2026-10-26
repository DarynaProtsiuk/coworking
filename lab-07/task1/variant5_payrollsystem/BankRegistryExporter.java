package variant5_payrollsystem;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BankRegistryExporter {

    public void export(EmployeePayrollData emp, PayrollResult result) {
        String monthYear = LocalDate.now().format(DateTimeFormatter.ofPattern("MM_yyyy"));
        String bankRegistryRow = String.format("%s;%s;%.2f;UAH;Salary_%s%n",
                emp.getTaxId(), emp.getBankCardNumber(), result.netSalary(), monthYear);

        try (FileOutputStream fos = new FileOutputStream("bank_payout_registry.csv", true)) {
            fos.write(bankRegistryRow.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            System.err.println("Помилка запису банківського реєстру: " + e.getMessage());
        }
    }
}