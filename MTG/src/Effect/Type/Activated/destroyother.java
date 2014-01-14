package Effect.Type.Activated;

import static Action.Destroy.DestroyAll.destroyAll;
import static Card.Aspect.Permanent.Type.CreatureType.SOLDIER;
import Card.Permanent;
import Condition.Card.ConditionSubType;
import Condition.Condition;
import Condition.Proxy.ConditionOther;

public class destroyother extends Activated {
    private final Permanent source;

    public destroyother(Permanent source) {
        this.source = source;
    }

    public void execute() {
        destroyAll(new Condition[]{new ConditionOther(source.instanceID), new ConditionSubType(new String[]{SOLDIER})});
    }
}
