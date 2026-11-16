package task1;

import task2.Logger;

public class TechnicalHandler extends Handler {

    public TechnicalHandler() {
        super("TECHNICAL");
    }

    @Override
    protected boolean canHandle(GuestRequest request) {
        return request.getType() == RequestType.TECHNICAL;
    }

    @Override
    protected void process(GuestRequest request) {
        Logger.log("TECHNICAL", "Несправність прийнято в роботу.");
    }
}