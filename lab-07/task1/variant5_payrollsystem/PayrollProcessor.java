package variant5_payrollsystem;

public class PayrollProcessor {
    private final PayrollValidator validator = new PayrollValidator();
    private final PayrollCalculator calculator = new PayrollCalculator();
    private final PaySlipFormatter paySlipFormatter = new PaySlipFormatter();
    private final BankRegistryExporter bankRegistryExporter = new BankRegistryExporter();
    private final AuditLogger auditLogger = new AuditLogger();

    public void calculateAndProcessSalary(EmployeePayrollData emp) {
        validator.validate(emp);
        PayrollResult result = calculator.calculate(emp);
        String paySlip = paySlipFormatter.format(emp, result);
        bankRegistryExporter.export(emp, result);
        auditLogger.log(emp, result);
        System.out.println(paySlip);
    }
}