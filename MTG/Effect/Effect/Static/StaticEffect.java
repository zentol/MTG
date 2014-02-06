package Effect.Static;

import Card.Card;
import Condition.Condition;
import static Condition.Condition.checkConditions;
import Effect.Effect;
import static Game.Game.battlefield;

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

    protected abstract void executeActions(Card target);

    @Override
    public int getType() {
        return KEY_TYPE_EFFECT_STATIC;
    }
}
