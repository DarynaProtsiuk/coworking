package task2_lab12;

import task1_lab12.Logger;
import java.util.ArrayList;
import java.util.List;

public class ServicePackage implements PackageComponent {
    private final String name;
    private final List<PackageComponent> parts = new ArrayList<>(); // важливий рядок

    public ServicePackage(String name) {
        this.name = name;
    }

    public void add(PackageComponent part) {
        parts.add(part);
        Logger.log("Пакет «" + name + "»", "додано частину: " + part.getName());
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPrice() {  // рекурсія
        int total = 0;
        for (PackageComponent part : parts) {
            total += part.getPrice();
        }
        return total;
    }

    @Override
    public List<String> getServices() {
        List<String> result = new ArrayList<>();
        for (PackageComponent part : parts) {
            result.addAll(part.getServices());
        }
        return result;
    }

    @Override
    public void printTree(String indent) {
        Logger.log("Дерево", indent + "+ " + name + ": " + getPrice() + " грн");
        for (PackageComponent part : parts) {
            part.printTree(indent + "    ");
        }
    }
}
