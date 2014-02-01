package Effect.Destroy;

import static Action.Destroy.destroyTarget;
import static Action.Target.target;
import Card.Card;
import static Card.Color.Color.B;
import Card.Permanent;
import Card.Spell;
import Condition.Card.ConditionColorNegative;
import Condition.Condition;
import static Condition.Condition.checkConditions;
import Condition.Permanent.ConditionVulnerableColor;
import Effect.Effect;

public class Terror extends Effect {
    private final Condition[] conditions;
    private Card target;

    public Terror(Spell source) {
        super(true);
        this.source = source;
        conditions = new Condition[]{
            new ConditionColorNegative(B),
            new ConditionVulnerableColor(B)
        };
    }

    @Override
    public void activate(Card[] targets) {
        target = targets[0];
        target(target, source);
        checkConditions((Permanent) target, conditions, source);
    }

    @Override
    public void execute() {
        destroyTarget((Permanent) target, conditions, source);
    }

}
