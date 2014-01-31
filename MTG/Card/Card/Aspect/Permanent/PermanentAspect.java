package Card.Aspect.Permanent;

import Card.Aspect.Aspect;
import java.util.ArrayList;
import java.util.Arrays;
import static java.util.Arrays.asList;

public abstract class PermanentAspect extends Aspect {
    public PermanentAspect(String[] types) {
        this.subType = new ArrayList();
        this.subType.addAll(asList(types));
    }
}
