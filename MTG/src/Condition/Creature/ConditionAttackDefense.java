package Condition.TargetProperties;

import Card.Aspect.Permanent.CreatureAspect;
import Card.Permanent;
import Condition.Condition;

public class ConditionAttackDefense extends Condition<Permanent> {
    private final int property;
    private final int mode;
    private final int value;

    public ConditionAttackDefense(int value, int mode, int property) {
        this.value = value;
        this.mode = mode;
        this.property = property;
    }

    @Override
    public boolean evaluate(Permanent permanent) {
        CreatureAspect c = (CreatureAspect) permanent.getAspect(CreatureAspect.class);
        switch (mode) {
            case -1:
                switch (property) {
                    case 0:
                        return c.getAttack() < value;
                    case 1:
                        return c.getDefense() < value;
                }
                break;
            case 0:
                switch (property) {
                    case 0:
                        return c.getAttack() == value;
                    case 1:
                        return c.getDefense() == value;
                }
                break;
            case 1:
                switch (property) {
                    case 0:
                        return c.getAttack() > value;
                    case 1:
                        return c.getDefense() > value;
                }
                break;
        }
        return false;
    }
}
