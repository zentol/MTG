package Card.Aspect.Permanent;

public class LandAspect extends PermanentAspect {

    public LandAspect(String[] types) {
        super(types);
    }

    @Override
    public int getKey() {
        return KEY_ASPECT_LAND;
    }
}
