package Ability.Effect.Destroy;

import Ability.Ability;
import Ability.Cost;
import static Action.Destroy.destroyAll;
import static Action.Destroy.destroyTarget;
import Card.Card;
import Card.Permanent;
import Condition.Condition;
import Game.InvalidTargetException;
import Trigger.Trigger;

public class Destruction extends Ability {
    
    public Destruction(){
    super();}
    
    public Destruction(int targetCount, int type, Cost cost, Trigger trigger, Condition... conditions) {
        super(targetCount, type, conditions, cost, trigger);
    }

    @Override
    protected void executeActions(Card target) {
        if (target == null) {
            destroyAll(conditions, source);
        } else {
            try {
                destroyTarget((Permanent) target, conditions, source);
            } catch (InvalidTargetException ITE) {
                //counter(this);
            }
        }
    }
}
