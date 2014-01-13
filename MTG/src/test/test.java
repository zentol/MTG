package test;

import Card.Aspect.Permanent.CreatureAspect;
import Card.Permanent;
import static Card.Aspect.Permanent.Type.CreatureType.MYR;
import static Card.Aspect.Permanent.Type.CreatureType.SOLDIER;
import Condition.Condition;
import Condition.Card.ConditionAspect;
import Condition.Card.ConditionColor;
import Condition.Card.ConditionSubType;

public class test {
    public static void main(String[] args) {
        Permanent c = new Permanent(1, 1, 1, 1, "Footsoldier", "W", "W", false);

        c.addCreatureAspect(1, 1, new String[]{SOLDIER, MYR}, null);
        /*c.addArtifactAspect(new String[]{"Equipment"});
         Creature q = new Creature(1,1,null,null);
         */
        Condition q = new ConditionAspect(CreatureAspect.class);
        Condition p1 = new ConditionColor("W");
        Condition p2 = new ConditionColor("WR");
        Condition st1 = new ConditionSubType(new String[]{"Soldier",MYR});
        System.out.println(p1.evaluate(c));
        System.out.println(p2.evaluate(c));
        System.out.println(st1.evaluate(c));
    }
}
