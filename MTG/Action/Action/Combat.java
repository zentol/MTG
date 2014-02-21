package Action;

import static Action.Damage.dealDamageToPermanent;
import static Card.Aspect.Aspect.KEY_ASPECT_CREATURE;
import Card.Aspect.Permanent.CreatureAspect;
import Card.Card;
import Card.Permanent;

public class Combat {
    public static void attack(Card attacker, Card target) {
        if (target == null) {

        } else {

        }
    }

    public static void block(Card blocker, Card attacker) {
    }
    
    public static void fight(Permanent combatant1, Permanent combatant2){
        dealDamageToPermanent(((CreatureAspect)combatant1.getAspect(KEY_ASPECT_CREATURE)).getAttack(),combatant2);
        dealDamageToPermanent(((CreatureAspect)combatant2.getAspect(KEY_ASPECT_CREATURE)).getAttack(),combatant1);
    }
}
