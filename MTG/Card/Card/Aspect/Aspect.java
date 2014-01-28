package Card.Aspect;

import java.util.ArrayList;

public abstract class Aspect {
    public static final int KEY_ASPECT_ARTIFACT = 1;
    public static final int KEY_ASPECT_CREATURE = 2;
    public static final int KEY_ASPECT_ENCHANTMENT = 3;
    public static final int KEY_ASPECT_LAND = 4;
    public static final int KEY_ASPECT_PLANESWALKER = 5;
    
    public static final int KEY_ASPECT_INSTANT = 6;
    public static final int KEY_ASPECT_SORCERY = 7;

    public ArrayList<String> subType;

    public boolean hasType(String type) {
        return subType.contains(type);
    }
}
