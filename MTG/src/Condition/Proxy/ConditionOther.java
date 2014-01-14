package Condition.Proxy;

import Card.Proxy;
import Condition.Condition;

public class ConditionOther extends Condition<Proxy> {
    private final int instanceID;

    public ConditionOther(int instanceID) {
        this.instanceID = instanceID;
    }

    @Override
    public boolean evaluate(Proxy o) {
        return o.instanceID == instanceID;
    }
}
