package Action;

import static Action.FireEvent.fireEvent;
import Card.Permanent;
import Effect.Effect;
import static Effect.Effect.KEY_EFFECT_TYPE_STATIC;
import Event.EventEnterTheBattlefield;
import static Game.Game.battlefield;

public class PutIntoPlay {
    public static void putIntoPlay(Permanent target) {
        battlefield.add(target);
        for(Effect effect:target.effects){
            if(effect.getType()==KEY_EFFECT_TYPE_STATIC){
                effect.execute();
            }
        }
        fireEvent(new EventEnterTheBattlefield(target));
    }
}
