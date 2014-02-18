package Effect.Static;

import Effect.StaticEffect;
import static Action.Protection.addUntargetableColor;
import Card.Card;
import Card.Permanent;
import Condition.Condition;

public class StaticUntargetableColor extends StaticEffect {
    private final int color;

    public StaticUntargetableColor(Card source, int color, Condition[] conditions) {
        super(false, source, conditions);
        this.color = color;
    }

    @Override
    public void executeActions(Card target) {
        addUntargetableColor(this, (Permanent) target, color);
    }
}
