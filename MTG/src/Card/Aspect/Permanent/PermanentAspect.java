package Card.Aspect.Permanent;

import Card.Aspect.Aspect;
import java.util.ArrayList;
import java.util.Arrays;

public abstract class PermanentAspect extends Aspect {
    public PermanentAspect(String[] types) {
        this.subType = new ArrayList();
        this.subType.addAll(Arrays.asList(types));
    }
}
