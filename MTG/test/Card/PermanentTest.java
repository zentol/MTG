/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Card;

import static Card.Aspect.Aspect.KEY_ASPECT_ARTIFACT;
import static Card.Aspect.Aspect.KEY_ASPECT_CREATURE;
import static Card.Aspect.Aspect.KEY_ASPECT_ENCHANTMENT;
import static Card.Aspect.Aspect.KEY_ASPECT_LAND;
import static Card.Aspect.Aspect.KEY_ASPECT_PLANESWALKER;
import Card.Aspect.Permanent.CreatureAspect;
import static Card.Aspect.Permanent.Type.ArtifactType.*;
import static Card.Aspect.Permanent.Type.CreatureType.*;
import static Card.Aspect.Permanent.Type.EnchantmentType.*;
import static Card.Aspect.Permanent.Type.LandType.*;
import static Card.Aspect.Permanent.Type.PlaneswalkerType.*;
import static Card.Color.Color.B;
import static Card.Color.Color.W;
import Effect.Type.Static.StaticIndestructible;
import Effect.Type.Static.StaticInvulnerableColor;
import Modifier.Protection.ModifierIndestructible;
import Modifier.Protection.ModifierInvulnerableColor;
import junit.framework.Assert;
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
    private Permanent permanent;

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        permanent = new Permanent(1, 1, 0, 1, "Footsoldier", "W", W, false);

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
        Assert.assertTrue(permanent.hasAspect(KEY_ASPECT_ARTIFACT));
        Assert.assertTrue(permanent.getAspect(KEY_ASPECT_ARTIFACT).hasType(EQUIPMENT));
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
        Assert.assertTrue(permanent.hasAspect(KEY_ASPECT_CREATURE));
        Assert.assertTrue(permanent.getAspect(KEY_ASPECT_CREATURE).hasType(SOLDIER));
        Assert.assertTrue(permanent.getAspect(KEY_ASPECT_CREATURE).hasType(MYR));
        Assert.assertTrue(((CreatureAspect) permanent.getAspect(KEY_ASPECT_CREATURE)).getAttack() == 1);
        Assert.assertTrue(((CreatureAspect) permanent.getAspect(KEY_ASPECT_CREATURE)).getDefense() == 1);
    }

    /**
     * Test of addEnchantmentAspect method, of class Permanent.
     */
    @Test
    public void testEnchantmentAspect() {
        String[] types = {AURA};
        permanent.addEnchantmentAspect(types);
        Assert.assertTrue(permanent.hasAspect(KEY_ASPECT_ENCHANTMENT));
        Assert.assertTrue(permanent.getAspect(KEY_ASPECT_ENCHANTMENT).hasType(AURA));
    }

    /**
     * Test of addLandAspect method, of class Permanent.
     */
    @Test
    public void testLandAspect() {
        String[] types = {GATE};
        permanent.addLandAspect(types);
        Assert.assertTrue(permanent.hasAspect(KEY_ASPECT_LAND));
        Assert.assertTrue(permanent.getAspect(KEY_ASPECT_LAND).hasType(GATE));
    }

    /**
     * Test of addPlaneswalkerAspect method, of class Permanent.
     */
    @Test
    public void testPlaneswalkerAspect() {
        String[] types = {JACE};
        permanent.addPlaneswalkerAspect(types, 3);
        Assert.assertTrue(permanent.hasAspect(KEY_ASPECT_PLANESWALKER));
        Assert.assertTrue(permanent.getAspect(KEY_ASPECT_PLANESWALKER).hasType(JACE));
    }

    /**
     * Test of isTapped method, of class Permanent.
     */
    @Test
    public void testTap() {
        Assert.assertTrue(!permanent.isTapped());
        permanent.tap();
        Assert.assertTrue(permanent.isTapped());
        permanent.untap();
        Assert.assertTrue(!permanent.isTapped());
    }

    /**
     * Test of hasEffect method, of class Permanent.
     */
    @Test
    public void testHasEffect() {
        permanent.effects.add(new StaticIndestructible(permanent, permanent));
        Assert.assertTrue(permanent.hasEffect(StaticIndestructible.class));
        Assert.assertFalse(permanent.hasEffect(StaticInvulnerableColor.class));
    }

    @Test
    public void testHasModifier() {
        new StaticIndestructible(permanent, permanent).execute();
        Assert.assertTrue(permanent.hasModifier(ModifierIndestructible.class));
        Assert.assertFalse(permanent.hasModifier(ModifierInvulnerableColor.class));
    }
    
    @Test
    public void testIsColor(){
        Assert.assertTrue(permanent.isColor(W));
        Assert.assertFalse(permanent.isColor(B));
    }

}
