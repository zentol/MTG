package Action;

import Card.Card;

public class Target extends Action{
    
    public static void target(Card target){
        targetCondition(target,null);
    }
    
    private static boolean targetCondition(Card target, Card source){
        //check type
        //check subtype
        //check color
        return false;
    }
}
