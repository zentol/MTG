package Card.Aspect.Permanent;

import Card.Aspect.Aspect;
import java.util.ArrayList;
import static java.util.Arrays.asList;

public abstract class PermanentAspect extends Aspect {
    public PermanentAspect(String[] types, int aspectType) {
        super(aspectType);
        this.subType = new ArrayList();
        this.subType.addAll(asList(types));
    }
}
