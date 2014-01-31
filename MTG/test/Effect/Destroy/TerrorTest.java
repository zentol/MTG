/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Effect.Destroy;

import static Card.Aspect.Permanent.Type.CreatureType.MYR;
import static Card.Aspect.Permanent.Type.CreatureType.SOLDIER;
import Card.Card;
import static Card.Color.Color.B;
import static Card.Color.Color.W;
import Card.Permanent;
import Card.Spell;
import Collection.Battlefield;
import Effect.Effect;
import Effect.Type.Static.StaticIndestructible;
import Game.Game;
import static Game.Game.battlefield;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Shiren
 */
public class TerrorTest {
    private Game game;
    private Permanent target;
    private Effect effect;

    public TerrorTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        game = new Game(2);

        target = new Permanent(1, 1, 0, 1, "Footsoldier", "W", W, false);
        target.addCreatureAspect(1, 1, new String[]{SOLDIER, MYR});
        battlefield.add(target);

        Spell s = new Spell(1, 1, 1, 1, "Terror", "1B", B, false);
        effect = new Terror(s);

    }

    @After
    public void tearDown() {
    }

    @Test
    public void testExecuteNoInvul() {
        activateAndExecuteEffect();
        Assert.assertEquals(0, battlefield.size());
    }

    @Test
    public void testExecuteInvul() {
        addTargetInvulnerability();
        activateAndExecuteEffect();
        Assert.assertEquals(1, battlefield.size());
    }

    private void addTargetInvulnerability() {
        target.effects.add(new StaticIndestructible(target, target));
        target.effects.get(0).execute();
    }

    private void activateAndExecuteEffect() {
        effect.activate(new Card[]{target});
        effect.execute();
    }
}
