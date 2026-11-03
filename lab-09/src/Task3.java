import java.util.ArrayList;
import java.util.List;

public class Task3 {

    public static void log(String source, String message) {
        String time = java.time.LocalTime.now()
                .format(java.time.format.DateTimeFormatter.ofPattern("HH:mm:ss"));

        System.out.println("[" + time + "] [" + source + "] " + message);
    }

    public static void main(String[] args) {

        List<String> spa = new ArrayList<>();
        spa.add("Сауна");
        spa.add("Басейн");

        log("Hotel", "Початок роботи готелю");


        log("Hotel", "Створення типового пакета");

        AccommodationPackage standardPackage = new AccommodationPackage(
                "Лижний тиждень",
                "Сніданок та вечеря",
                "Трансфер до підйомника",
                spa,
                new SkiPass(7, "VIP"),
                new Discount("Winter", 10)
        );

        log("Hotel", "Типовий пакет створено");


        log("Hotel", "Створення пакета для гостя 1");

        AccommodationPackage guest1 = standardPackage.copy();

        guest1.addSpaProcedure("Масаж");
        guest1.setSkiPassDays(10);
        guest1.setDiscountPercent(20);

        log("Hotel", "Пакет гостя 1 налаштовано");


        log("Hotel", "Створення пакета для гостя 2");

        AccommodationPackage guest2 = standardPackage.copy();

        guest2.setSkiPassDays(5);

        log("Hotel", "Пакет гостя 2 налаштовано");


        log("Hotel", "Створення пакета для гостя 3");

        AccommodationPackage guest3 = standardPackage.copy();

        guest3.setDiscountPercent(25);

        log("Hotel", "Пакет гостя 3 налаштовано");


        log("Hotel", "Налаштування всіх пакетів завершено");

        System.out.println("\n РЕЗУЛЬТАТ ");

        System.out.println("\nТиповий пакет:");
        System.out.println(standardPackage);

        System.out.println("\nПакет гостя 1:");
        System.out.println(guest1);

        System.out.println("\nПакет гостя 2:");
        System.out.println(guest2);

        System.out.println("\nПакет гостя 3:");
        System.out.println(guest3);
    }
}
