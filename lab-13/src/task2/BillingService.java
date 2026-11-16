package task2;

import java.util.ArrayList;
import java.util.List;

public class BillingService {
    private final List<Command> executed = new ArrayList<>();

    public void execute(Command command) {
        Logger.log("BillingService", "отримано команду: " + command.getDescription());
        command.execute();
        executed.add(command);
    }

    public void reverse(Command command) {
        Logger.log("BillingService", "отримано запит на сторнування: " + command.getDescription());
        if (!executed.contains(command)) {
            Logger.log("BillingService", "відхилено: ця команда не виконувалась цим сервісом");
            return;
        }
        command.undo();
    }
}
