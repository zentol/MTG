package test;

import static Card.Aspect.Permanent.Type.CreatureType.MYR;
import static Card.Aspect.Permanent.Type.CreatureType.SOLDIER;
import Card.Card;
import Card.Permanent;
import static Card.Color.Color.*;
import Card.Spell;
import Effect.Destroy.Terror;
import Effect.Effect;
import Effect.Type.Static.StaticProtectionColor;
import Game.Game;
import static Game.Game.battlefield;

public class test {
    public static void main(String[] args) {
        Game game = new Game(2);
        /*
         //dummyLoadLibrary();
         //initGame();
         System.out.println(battlefield.size());

         //turn();
         System.out.println(battlefield.size());
         */
        Permanent c = new Permanent(1, 1, 0, 1, "Footsoldier", "W", W, false);
        c.addCreatureAspect(1, 1, new String[]{SOLDIER, MYR});
        battlefield.add(c);
        System.out.println(battlefield.size());

        //c.effects.add(new StaticIndestructible(c, c));
        //((StaticIndestructible) c.effects.get(0)).execute();
        c.effects.add(new StaticProtectionColor(c, c, B));
        ((StaticProtectionColor) c.effects.get(0)).execute();
        /*
         Permanent q = new Permanent(2, 2, 1, 2, "Footsoldier", "W", "W", false);
         q.addCreatureAspect(1, 1, new String[]{SOLDIER, MYR});
         battlefield.add(q);

         q.effects.add(new destroyother(q));
         ((destroyother) q.effects.get(0)).execute();
         */
        //System.out.println(((StaticProtectionColor) c.modifiers.get(0)).protectsAgainst("" + B));
        Spell s = new Spell(1, 1, 1, 1, "Terror", "1B", B, false);
        Effect t = new Terror(s);
        t.setTargets(new Card[]{c});
        t.execute();

        /*c.addArtifactAspect(new String[]{"Equipment"});
         Creature q = new Creature(1,1,null,null);
         *//*
         Condition q1 = new ConditionAspect(CreatureAspect.class);
         Condition p1 = new ConditionColorPositive("W");
         Condition p2 = new ConditionColorPositive("WR");
         Condition st1 = new ConditionSubType(new String[]{"Soldier", MYR});
         System.out.println(p1.evaluate(c));
         System.out.println(p2.evaluate(c));
         System.out.println(st1.evaluate(c));

         //destroyAll(new Condition[0]);
         */
        System.out.println(battlefield.size());
    }
}
