package task1;

public class StandardFactory implements RoomFactory{
    @Override
    public Cosmetic createCosmetic() {
        return new StandardCosmetic();
    }

    @Override
    public Minibar createMinibar() {
        return new StandardMinibar();
    }

    @Override
    public Textile createTextile() {
        return new StandardTextile();
    }
}
