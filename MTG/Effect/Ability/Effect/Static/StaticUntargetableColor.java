package Ability.Effect.Static;

import Ability.StaticAbility;
import static Action.Protection.addUntargetableColor;
import Card.Card;
import Card.Permanent;
import Condition.Condition;

public class StaticUntargetableColor extends StaticAbility {
    private final int color;

    public StaticUntargetableColor(int color, Condition[] conditions) {
        super(0, conditions);
        this.color = color;
    }

    @Override
    public void executeActions(Card target) {
        addUntargetableColor(this, (Permanent) target, color);
    }
}
