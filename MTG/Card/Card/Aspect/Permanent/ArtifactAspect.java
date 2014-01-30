package Card.Aspect.Permanent;

public class ArtifactAspect extends PermanentAspect {

    public ArtifactAspect(String[] types) {
        super(types);
    }

    @Override
    public int getKey() {
        return KEY_ASPECT_ARTIFACT;
    }
}
