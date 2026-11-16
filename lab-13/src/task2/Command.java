package task2;

public interface Command {
    void execute();
    void undo();
    String getDescription();
}
