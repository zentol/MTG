package Ability;

import static Action.Play.playAbility;
import Card.Card;
import Event.Event;
import Trigger.Trigger;

public class TriggeredAbility extends Ability {
    private final Trigger trigger;
    private final Ability effect;

    public TriggeredAbility(int targetCount, Trigger trigger, Ability effect) {
        super(effect.targetCount, KEY_ABILITY_TYPE_TRIGGERED);
        this.trigger = trigger;
        this.effect = effect;
    }

    public void evaluateTrigger(Event event) {
        if (trigger.check(event)) {
            playAbility(this);
        }
    }

    @Override
    public void activate(Card[] targets) {
        effect.activate(targets);
    }

    @Override
    public void execute() {
        effect.execute();
    }
    
    @Override
    public void payCost(){
        effect.payCost();
    }
}
