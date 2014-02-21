/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Card;

import static Card.Aspect.Aspect.*;
import Card.Aspect.Permanent.CreatureAspect;
import static Card.Aspect.Permanent.Type.ArtifactType.EQUIPMENT;
import static Card.Aspect.Permanent.Type.CreatureType.MYR;
import static Card.Aspect.Permanent.Type.CreatureType.SOLDIER;
import static Card.Aspect.Permanent.Type.EnchantmentType.AURA;
import static Card.Aspect.Permanent.Type.LandType.GATE;
import static Card.Aspect.Permanent.Type.PlaneswalkerType.JACE;
import static Card.Color.Color.*;
import Condition.Card.ConditionInstance;
import Condition.Condition;
import Effect.Static.StaticIndestructible;
import Effect.Static.StaticInvulnerableColor;
import Game.Game;
import static Game.Game.battlefield;
import Modifier.Damaging.ModifierIndestructible;
import Modifier.Damaging.ModifierInvulnerableColor;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Zento
 */
public class PermanentTest {

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }
    private Permanent permanent;

    @Before
    public void setUp() {
        Game game = new Game(2);
        permanent = new Permanent(1, 1, 0, 1, "Footsoldier", "W", W, false);
        battlefield.add(permanent);

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of addArtifactAspect method, of class Permanent.
     */
    @Test
    public void testArtifactAspect() {
        String[] types = {EQUIPMENT};
        permanent.addArtifactAspect(types);
        assertTrue(permanent.hasAspect(KEY_ASPECT_ARTIFACT));
        assertTrue(permanent.getAspect(KEY_ASPECT_ARTIFACT).hasType(EQUIPMENT));

    }

    /**
     * Test of addCreatureAspect method, of class Permanent.
     */
    @Test
    public void testCreatureAspect() {
        int attack = 1;
        int defense = 1;
        String[] types = {SOLDIER, MYR};
        permanent.addCreatureAspect(attack, defense, types);
        assertTrue(permanent.hasAspect(KEY_ASPECT_CREATURE));
        assertTrue(permanent.getAspect(KEY_ASPECT_CREATURE).hasType(SOLDIER));
        assertTrue(permanent.getAspect(KEY_ASPECT_CREATURE).hasType(MYR));
        assertTrue(((CreatureAspect) permanent.getAspect(KEY_ASPECT_CREATURE)).getAttack() == 1);
        assertTrue(((CreatureAspect) permanent.getAspect(KEY_ASPECT_CREATURE)).getDefense() == 1);
    }

    /**
     * Test of addEnchantmentAspect method, of class Permanent.
     */
    @Test
    public void testEnchantmentAspect() {
        String[] types = {AURA};
        permanent.addEnchantmentAspect(types);
        assertTrue(permanent.hasAspect(KEY_ASPECT_ENCHANTMENT));
        assertTrue(permanent.getAspect(KEY_ASPECT_ENCHANTMENT).hasType(AURA));
    }

    /**
     * Test of addLandAspect method, of class Permanent.
     */
    @Test
    public void testLandAspect() {
        String[] types = {GATE};
        permanent.addLandAspect(types);
        assertTrue(permanent.hasAspect(KEY_ASPECT_LAND));
        assertTrue(permanent.getAspect(KEY_ASPECT_LAND).hasType(GATE));
    }

    /**
     * Test of addPlaneswalkerAspect method, of class Permanent.
     */
    @Test
    public void testPlaneswalkerAspect() {
        String[] types = {JACE};
        permanent.addPlaneswalkerAspect(types, 3);
        assertTrue(permanent.hasAspect(KEY_ASPECT_PLANESWALKER));
        assertTrue(permanent.getAspect(KEY_ASPECT_PLANESWALKER).hasType(JACE));
    }

    /**
     * Test of isTapped method, of class Permanent.
     */
    @Test
    public void testTap() {
        assertTrue(!permanent.isTapped());
        permanent.tap();
        assertTrue(permanent.isTapped());
        permanent.untap();
        assertTrue(!permanent.isTapped());
    }

    /**
     * Test of hasEffect method, of class Permanent.
     */
    @Test
    public void testHasEffect() {
        permanent.addEffect(new StaticIndestructible(new Condition[]{new ConditionInstance(new int[]{permanent.instanceID})}));
        assertTrue(permanent.hasEffect(StaticIndestructible.class));
        assertFalse(permanent.hasEffect(StaticInvulnerableColor.class));
    }

    @Test
    public void testHasModifier() {
        permanent.addEffect(new StaticIndestructible(new Condition[]{new ConditionInstance(new int[]{permanent.instanceID})}));
        permanent.effects.get(0).execute();
        assertTrue(permanent.hasModifier(ModifierIndestructible.class));
        assertFalse(permanent.hasModifier(ModifierInvulnerableColor.class));
    }

    @Test
    public void testIsColor() {
        assertTrue(permanent.isColor(W));
        assertFalse(permanent.isColor(B));
    }

}
