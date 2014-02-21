package Card.Aspect.Permanent;

public class PlaneswalkerAspect extends PermanentAspect {
    public int loyalty;

    public PlaneswalkerAspect(String[] types, int loyalty) {
        super(types, KEY_ASPECT_PLANESWALKER);
        this.loyalty = loyalty;
    }
}
