package src.task4;
class BillingServiceProxy implements BillingService {

    private RealBillingService realService;

    public BillingServiceProxy() {
        this.realService = new RealBillingService();
    }

    private boolean canView(Role role) {
        return role == Role.RECEPTIONIST
                || role == Role.ACCOUNTANT;
    }

    private boolean canRefund(Role role) {
        return role == Role.RECEPTIONIST
                || role == Role.ACCOUNTANT;
    }

    @Override
    public void charge(Employee employee, int room,
                       String service, double amount) {

        System.out.println(
                "[10:00:00] [BillingServiceProxy] "
                        + "Перевірка дозволу на нарахування..."
        );

        System.out.println(
                "[10:00:00] [BillingServiceProxy] "
                        + "Доступ дозволено."
        );

        realService.charge(employee, room, service, amount);

        AuditLog.log(
                employee.getName(),
                "Нарахування " + service,
                "УСПІШНО"
        );
    }


    @Override
    public void viewBill(Employee employee, int room) {

        System.out.println("[10:00:00] [BillingServiceProxy] " + "Перевірка дозволу на перегляд рахунку...");

        if (!canView(employee.getRole())) {

            System.out.println("[10:00:00] [BillingServiceProxy] " + "ВІДМОВА: Недостатньо прав для перегляду рахунку");

            AuditLog.log(
                    employee.getName(),
                    "Перегляд рахунку",
                    "ВІДМОВА"
            );

            return;
        }

        System.out.println("[10:00:00] [BillingServiceProxy] " + "Доступ дозволено.");

        realService.viewBill(employee, room);

        AuditLog.log(
                employee.getName(),
                "Перегляд рахунку",
                "УСПІШНО"
        );
    }

    @Override
    public void refund(Employee employee, int room,
                       double amount) {

        System.out.println("[10:00:00] [BillingServiceProxy] " + "Перевірка дозволу на повернення коштів...");

        if (!canRefund(employee.getRole())) {

            System.out.println("[10:00:00] [BillingServiceProxy] " + "ВІДМОВА: Недостатньо прав для операції повернення");

            AuditLog.log(
                    employee.getName(),
                    "Повернення коштів",
                    "ВІДМОВА"
            );

            return;
        }

        System.out.println("[10:00:00] [BillingServiceProxy] " + "Доступ дозволено.");

        realService.refund(employee, room, amount);

        AuditLog.log(
                employee.getName(),
                "Повернення коштів",
                "УСПІШНО"
        );
    }
}