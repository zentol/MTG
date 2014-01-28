package Condition.Creature;

import static Card.Aspect.Aspect.KEY_ASPECT_CREATURE;
import Card.Aspect.Permanent.CreatureAspect;
import Card.Permanent;
import Condition.Condition;

public class ConditionDefense extends Condition<Permanent> {
    private final int mode;
    private final int value;

    public ConditionDefense(int value, int mode) {
        this.value = value;
        this.mode = mode;
    }

    @Override
    public boolean evaluate(Permanent target) {
        CreatureAspect creature = (CreatureAspect) target.getAspect(KEY_ASPECT_CREATURE);
        switch (mode) {
            case -1:
                return creature.getDefense() < value;
            case 0:
                return creature.getDefense() == value;
            case 1:
                return creature.getDefense() > value;
            default:
                return false;
        }
    }
}
