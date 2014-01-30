package Effect.Destroy;

import static Action.Destroy.destroyTarget;
import static Action.Destroy.destroyTargetConditions;
import Card.Card;
import static Card.Color.Color.B;
import Card.Permanent;
import Card.Spell;
import Condition.Card.ConditionColorNegative;
import Condition.Condition;
import Condition.Permanent.ConditionVulnerableColor;
import Effect.Effect;
import static Action.Target.target;

public class Terror extends Effect {
    private final Condition[] conditions;
    private Card target;

    public Terror(Spell source) {
        super(true);
        this.source = source;
        conditions = new Condition[]{
            new ConditionColorNegative(B) /*,new ConditionTargetable(Spell.class)*/,
            new ConditionVulnerableColor(B), //new ConditionVUlnerableType(),
        //new COnditionVulnerableSubType()...
        };
    }

    @Override
    public void activate(Card[] targets) {
        target = targets[0];
        target(target, source);
        destroyTargetConditions((Permanent) target, conditions, source);
    }

    @Override
    public void execute() {
        destroyTarget((Permanent) target, conditions, source);
    }

}
