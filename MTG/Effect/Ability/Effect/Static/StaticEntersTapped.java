package Ability.Effect.Static;

import Card.Card;
import Card.Permanent;
import Condition.Condition;
import Ability.StaticAbility;

public class StaticEntersTapped extends StaticAbility {

    public StaticEntersTapped(Condition[] conditions) {
        super(0, conditions);
    }

    @Override
    protected void executeActions(Card target) {
        ((Permanent)target).tap();
    }
}
