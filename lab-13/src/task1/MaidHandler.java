package task1;

import task2.Logger;

public class MaidHandler extends Handler {

    public MaidHandler() {
        super("MAIDS");
    }

    @Override
    protected boolean canHandle(GuestRequest request) {
        return request.getType() == RequestType.CLEANING;
    }

    @Override
    protected void process(GuestRequest request) {
        Logger.log("MAIDS", "Запит на прибирання оброблено.");
    }
}