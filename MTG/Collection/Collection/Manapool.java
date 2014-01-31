package Collection;

import Card.Color.Color;
import static Card.Color.Color.Colors.valueOf;
import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;



public class Manapool {
    private int manaBlack;
    private int manaBlue;
    private int manaGreen;
    private int manaRed;
    private int manaWhite;
    private int manaColorless;

    public Manapool() {
        manaBlack = 0;
        manaBlue = 0;
        manaGreen = 0;
        manaRed = 0;
        manaWhite = 0;
        manaColorless = 0;
    }

    public void addMana(String addition) {
        int startIndexColored = 0;
        try {
            manaColorless += parseInt(Character.toString(addition.charAt(0)));
            startIndexColored = 1;
        } catch (NumberFormatException nfe) {
        }
        for (int x = startIndexColored; x < addition.length(); x++) {
            add(addition.charAt(x));
        }
    }

    private void add(char mana) {
        switch (valueOf(valueOf(mana))) {
            case B:
                manaBlack++;
                break;
            case G:
                manaGreen++;
                break;
            case R:
                manaRed++;
                break;
            case W:
                manaWhite++;
                break;
            case U:
                manaBlue++;
                break;
            default:
                break;
        }
    }

    public void useMana(String cost) {
        if (contains(cost)) {
            int startIndexColored = 0;
            try {
                manaColorless -= parseInt(Character.toString(cost.charAt(0)));
                startIndexColored = 1;
            } catch (NumberFormatException nfe) {
            }
            for (int x = startIndexColored; x < cost.length(); x++) {
                switch (valueOf(valueOf(cost.charAt(x)))) {
                    case B:
                        manaBlack--;
                        break;
                    case G:
                        manaGreen--;
                        break;
                    case R:
                        manaRed--;
                        break;
                    case W:
                        manaWhite--;
                        break;
                    case U:
                        manaBlue--;
                        break;
                    default:
                        break;
                }
            }
        }
    }

    public boolean contains(String cost) {
        int colorless = 0;
        int black = 0;
        int blue = 0;
        int green = 0;
        int red = 0;
        int white = 0;

        int startIndexColored = 0;
        try {
            colorless = parseInt(Character.toString(cost.charAt(0)));
            startIndexColored = 1;
        } catch (NumberFormatException nfe) {
        }
        for (int x = startIndexColored; x < cost.length(); x++) {
            switch (valueOf(valueOf(cost.charAt(x)))) {
                case B:
                    black++;
                    break;
                case G:
                    green++;
                    break;
                case R:
                    red++;
                    break;
                case W:
                    white++;
                    break;
                case U:
                    blue++;
                    break;
                default:
                    break;
            }
        }
        return black <= manaBlack
                && blue <= manaBlue
                && green <= manaGreen
                && red <= manaRed
                && white <= manaWhite
                && (colorless <= manaColorless
                || colorless <= sumMana() - black - blue - green - red - white);
    }

    private int sumMana() {
        return manaBlack
                + manaBlue
                + manaGreen
                + manaRed
                + manaWhite
                + manaColorless;
    }

    public String checkMana() {
        StringBuilder result = new StringBuilder();
        if (manaColorless > 0) {
            result.append(manaColorless);
        }
        for (int x = 0; x < manaBlack; x++) {
            result.append(Color.Colors.B.toString());
        }
        for (int x = 0; x < manaBlue; x++) {
            result.append(Color.Colors.U.toString());
        }
        for (int x = 0; x < manaGreen; x++) {
            result.append(Color.Colors.G.toString());
        }
        for (int x = 0; x < manaRed; x++) {
            result.append(Color.Colors.R.toString());
        }
        for (int x = 0; x < manaWhite; x++) {
            result.append(Color.Colors.W.toString());
        }
        return result.toString();
    }

    public void empty() {
        manaBlack = 0;
        manaBlue = 0;
        manaGreen = 0;
        manaRed = 0;
        manaWhite = 0;
        manaColorless = 0;
    }
}
