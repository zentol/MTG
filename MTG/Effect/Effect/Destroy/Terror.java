package Effect.Destroy;

import static Action.Destroy.destroyTarget;
import static Card.Color.Color.B;
import Card.Permanent;
import Card.Spell;
import Condition.Card.ConditionColorNegative;
import Condition.Condition;
import Condition.Permanent.ConditionVulnerableColor;
import Effect.Type.Activated.Activated;

public class Terror extends Activated {
    private final Spell source;
    private final Condition[] conditions;

    public Terror(Spell source) {
        this.source = source;
        conditions = new Condition[]{
            new ConditionColorNegative(String.valueOf(B)) /*,new ConditionTargetable(Spell.class)*/,
            new ConditionVulnerableColor(source.colors),
        //new ConditionVUlnerableType(),
            //new COnditionVulnerableSubType()...
        };
    }

    public void execute(Permanent target) {
        destroyTarget(target,conditions);
    }
}
