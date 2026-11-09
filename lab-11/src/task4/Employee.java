package src.task4;

public class Employee {
    private String name;
    private Role role;

    public Employee(String name, Role role) {
        this.name = name;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public Role getRole() {
        return role;
    }
}
