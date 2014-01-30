package Effect.Destroy;

import static Action.Destroy.destroyAll;
import static Card.Aspect.Permanent.Type.CreatureType.SOLDIER;
import Card.Card;
import Card.Permanent;
import Condition.Card.ConditionSubType;
import Condition.Condition;
import Condition.Card.ConditionOther;
import Effect.Effect;

public class destroyother extends Effect {
    private final Permanent source;

    public destroyother(Permanent source, boolean targeting) {
        super(targeting);
        this.source = source;
    }

    @Override
    public void activate(Card[] targets) {
    }

    @Override
    public void execute() {
        destroyAll(new Condition[]{new ConditionOther(source.instanceID), new ConditionSubType(new String[]{SOLDIER})}, null);
    }

}
