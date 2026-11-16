package task2;

public enum OperationType {
    CHARGE("нарахування"),
    REVERSAL("сторно");

    private final String label;

    OperationType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
