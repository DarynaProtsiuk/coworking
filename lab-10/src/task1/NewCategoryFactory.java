package task1;

public class NewCategoryFactory implements RoomFactory{
    @Override
    public Cosmetic createCosmetic() {
        return new NewCosmetic();
    }

    @Override
    public Minibar createMinibar() {
        return new NewMinibar();
    }

    @Override
    public Textile createTextile() {
        return new NewTextile();
    }
}
