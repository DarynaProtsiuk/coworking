package task3;

public class Letter implements Confirmation{
    private final String guest;
    private final String room;

    public Letter(String guest, String room) {
        this.guest = guest;
        this.room = room;
    }

    @Override
    public String getMessage () {
        return "Тема: Підтвердження бронювання\n"
                + "Шановний(а) " + guest + ",\n"
                + "ваше бронювання номера \"" + room + "\" підтверджено.\n"
                + "З повагою, готель «Карпатські вершини».";
    }
}
