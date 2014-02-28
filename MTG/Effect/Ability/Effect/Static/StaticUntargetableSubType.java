package Ability.Effect.Static;

import Ability.StaticAbility;
import static Action.Protection.addUntargetableSubType;
import Card.Card;
import Card.Permanent;
import Condition.Condition;

public class StaticUntargetableSubType extends StaticAbility {
    private final String[] subTypes;

    public StaticUntargetableSubType(String[] subTypes, Condition[] conditions) {
        super(0, conditions);
        this.subTypes = subTypes;
    }

    @Override
    public void executeActions(Card target) {
        addUntargetableSubType(this, (Permanent) target, subTypes);
    }
}
