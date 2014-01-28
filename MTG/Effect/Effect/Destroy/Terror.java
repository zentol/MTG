package Effect.Destroy;

import static Action.Destroy.destroyTarget;
import static Card.Color.Color.B;
import Card.Permanent;
import Card.Spell;
import Condition.Card.ConditionColorNegative;
import Condition.Condition;
import Condition.Permanent.ConditionVulnerableColor;
import Effect.Effect;

public class Terror extends Effect {
    private final Spell source;
    private final Condition[] conditions;

    public Terror(Spell source) {
        this.source = source;
        conditions = new Condition[]{
            new ConditionColorNegative(B) /*,new ConditionTargetable(Spell.class)*/,
            new ConditionVulnerableColor(B), //new ConditionVUlnerableType(),
        //new COnditionVulnerableSubType()...
        };
    }

    public void execute(Permanent target) {
        destroyTarget(target, conditions, source);
    }
}
