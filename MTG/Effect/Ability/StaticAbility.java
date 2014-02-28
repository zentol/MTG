package Ability;

import Card.Card;
import Condition.Condition;
import static Condition.Condition.checkConditions;
import static Game.Game.battlefield;
import Game.InvalidTargetException;

public abstract class StaticAbility extends Ability {
    protected final Condition[] conditions;

    public StaticAbility(int targetCount, Condition[] conditions) {
        super(targetCount, KEY_ABILITY_TYPE_STATIC);
        this.conditions = conditions;
    }

    @Override
    public void execute() {
        for (int x = 0; x < battlefield.size(); x++) {
            if (checkConditions(battlefield.get(x), conditions)) {
                executeActions(battlefield.get(x));
            }
        }
    }

    @Override
    public void activate(Card[] targets) {
        if (!checkConditions(targets[0], conditions)) {
            throw new InvalidTargetException();
        }
    }

    protected abstract void executeActions(Card target);

    @Override
    public void payCost() {
    }
}
