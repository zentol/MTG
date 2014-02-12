package Effect.Triggered;

import Effect.Effect;
import Effect.Type.Triggered.Trigger.Trigger;
import Event.Event;

public abstract class TriggeredEffect extends Effect {
    private Trigger trigger;
    private Effect effect;

    public TriggeredEffect(boolean targeting, Trigger trigger, Effect effect) {
        super(targeting);
        this.trigger = trigger;
        this.effect = effect;
    }

    @Override
    public int getType() {
        return KEY_EFFECT_TYPE_TRIGGERED;
    }
    
    public void evaluateTrigger(Event event){
        if(trigger.check(event)){
            //effect.activate();
        }
    }
}
