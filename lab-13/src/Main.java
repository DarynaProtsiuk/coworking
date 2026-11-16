import task2.*;

public class Main {
    public static void main(String[] args) {
        task2();
    }

    private static void task2() {
        Logger.log("Main", "Завдання 2: нарахування послуг на рахунок гостя");

        GuestBill bill = new GuestBill("Мельник");
        BillingService service = new BillingService();

        ChargeCommand dinner = new ChargeCommand(bill, "Ресторан", "Вечеря", 1200);
        ChargeCommand massage = new ChargeCommand(bill, "SPA", "Масаж", 1500);
        ChargeCommand skis = new ChargeCommand(bill, "Прокат", "Прокат лиж", 800);

        service.execute(dinner);
        service.execute(massage);
        service.execute(skis);
        bill.printBill();

        // 2. сторнуємо помилкове нарахування SPA
        service.reverse(massage);
        bill.printBill();

        // 3. повна історія операцій
        bill.printHistory();
    }
}