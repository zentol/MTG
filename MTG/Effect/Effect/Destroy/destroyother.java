package Effect.Destroy;

import static Action.Destroy.destroyAll;
import static Card.Aspect.Permanent.Type.CreatureType.SOLDIER;
import Card.Permanent;
import Condition.Card.ConditionSubType;
import Condition.Condition;
import Condition.Card.ConditionOther;
import Effect.Type.ActivatedEffect;

public class destroyother extends ActivatedEffect {
    private final Permanent source;

    public destroyother(Permanent source) {
        this.source = source;
    }

    public void execute() {
        destroyAll(new Condition[]{new ConditionOther(source.instanceID), new ConditionSubType(new String[]{SOLDIER})});
    }
}
