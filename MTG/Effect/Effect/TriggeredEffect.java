package Effect;

import static Action.Play.playAbility;
import Card.Card;
import Event.Event;
import Trigger.Trigger;

public abstract class TriggeredEffect extends Effect {
    private final Trigger trigger;
    private final Effect effect;

    public TriggeredEffect(int targetCount, Trigger trigger, Effect effect) {
        super(effect.targetCount);
        this.trigger = trigger;
        this.effect = effect;
    }

    @Override
    public int getType() {
        return KEY_EFFECT_TYPE_TRIGGERED;
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
}
