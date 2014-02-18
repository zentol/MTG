package Effect.Static;

import Effect.StaticEffect;
import static Action.Indestructible.addIndestructible;
import Card.Card;
import Card.Permanent;
import Condition.Condition;

public class StaticIndestructible extends StaticEffect {

    public StaticIndestructible(Card source, Condition[] conditions) {
        super(false, source, conditions);
    }

    @Override
    protected void executeActions(Card target) {
        addIndestructible(this, (Permanent) target);
    }
}
