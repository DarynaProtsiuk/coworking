import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BillingService {
    private static BillingService instance;

    private final String id;
    private final Map<String, List<Charge>> billsByRoom = new HashMap<>();

    private BillingService() {  // піти в обхід не можна
        this.id = "BILL-" + Integer.toHexString(System.identityHashCode(this));
        HotelLog.log("Розрахунки", "Службу розрахунків ініціалізовано");
    }

    public static synchronized BillingService getInstance() { //метод доступу
        if (instance == null) {
            instance = new BillingService();
        }
        return instance;
    }

    public void addCharge(String room, Charge charge) {
        List<Charge> bill = billsByRoom.get(room);
        if (bill == null) {
            bill = new ArrayList<>();
            billsByRoom.put(room, bill);
        }
        bill.add(charge);
        HotelLog.log("Розрахунки", "Номер " + room + ": " + charge.getDepartment()
                + " — " + charge.getDescription() + ", " + charge.getAmount() + " грн");
    }

    public void printFinalBill(String room) {
        List<Charge> bill = billsByRoom.getOrDefault(room, new ArrayList<>());
        HotelLog.log("Розрахунки", "Підсумковий рахунок, номер " + room + ":");
        int total = 0;
        for (Charge charge : bill) {
            System.out.println("    " + charge.getDepartment() + " — "
                    + charge.getDescription() + ": " + charge.getAmount() + " грн");
            total += charge.getAmount();
        }
        System.out.println("    РАЗОМ: " + total + " грн (нарахувань: " + bill.size() + ")");
    }

    public String getId() {
        return id;
    }
}