package Ability;

import static Action.Play.playAbility;
import static Action.Target.target;
import Card.Card;
import Card.Permanent;
import Condition.Condition;
import static Condition.Condition.checkConditions;
import Event.Event;
import Game.InvalidTargetException;
import Trigger.Trigger;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class Ability {
    public Card source;
    public int targetCount;
    public int type;
    public Condition[] conditions;
    public Card[] targets;
    public Trigger trigger;
    public Cost cost;

    public static final int KEY_ABILITY_TYPE_STATIC = 1;
    public static final int KEY_ABILITY_TYPE_ACTIVATED = 2;
    public static final int KEY_ABILITY_TYPE_TRIGGERED = 3;
    public static final int KEY_ABILITY_TYPE_SPELL = 4;

    public Ability() {
        targetCount = 0;
        type = 0;
        conditions = null;
        cost = null;
        trigger = null;
    }

    public Ability(int targetCount, int type, Condition[] conditions, Cost cost, Trigger trigger) {
        this.targetCount = targetCount;
        this.type = type;
        this.conditions = conditions;
        this.cost = cost;
        this.trigger = trigger;
    }

    public void evaluateTrigger(Event event) {
        if (trigger.check(event)) {
            playAbility(this);
        }
    }

    public void activate(Card... targets) {
        this.targets = targets;
        payCost();
        for (Card target : targets) {
            target(target, source);
            if (!checkConditions((Permanent) target, conditions)) {
                throw new InvalidTargetException();
            }
        }
    }

    public void payCost() {
        if (cost == null) {
        } else {
            cost.pay();
        }
    }

    public void execute() {
        if (targetCount == 0) {
            executeActions(null);
        } else {
            for (Card target : targets) {
                executeActions(target);
            }
        }
    }

    protected abstract void executeActions(Card target);

    public int getType() {
        return type;
    }

    public void setSource(Card source) {
        this.source = source;
    }
    
    public static class AbilityBuilder {
        Ability ability;

        public AbilityBuilder(Class<? extends Ability> clazz) throws InstantiationException, IllegalAccessException {
            this.ability = clazz.newInstance();
        }
        
        public AbilityBuilder setConditions(Condition ... conditions){
            ability.conditions=conditions;
            return this;
        }
        
        public AbilityBuilder setCost(Cost cost){
            ability.cost=cost;
            return this;
        }
        
        public AbilityBuilder setTargetCount(int targetCount){
            ability.targetCount=targetCount;
            return this;
        }
        
        public AbilityBuilder setTrigger(Trigger trigger){
            ability.trigger=trigger;
            return this;
        }
        
        public AbilityBuilder setType(int type){
            ability.type=type;
            return this;
        }
        
        public Ability finish(){
            return ability;
        }
    }
    
        public static AbilityBuilder buildAbility(Class<? extends Ability> clazz) {
        try {
            return new AbilityBuilder(clazz);
        } catch (InstantiationException ex) {
        } catch (IllegalAccessException ex) {
        }
        return null;
    }
}
