package task2_lab12;

import java.util.List;

public interface PackageComponent {
    String getName();
    int getPrice();
    List<String> getServices();
    void printTree(String indent);
}
