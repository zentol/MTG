package Effect.Static;

import Card.Card;
import Card.Permanent;
import Condition.Condition;
import Effect.StaticEffect;

public class StaticEntersTapped extends StaticEffect {

    public StaticEntersTapped(Condition[] conditions) {
        super(0, conditions);
    }

    @Override
    protected void executeActions(Card target) {
        ((Permanent)target).tap();
    }
}
