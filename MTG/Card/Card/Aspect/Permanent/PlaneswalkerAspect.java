package Card.Aspect.Permanent;

public class PlaneswalkerAspect extends PermanentAspect {
    public int loyalty;

    public PlaneswalkerAspect(String[] types, int loyalty) {
        super(types);
        this.loyalty = loyalty;
    }

    @Override
    public int getKey() {
        return KEY_ASPECT_PLANESWALKER;
    }
}
