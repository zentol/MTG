package Action;

import static Card.Aspect.Aspect.KEY_ASPECT_CREATURE;
import Card.Aspect.Permanent.CreatureAspect;
import Card.Permanent;
import static Game.Game.lifepoints;

public class Damage {

    public static void dealDamageToPermanent(int damage, Permanent target) {
        ((CreatureAspect) target.getAspect(KEY_ASPECT_CREATURE)).dealDamage(damage);
    }

    public static void dealDamageToPlayer(int damage, int playerID) {
        lifepoints.set(playerID, lifepoints.get(playerID) - damage);
    }
}
