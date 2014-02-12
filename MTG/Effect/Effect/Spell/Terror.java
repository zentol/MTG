package Effect.Spell;

import static Action.Destroy.destroyTarget;
import static Action.Target.target;
import Card.Card;
import static Card.Color.Color.B;
import Card.Permanent;
import Card.Spell;
import Condition.Card.ConditionColorNegative;
import Condition.Condition;
import static Condition.Condition.checkConditions;
import Condition.Permanent.ConditionVulnerableColor;
import Game.InvalidTargetException;

public class Terror extends SpellEffect {
    private final Condition[] conditions;
    private Card target;

    public Terror(Spell source) {
        super(true);
        this.source = source;
        conditions = new Condition[]{
            new ConditionColorNegative(B),
            new ConditionVulnerableColor(B)
        };
    }

    @Override
    public void activate(Card[] targets) {
        target = targets[0];
        target(target, source);
        if (!checkConditions((Permanent) target, conditions)) {
            throw new InvalidTargetException();
        }
    }

    @Override
    public void execute() {
        try {
            destroyTarget((Permanent) target, conditions, source);
        } catch (InvalidTargetException ITE) {
            //counter(this);
        }
    }
}
