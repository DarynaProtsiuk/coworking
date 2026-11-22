package task2;

public enum RoomCategory {
    STANDARD("Стандарт"),
    LUXURY("Люкс");

    private final String title;

    public String getTitle() {
        return title;
    }

    RoomCategory(String title) {
        this.title = title;
    }
}
