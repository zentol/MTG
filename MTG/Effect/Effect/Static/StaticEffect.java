package Effect.Static;

import Card.Card;
import Condition.Condition;
import static Condition.Condition.checkConditions;
import Effect.Effect;
import static Game.Game.battlefield;
import Game.InvalidTargetException;

public abstract class StaticEffect extends Effect {
    protected final Condition[] conditions;

    public StaticEffect(boolean targeting, Card source, Condition[] conditions) {
        super(targeting);
        this.source = source;
        this.conditions = conditions;
    }

    @Override
    public void execute() {
        for (int x = 0; x < battlefield.size(); x++) {
            if (checkConditions(battlefield.get(x), conditions, source)) {
                executeActions(battlefield.get(x));
            }
        }
    }

    @Override
    public void activate(Card[] targets) {
        if (!checkConditions(targets[0], conditions, source)) {
            throw new InvalidTargetException();
        }
    }

    protected abstract void executeActions(Card target);

    @Override
    public int getType() {
        return KEY_EFFECT_TYPE_STATIC;
    }
}
