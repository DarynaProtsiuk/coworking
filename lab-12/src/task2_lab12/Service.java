package task2_lab12;

import task1_lab12.Logger;
import java.util.List;

public class Service implements PackageComponent {
    private final String name;
    private final int price;

    public Service(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public List<String> getServices() {
        return List.of(name);
    }

    @Override
    public void printTree(String indent) {
        Logger.log("Дерево", indent + "- " + name + ": " + price + " грн");
    }
}