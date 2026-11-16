package task2;

public class ChargeCommand implements Command {
    private final GuestBill bill;  // рахунок, у який треба записати
    private final String department;
    private final String service;
    private final int amount;
    private boolean executed = false;
    private boolean reversed = false;

    public ChargeCommand(GuestBill bill, String department, String service, int amount) {
        this.bill = bill;
        this.department = department;
        this.service = service;
        this.amount = amount;
    }

    @Override
    public void execute() {
        if (executed) {
            Logger.log(source(), "нарахування вже виконано, повторно не виконується");
            return;
        }
        Logger.log(source(), "виконано: нарахування " + amount + " грн за «" + service + "»");
        bill.addEntry(new ChargeEntry(department, service, amount, Logger.now(), OperationType.CHARGE));
        executed = true;
    }

    @Override
    public void undo() {
        if (!executed) {
            Logger.log(source(), "сторнувати неможливо: нарахування ще не виконано");
            return;
        }
        if (reversed) {
            Logger.log(source(), "нарахування вже сторновано");
            return;
        }
        Logger.log(source(), "сторнування: повертаємо " + amount + " грн за «" + service + "»");
        bill.addEntry(new ChargeEntry(department, "Сторно: " + service, -amount,
                Logger.now(), OperationType.REVERSAL));
        reversed = true;
    }

    @Override
    public String getDescription() {
        return department + " — " + service + ", " + amount + " грн";
    }

    private String source() {
        return "ChargeCommand (" + department + ")";
    }
}