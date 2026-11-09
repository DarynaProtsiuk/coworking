package src.task4;

public class Main {

    public static void main(String[] args) {

        Employee waiter =
                new Employee("Іван", Role.WAITER);

        Employee accountant =
                new Employee("Олена", Role.ACCOUNTANT);

        BillingService billing =
                new BillingServiceProxy();

        System.out.println("\nЗавдання 4 ");

        System.out.println("\nСитуація 1: офіціант нараховує вечерю");

        billing.charge(
                waiter,
                305,
                "Вечеря",
                850
        );

        System.out.println("\nСитуація 2: офіціант намагається зробити повернення  ");

        billing.refund(
                waiter,
                305,
                850
        );

        System.out.println("\nСитуація 3: бухгалтер переглядає рахунок ");

        billing.viewBill(
                accountant,
                305
        );

        System.out.println("\nСитуація 4: бухгалтер оформлює замовлення");

        billing.refund(
                accountant,
                305,
                850
        );

    }
}
