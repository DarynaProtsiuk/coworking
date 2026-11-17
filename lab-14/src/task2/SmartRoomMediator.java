package task2;

public class SmartRoomMediator implements RoomMediator {
    private AirConditioner conditioner;
    private Lights lights;
    private Curtains curtains;
    private FloorHeating floorHeating;

    public void setConditioner(AirConditioner c)   { this.conditioner = c; }
    public void setLights(Lights l)                { this.lights = l; }
    public void setCurtains(Curtains c)            { this.curtains = c; }
    public void setFloorHeating(FloorHeating f)    { this.floorHeating = f; }

    @Override
    public void notify(Device sender, RoomEvent event) {
        Log.log("Координатор", "отримав " + event + " від «" + sender.getName() + "»");

        switch (event) {
            case WINDOW_OPENED -> {
                Log.log("Координатор", "правило: вікно відчинене → вимкнути кондиціонер");
                conditioner.turnOff();
            }
            case GUEST_LEFT -> {
                Log.log("Координатор", "правило: гість вийшов → вимкнути світло і кондиціонер");
                lights.turnOff();
                conditioner.turnOff();
                if (floorHeating != null) floorHeating.turnOff();
            }
            case EVENING_CAME -> {
                Log.log("Координатор", "правило: вечір → закрити штори, нічне освітлення");
                curtains.close();
                lights.nightMode();
            }
            default -> { } // події без правил поки ігноруємо
        }
    }
}
