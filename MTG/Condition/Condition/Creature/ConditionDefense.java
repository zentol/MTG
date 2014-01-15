package Condition.Creature;

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
        CreatureAspect c = (CreatureAspect) target.getAspect(CreatureAspect.class);
        switch (mode) {
            case -1:
                return c.getDefense() < value;
            case 0:
                return c.getDefense() == value;
            case 1:
                return c.getDefense() > value;
        }
        return false;
    }
}
