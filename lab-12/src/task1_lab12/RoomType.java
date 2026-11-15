package task1_lab12;

import java.util.Arrays;

public class RoomType {
    private final String name;
    private final String description;
    private final int area;
    private final String[] facilities;
    private final String[] photos;
    private final int basePrice;

    public RoomType(String name, String description, int area,
                    String[] facilities, String[] photos, int basePrice) {
        this.name = name;
        this.description = description;
        this.area = area;
        this.facilities = facilities;
        this.photos = photos;
        this.basePrice = basePrice;
    }

    public String getName() { return name; }
    public String getDescription() { return description; }
    public int getArea() { return area; }
    public String[] getFacilities() { return facilities; }
    public String[] getPhotos() { return photos; }
    public int getBasePrice() { return basePrice; }

    @Override
    public String toString() {
        return name + " (" + area + " м², від " + basePrice + " грн, зручності: "
                + Arrays.toString(facilities) + ")";
    }
}