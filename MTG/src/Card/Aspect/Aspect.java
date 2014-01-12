package Card.Aspect;

import java.util.ArrayList;

public abstract class Aspect {
    public ArrayList<String> subType;

    public boolean hasType(String type) {
        return subType.contains(type);
    }
}
