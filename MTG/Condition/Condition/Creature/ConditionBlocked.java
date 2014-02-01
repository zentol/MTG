package Condition.Creature;

import static Card.Aspect.Aspect.KEY_ASPECT_CREATURE;
import Card.Aspect.Permanent.CreatureAspect;
import Card.Permanent;
import Condition.Condition;

public class ConditionBlocked extends Condition<Permanent> {

    public ConditionBlocked() {
    }

    @Override
    public boolean evaluate(Permanent target) {
        if (!target.hasAspect(KEY_ASPECT_CREATURE)) {
            return false;
        }
        return ((CreatureAspect) target.getAspect(KEY_ASPECT_CREATURE)).blocked;
    }

}
