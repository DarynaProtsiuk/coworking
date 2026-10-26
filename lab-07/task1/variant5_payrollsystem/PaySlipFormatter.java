package variant5_payrollsystem;

public class PaySlipFormatter {

    public String format(EmployeePayrollData emp, PayrollResult result) {
        return String.format(
                "--------------------------------------------------%n" +
                        "РОЗРАХУНКОВИЙ ЛИСТОК ЗА МІСЯЦЬ%n" +
                        "Співробітник: %s (ІПН: %s)%n" +
                        "Відпрацьовано годин: %d год%n" +
                        "--------------------------------------------------%n" +
                        "Нараховано (Gross): %.2f грн%n" +
                        "- Основна оплата: %.2f грн%n" +
                        "- Премія: %.2f грн%n" +
                        "Утримано податків: %.2f грн%n" +
                        "- ПДФО (18%%): %.2f грн%n" +
                        "- Військовий збір (1.5%%): %.2f грн%n" +
                        "--------------------------------------------------%n" +
                        "ДО ВИПЛАТИ (Net): %.2f грн%n" +
                        "--------------------------------------------------",
                emp.getFullName(), emp.getTaxId(),
                emp.getHoursWorked(),
                result.grossSalary(), result.baseSalary(), result.bonus(),
                result.totalTaxes(), result.pitTax(), result.militaryTax(),
                result.netSalary()
        );
    }
}