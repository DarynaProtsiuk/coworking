package task1;

import task2.Logger;

public
class HotelSystem {

    private Handler firstHandler;

    public void setDayShift() {
        ReceptionHandler reception = new ReceptionHandler(false);

        MaidHandler maids = new MaidHandler();
        TechnicalHandler technical = new TechnicalHandler();
        ManagerHandler manager = new ManagerHandler();

        reception.setNext(maids);
        maids.setNext(technical);
        technical.setNext(manager);

        firstHandler = reception;

        Logger.log("HOTEL", "Встановлено денну зміну.");

        Logger.log("HOTEL", "Ланцюжок: рецепція -> покоївки -> технічна служба -> менеджер.");
    }

    public void setNightShift() {
        ReceptionHandler reception = new ReceptionHandler(true);

        TechnicalHandler technical = new TechnicalHandler();
        ManagerHandler manager = new ManagerHandler();

        reception.setNext(technical);
        technical.setNext(manager);

        firstHandler = reception;

        Logger.log("HOTEL", "Встановлено нічну зміну.");

        Logger.log("HOTEL", "Ланцюжок: рецепція -> технічна служба -> менеджер.");
    }

    public void sendRequest(GuestRequest request) {
        Logger.log("GUEST", "Новий запит: " + request.getDescription());

        if (firstHandler != null) {
            firstHandler.handleRequest(request);
        } else {
            Logger.log("HOTEL", "Помилка: ланцюжок обробників не налаштований.");
        }
    }
}
