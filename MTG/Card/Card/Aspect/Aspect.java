package Card.Aspect;

import java.util.ArrayList;

public abstract class Aspect {
    public static final int KEY_ASPECT_PERMANENT = 1;
    public static final int KEY_ASPECT_SPELL = 2;

    public static final int KEY_ASPECT_ARTIFACT = 3;
    public static final int KEY_ASPECT_CREATURE = 4;
    public static final int KEY_ASPECT_ENCHANTMENT = 5;
    public static final int KEY_ASPECT_LAND = 6;
    public static final int KEY_ASPECT_PLANESWALKER = 7;

    public static final int KEY_ASPECT_INSTANT = 8;
    public static final int KEY_ASPECT_SORCERY = 9;

    public ArrayList<String> subType;
    public final int aspectType;

    public Aspect(int aspectType) {
        this.aspectType = aspectType;
    }

    public boolean hasType(String type) {
        return subType.contains(type);
    }

    public int getAspectType() {
        return aspectType;
    }
}
