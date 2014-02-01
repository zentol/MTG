package Action;

import Card.Card;
import Game.InvalidTargetException;
import Modifier.Protection.TargetingModifier;

public class Target extends Action {

    public static void target(Card target, Card source) {
        targetCondition(target, source);
    }

    private static void targetCondition(Card target, Card source) {
        boolean targetConditionsMet = true;
        
        for(int x=0;x<target.modifiers.size();x++){
            if(TargetingModifier.class.isInstance(target.modifiers.get(x))){
                targetConditionsMet &= !((TargetingModifier)target.modifiers.get(x)).preventsTargeting(source);
            }
            
        }
        //check subtype
        if (!targetConditionsMet) {
            throw new InvalidTargetException();
        }
    }
}
