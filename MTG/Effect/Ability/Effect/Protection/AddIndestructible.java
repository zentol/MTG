package Ability.Effect.Protection;

import Ability.Ability;
import Ability.Cost;
import static Action.Indestructible.addIndestructible;
import Card.Card;
import Card.Permanent;
import Condition.Condition;
import Trigger.Trigger;

public class AddIndestructible extends Ability {

    public AddIndestructible(int targetCount, int type, Cost cost, Trigger trigger, Condition... conditions) {
        super(targetCount, type, conditions, cost, trigger);
    }

    @Override
    protected void executeActions(Card target) {
        if(targetCount==0){
            target=this.source;
        }
        addIndestructible(this, (Permanent) target);
    }
}
