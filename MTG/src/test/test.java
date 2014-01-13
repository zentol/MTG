package test;

import static Action.Destroy.DestroyAll.destroyAll;
import Card.Aspect.Permanent.CreatureAspect;
import Card.Permanent;
import static Card.Aspect.Permanent.Type.CreatureType.MYR;
import static Card.Aspect.Permanent.Type.CreatureType.SOLDIER;
import Condition.Condition;
import Condition.Card.ConditionAspect;
import Condition.Card.ConditionColorPositive;
import Condition.Card.ConditionSubType;
import Effect.Effect;
import Effect.Type.Static.StaticIndestructible;
import Game.Game;
import static Game.Game.battlefield;
import java.util.ArrayList;

public class test {
    public static void main(String[] args) {
        Game g = new Game(2);

        Permanent c = new Permanent(1, 1, 1, 1, "Footsoldier", "W", "W", false);
        c.addCreatureAspect(1, 1, new String[]{SOLDIER, MYR}, null);
        battlefield.add(c);        
        c.effects.add(new StaticIndestructible(c, c));
        c.effects.get(0).execute();
        
        /*c.addArtifactAspect(new String[]{"Equipment"});
         Creature q = new Creature(1,1,null,null);
         */
        Condition q = new ConditionAspect(CreatureAspect.class);
        Condition p1 = new ConditionColorPositive("W");
        Condition p2 = new ConditionColorPositive("WR");
        Condition st1 = new ConditionSubType(new String[]{"Soldier", MYR});
        System.out.println(p1.evaluate(c));
        System.out.println(p2.evaluate(c));
        System.out.println(st1.evaluate(c));
        
        destroyAll(new Condition[0]);
        System.out.println(battlefield.size());
    }
}
