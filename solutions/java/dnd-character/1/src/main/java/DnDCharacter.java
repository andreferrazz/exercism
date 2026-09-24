import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class DnDCharacter {

    private int strength;
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int wisdom;
    private int charisma;
    private int hitpoints;

    DnDCharacter() {
        this.strength = ability();
        this.dexterity = ability();
        this.constitution = ability();
        this.intelligence = ability();
        this.wisdom = ability();
        this.charisma = ability();
        this.hitpoints = 10 + modifier(this.constitution);
    }

    int ability() {
        Random random = new Random();
        List<Integer> values = new ArrayList<>(4);
        int smaller = 7;

        for (int i = 0; i < 4; i++) {
            values.add(random.nextInt(6) + 1);
            if (values.get(i) < smaller) smaller = values.get(i);
        }

        values.remove((Object) smaller);

        return values.stream().mapToInt(v -> v).sum();
    }

    int modifier(int input) {
        return (int) Math.floor(((input - 10) / 2.0));
    }

    int getStrength() {
        return this.strength;
    }

    int getDexterity() {
        return this.dexterity;
    }

    int getConstitution() {
        return this.constitution;
    }

    int getIntelligence() {
        return this.intelligence;
    }

    int getWisdom() {
        return this.wisdom;
    }

    int getCharisma() {
        return this.charisma;
    }

    int getHitpoints() {
        return this.hitpoints;
    }

}
