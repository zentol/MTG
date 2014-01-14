package Effect.Type.Activated;

import static Action.Destroy.DestroyTarget.destroyTarget;
import Card.Permanent;
import Card.Spell;
import Condition.Card.ConditionColorNegative;
import Condition.Condition;
import Condition.Permanent.ConditionVulnerableColor;

public class Terror extends Activated{
    private final Spell source;
    
    public Terror(Spell source){
        this.source=source;
    }
    
    public void execute(Permanent target){
        destroyTarget(target, new Condition[]{new ConditionColorNegative("B")/*,new ConditionTargetable(Spell.class)*/, new ConditionVulnerableColor(source.colors)});
    }
}
