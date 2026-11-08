package task1;

public class FamilyFactory implements RoomFactory{
    @Override
    public Cosmetic createCosmetic() {
        return new FamilyCosmetic();
    }

    @Override
    public Minibar createMinibar() {
        return new FamilyMinibar();
    }

    @Override
    public Textile createTextile() {
        return new FamilyTextile();
    }
}
