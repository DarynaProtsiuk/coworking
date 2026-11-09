package src.task4;

public class RealBillingService implements BillingService {

    @Override
    public void charge(Employee employee, int room,
                       String service, double amount) {

        System.out.println(
                "[10:00:01] [RealBillingService] "
                        + "Нараховано послугу: " + service
                        + " для номера " + room
                        + ". Сума: " + amount + " грн"
        );
    }

    @Override
    public void viewBill(Employee employee, int room) {

        System.out.println(
                "[10:00:02] [RealBillingService] "
                        + "Повний рахунок гостя з номера " + room
                        + ": 2500 грн"
        );
    }

    @Override
    public void refund(Employee employee, int room,
                       double amount) {

        System.out.println(
                "[10:00:03] [RealBillingService] "
                        + "Повернення коштів гостю з номера "
                        + room + ". Сума: " + amount + " грн"
        );
    }
}
