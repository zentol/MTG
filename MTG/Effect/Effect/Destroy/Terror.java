package Effect.Destroy;

import static Action.Destroy.destroyTarget;
import Card.Card;
import static Card.Color.Color.B;
import Card.Permanent;
import Card.Spell;
import Condition.Card.ConditionColorNegative;
import Condition.Condition;
import Condition.Permanent.ConditionVulnerableColor;
import Effect.Effect;

public class Terror extends Effect {
    private final Condition[] conditions;
    private Permanent target;

    public Terror(Spell source) {
        this.source = source;
        conditions = new Condition[]{
            new ConditionColorNegative(B) /*,new ConditionTargetable(Spell.class)*/,
            new ConditionVulnerableColor(B), //new ConditionVUlnerableType(),
        //new COnditionVulnerableSubType()...
        };
    }

    @Override
    public void execute() {
        destroyTarget(target, conditions, source);
    }

    @Override
    public void setTargets(Card[] targets) {
        this.target = (Permanent) targets[0];
    }
}
