package task1;

import task2.Logger;

public class ReceptionHandler extends Handler {

    private boolean nightShift;

    public ReceptionHandler(boolean nightShift) {
        super("RECEPTION");
        this.nightShift = nightShift;
    }

    @Override
    protected boolean canHandle(GuestRequest request) {
        return request.getType() == RequestType.TOWELS ||
                request.getType() == RequestType.WAKE_UP ||
                (nightShift && request.getType() == RequestType.CLEANING);
    }

    @Override
    protected void process(GuestRequest request) {
        if (request.getType() == RequestType.CLEANING) {
            Logger.log("RECEPTION", "Покоївки зараз відсутні.");

            Logger.log("RECEPTION", "Запит на прибирання прийнято.");

            Logger.log("RECEPTION", "Прибирання заплановано на ранок.");
        } else {
            Logger.log("RECEPTION", "Запит оброблено: " + request.getDescription());
        }
    }
}