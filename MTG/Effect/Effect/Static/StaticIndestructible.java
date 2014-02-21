package Effect.Static;

import Effect.StaticEffect;
import static Action.Indestructible.addIndestructible;
import Card.Card;
import Card.Permanent;
import Condition.Condition;

public class StaticIndestructible extends StaticEffect {

    public StaticIndestructible(Condition[] conditions) {
        super(0, conditions);
    }

    @Override
    protected void executeActions(Card target) {
        addIndestructible(this, (Permanent) target);
    }
}
