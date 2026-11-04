public class Department {
    private final String name;

    public Department(String name) {
        this.name = name;
    }

    public void charge(String room, String description, int amount) {
        BillingService service = BillingService.getInstance();
        HotelLog.log(name, "Отримано службу розрахунків " + service.getId());
        service.addCharge(room, new Charge(name, description, amount));
    }

    public void issueFinalBill(String room) {
        BillingService.getInstance().printFinalBill(room);
    }
}