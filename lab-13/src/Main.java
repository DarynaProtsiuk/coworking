import task2.*;
import task1.*;

public class Main {
    public static void main(String[] args) {
        task2();
        task1();
    }

    public static void task1() {
        System.out.println("\n TASK 1");

        HotelSystem hotel = new HotelSystem();

        hotel.setDayShift();

        hotel.sendRequest(new GuestRequest(RequestType.TOWELS, "Гостю потрібні рушники"));
        hotel.sendRequest(new GuestRequest(RequestType.CLEANING, "Потрібно прибрати номер"));
        hotel.sendRequest(new GuestRequest(RequestType.TECHNICAL, "Не працює кондиціонер"));
        hotel.sendRequest(new GuestRequest(RequestType.COMPLAINT, "Скарга на обслуговування"));

        hotel.setNightShift();

        hotel.sendRequest(new GuestRequest(RequestType.CLEANING, "Гість просить прибрати номер"));

        hotel.sendRequest(new GuestRequest(RequestType.UNKNOWN, "Гість просить організувати політ на Марс"));
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