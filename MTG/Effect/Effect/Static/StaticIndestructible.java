package Effect.Static;

import static Action.Indestructible.addIndestructible;
import Card.Card;
import Card.Permanent;
import Condition.Condition;
import static Condition.Condition.checkConditions;
import static Game.Game.battlefield;

public class StaticIndestructible extends StaticEffect {

    public StaticIndestructible(Card source, Condition[] conditions) {
        super(false, source, conditions);
    }

    @Override
    public void activate(Card[] targets) {
    }

    @Override
    protected void executeActions(Card target) {
        addIndestructible(this, (Permanent) target);
    }
}
