
package Action.temp;

import Action.Action;
import Card.Card;
import Card.Permanent;
import Effect.Type.Static.StaticIndestructible;

public class makeIndestructible extends Action{
    
    public static void makeIndestructible(Card source, Permanent target){
        target.modifiers.add(new StaticIndestructible(source,target));
    }
}
