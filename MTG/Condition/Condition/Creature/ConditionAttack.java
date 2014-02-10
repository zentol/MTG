package Condition.Creature;

import static Card.Aspect.Aspect.KEY_ASPECT_CREATURE;
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
    public boolean evaluate(Permanent target) {
        CreatureAspect creature = (CreatureAspect) target.getAspect(KEY_ASPECT_CREATURE);
        switch (mode) {
            case LESS:
                return creature.getAttack() < value;
            case EQUAL:
                return creature.getAttack() == value;
            case MORE:
                return creature.getAttack() > value;
            default:
                return false;
        }
    }
}
