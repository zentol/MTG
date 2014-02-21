package Effect.Static;

import Effect.StaticEffect;
import static Action.Protection.addUntargetableColor;
import Card.Card;
import Card.Permanent;
import Condition.Condition;

public class StaticUntargetableAspect extends StaticEffect {
    private final int aspect;

    public StaticUntargetableAspect(int aspect, Condition[] conditions) {
        super(0, conditions);
        this.aspect = aspect;
    }

    @Override
    public void executeActions(Card target) {
        addUntargetableColor(this, (Permanent) target, aspect);
    }
}
