package task1;
import task2.Logger;

public abstract class Handler {
    protected Handler nextHandler;
    protected String name;

    public Handler(String name) {
        this.name = name;
    }

    public void setNext(Handler handler) {
        this.nextHandler = handler;
    }

    public void handleRequest(GuestRequest request) {
        if (canHandle(request)) {
            process(request);
        } else if (nextHandler != null) {
            Logger.log(name, "Не можу обробити запит. Передаю далі.");
            nextHandler.handleRequest(request);
        } else {
            Logger.log("SYSTEM", "Запит не вдалося обробити.");

            Logger.log("GUEST", "На жаль, зараз ми не можемо виконати ваш запит: " + request.getDescription());}
    }

    protected abstract boolean canHandle(GuestRequest request);

    protected abstract void process(GuestRequest request);
}

