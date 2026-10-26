package variant5_payrollsystem;

public class PayrollValidator {

    public void validate(EmployeePayrollData emp) {
        if (emp == null) {
            throw new IllegalArgumentException("Об'єкт emp не може бути null.");
        }

        if (emp.getTaxId() == null || emp.getTaxId().isBlank() || emp.getTaxId().length() != 10) {
            throw new IllegalArgumentException("Некоректний податковий номер (РНОКПП) співробітника.");
        }

        if (emp.getHoursWorked() < 0 || emp.getHoursWorked() > 350) {
            throw new IllegalArgumentException("Недопустима кількість відпрацьованих годин за місяць.");
        }
    }
}