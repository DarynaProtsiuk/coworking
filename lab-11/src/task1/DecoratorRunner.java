package task1;

public class DecoratorRunner {

    public static void main(String[] args) {
        scenarioStandardRoom();
        scenarioBreakfastViewParking();
        scenarioLateCheckoutBabyCot();
    }

    private static void print(String title, Room room) {
        Log.write("Booking", title);
        Log.write("Booking", "опис: " + room.getDescription());
        Log.write("Booking", "разом за ніч: " + room.getPrice() + " грн");
        System.out.println();
    }

    // Сценарій 1: стандартний номер без послуг
    private static void scenarioStandardRoom() {
        Room room = new StandardRoom();
        print("Сценарій 1: стандартний номер ", room);
    }

    // Сценарій 2: сніданок + вид на гори + паркування
    private static void scenarioBreakfastViewParking() {
        Room room = new ParkingService(
                new MountainViewService(
                        new BreakfastService(
                                new StandardRoom())));
        print("Сценарій 2: сніданок, вид на гори, паркування ", room);
    }

    // Сценарій 3: інший номер, пізній виїзд + дитяче ліжко
    private static void scenarioLateCheckoutBabyCot() {
        Room room = new BabyCotService(
                new LateCheckoutService(
                        new StandardRoom()));
        print("Сценарій 3: пізній виїзд, дитяче ліжко ", room);
    }
}
