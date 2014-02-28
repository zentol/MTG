package Ability.Effect.Static;

import Ability.StaticAbility;
import static Action.Protection.addInvulnerablityColor;
import Card.Card;
import Card.Permanent;
import Condition.Condition;

public class StaticInvulnerableColor extends StaticAbility {
    private final int color;

    public StaticInvulnerableColor(Permanent target, int color, Condition[] conditions) {
        super(0, conditions);
        this.color = color;
    }

    @Override
    public void executeActions(Card target) {
        addInvulnerablityColor(this, (Permanent) target, color);
    }
}
