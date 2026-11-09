package task2;

public class FacadeRunner {

    public static void main(String[] args) {
        CheckInFacade facade = new CheckInFacade();

        scenarioReceptionCheckIn(facade);
        scenarioOnlineCheckIn(facade);
        scenarioKeyCardReissue(facade);
    }

    private static void scenarioReceptionCheckIn(CheckInFacade facade) {
        Log.write("Runner", "Сценарій 1: заселення через рецепцію ");
        new ReceptionDesk(facade).checkInGuest("Іваненко", "BK-1001");
        System.out.println();
    }

    private static void scenarioOnlineCheckIn(CheckInFacade facade) {
        Log.write("Runner", "Сценарій 2: онлайн-заселення ");
        new OnlineCheckIn(facade).checkInGuest("Петренко", "BK-1002");
        System.out.println();
    }

    private static void scenarioKeyCardReissue(CheckInFacade facade) {
        Log.write("Runner", "Сценарій 3: перевипуск ключ-карти ");
        facade.getKeyCardService().reissue("Іваненко", 305);
        System.out.println();
    }
}