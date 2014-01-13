package Condition.Creature;

import Card.Aspect.Permanent.CreatureAspect;
import Card.Permanent;
import Condition.Condition;

public class ConditionAttack extends Condition<Permanent> {
    private final int mode;
    private final int value;

    public ConditionAttack(int value, int mode) {
        this.value = value;
        this.mode = mode;
    }

    @Override
    public boolean evaluate(Permanent permanent) {
        CreatureAspect c = (CreatureAspect) permanent.getAspect(CreatureAspect.class);
        switch (mode) {
            case -1:
                return c.getAttack() < value;
            case 0:
                return c.getAttack() == value;
            case 1:
                return c.getAttack() > value;
        }
        return false;
    }
}
