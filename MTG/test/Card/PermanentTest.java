/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Card;

import Card.Aspect.Permanent.ArtifactAspect;
import Card.Aspect.Permanent.CreatureAspect;
import Card.Aspect.Permanent.EnchantmentAspect;
import Card.Aspect.Permanent.LandAspect;
import Card.Aspect.Permanent.PlaneswalkerAspect;
import static Card.Aspect.Permanent.Type.ArtifactType.*;
import static Card.Aspect.Permanent.Type.CreatureType.*;
import static Card.Aspect.Permanent.Type.EnchantmentType.*;
import static Card.Aspect.Permanent.Type.LandType.*;
import static Card.Aspect.Permanent.Type.PlaneswalkerType.*;
import Effect.Effect;
import Effect.Type.Static.StaticIndestructible;
import Effect.Type.Static.StaticProtectionColor;
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

    public PermanentTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        permanent = new Permanent(1, 1, 0, 1, "Footsoldier", "W", "W", false);

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
        Assert.assertTrue(permanent.hasAspect(ArtifactAspect.class));
        Assert.assertTrue(permanent.getAspect(ArtifactAspect.class).hasType(EQUIPMENT));
    }

    /**
     * Test of addCreatureAspect method, of class Permanent.
     */
    @Test
    public void testCreatureAspect() {
        int attack = 1;
        int defense = 1;
        String[] types = {SOLDIER, MYR};
        Effect[] effects = new Effect[0];
        permanent.addCreatureAspect(attack, defense, types, effects);
        Assert.assertTrue(permanent.hasAspect(CreatureAspect.class));
        Assert.assertTrue(permanent.getAspect(CreatureAspect.class).hasType(SOLDIER));
        Assert.assertTrue(permanent.getAspect(CreatureAspect.class).hasType(MYR));
        Assert.assertTrue(((CreatureAspect) permanent.getAspect(CreatureAspect.class)).getAttack() == 1);
        Assert.assertTrue(((CreatureAspect) permanent.getAspect(CreatureAspect.class)).getDefense() == 1);
    }

    /**
     * Test of addEnchantmentAspect method, of class Permanent.
     */
    @Test
    public void testEnchantmentAspect() {
        String[] types = {AURA};
        permanent.addEnchantmentAspect(types);
        Assert.assertTrue(permanent.hasAspect(EnchantmentAspect.class));
        Assert.assertTrue(permanent.getAspect(EnchantmentAspect.class).hasType(AURA));
    }

    /**
     * Test of addLandAspect method, of class Permanent.
     */
    @Test
    public void testLandAspect() {
        String[] types = {GATE};
        permanent.addLandAspect(types);
        Assert.assertTrue(permanent.hasAspect(LandAspect.class));
        Assert.assertTrue(permanent.getAspect(LandAspect.class).hasType(GATE));
    }

    /**
     * Test of addPlaneswalkerAspect method, of class Permanent.
     */
    @Test
    public void testPlaneswalkerAspect() {
        String[] types = {JACE};
        permanent.addPlaneswalkerAspect(types);
        Assert.assertTrue(permanent.hasAspect(PlaneswalkerAspect.class));
        Assert.assertTrue(permanent.getAspect(PlaneswalkerAspect.class).hasType(JACE));
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
        Assert.assertTrue(!permanent.hasEffect(StaticProtectionColor.class));
    }

    @Test
    public void testHasModifier() {
        new StaticIndestructible(permanent, permanent).execute();
        Assert.assertTrue(permanent.hasModifier(StaticIndestructible.class));
        Assert.assertTrue(!permanent.hasModifier(StaticProtectionColor.class));
    }

}
