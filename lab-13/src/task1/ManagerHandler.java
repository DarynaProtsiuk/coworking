package task1;

import task2.Logger;

public class ManagerHandler extends Handler {

    public ManagerHandler() {
        super("MANAGER");
    }

    @Override
    protected boolean canHandle(GuestRequest request) {
        return request.getType() == RequestType.COMPLAINT;
    }

    @Override
    protected void process(GuestRequest request) {
        Logger.log("MANAGER", "Скаргу прийнято.");

        Logger.log("MANAGER", "Питання буде вирішено.");
    }
}
