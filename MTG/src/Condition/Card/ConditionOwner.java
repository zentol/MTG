package Condition.Proxy;

import Card.Proxy;
import Condition.Condition;

public class ConditionOwner extends Condition<Proxy>{
    private final int ownerID;
    
    public ConditionOwner(int ownerID){
        this.ownerID=ownerID;
    }
    
    @Override
    public boolean evaluate(Proxy o) {
        return o.isOwner(ownerID);
    }
}
