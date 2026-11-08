package task1;

public class LuxuryFactory implements RoomFactory{
    @Override
    public Cosmetic createCosmetic() {
        return new LuxuryCosmetic();
    }

    @Override
    public Minibar createMinibar() {
        return new LuxuryMinibar();
    }

    @Override
    public Textile createTextile() {
        return new LuxuryTextile();
    }
}
