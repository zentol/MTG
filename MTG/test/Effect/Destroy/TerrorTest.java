/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Effect.Destroy;

import Ability.Ability;
import static Ability.Ability.KEY_ABILITY_TYPE_SPELL;
import static Ability.Ability.KEY_ABILITY_TYPE_STATIC;
import Ability.Effect.Destroy.Destruction;
import Ability.Effect.Protection.AddIndestructible;
import static Card.Aspect.Aspect.KEY_ASPECT_ARTIFACT;
import static Card.Aspect.Permanent.Type.CreatureType.MYR;
import static Card.Aspect.Permanent.Type.CreatureType.SOLDIER;
import Card.Card;
import static Card.Color.Color.B;
import static Card.Color.Color.W;
import Card.Permanent;
import Card.Spell;
import Condition.Card.ConditionAspect;
import Condition.Card.ConditionColor;
import Condition.Card.ConditionInstance;
import Condition.Condition;
import Game.Game;
import static Game.Game.battlefield;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Shiren
 */
public class TerrorTest {

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }
    private Game game;
    private Permanent target;
    private Ability effect;

    public TerrorTest() {
    }

    @Before
    public void setUp() {
        game = new Game(2);

        target = new Permanent(1, 1, 0, 1, "Footsoldier", "W", W, false);
        target.addCreatureAspect(1, 1, new String[]{SOLDIER, MYR});
        battlefield.add(target);

        Spell s = new Spell(1, 1, 1, 1, "Terror", "1B", B, false);
        effect = new Destruction(
                1,
                KEY_ABILITY_TYPE_SPELL, 
                new Condition[]{
                    new ConditionColor(B, false),
                    new ConditionAspect(KEY_ASPECT_ARTIFACT, false)
                },
                null,
                null);
        s.addEffect(effect);

    }

    @After
    public void tearDown() {
    }

    @Test
    public void testExecuteNoInvulnerability() {
        activateAndExecuteEffect();
        assertEquals(0, battlefield.size());

    }

    @Test
    public void testExecuteInvulnerability() {
        addTargetInvulnerability();
        activateAndExecuteEffect();
        assertEquals(1, battlefield.size());
    }

    private void addTargetInvulnerability() {
        Ability e = new AddIndestructible(
                0,
                KEY_ABILITY_TYPE_STATIC,
                new Condition[]{
                    new ConditionInstance(new int[]{target.instanceID})},
                null,
                null
        );
        target.addEffect(e);
        e.execute();
    }

    private void activateAndExecuteEffect() {
        effect.activate(new Card[]{target});
        effect.execute();
    }

}
