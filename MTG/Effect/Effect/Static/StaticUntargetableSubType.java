package Effect.Static;

import static Action.Protection.addUntargetableSubType;
import Card.Card;
import Card.Permanent;
import Condition.Condition;

public class StaticUntargetableSubType extends StaticEffect {
    private final String[] subTypes;

    public StaticUntargetableSubType(Card source, String[] subTypes, Condition[] conditions) {
        super(false, source, conditions);
        this.subTypes = subTypes;
    }

    @Override
    public void activate(Card[] targets) {
    }

    @Override
    public void executeActions(Card target) {
        addUntargetableSubType(this, (Permanent) target, subTypes);
    }
}
