package src.task4;

public interface BillingService {
    void charge(Employee employee, int room, String service,
                double amount);

    void viewBill(Employee employee, int room);

    void refund(Employee employee, int room, double amount);

}
