import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

class Allergies {

    private final List<Allergen> allergies;

    Allergies(int value) {
        allergies = new ArrayList<>();
        Map<Integer, Integer> indexes = Map.of(
                1, 0,
                2, 1,
                4, 2,
                8, 3,
                16, 4,
                32, 5,
                64, 6,
                128, 7
        );

        for (int i = (int) Math.pow(2, 10); value > 0; i /= 2) {

            if (value >= 256) { // ignore undefined allergies
                value = value >= i ? value - i : value;

            } else { // add allergy if valid
                if (value >= i) {
                    allergies.add(Allergen.values()[indexes.get(i)]);
                    value -= i;
                }
            }
        }

        Collections.reverse(this.allergies);
    }

    boolean isAllergicTo(Allergen allergen) {
        return allergies.contains(allergen);
    }

    public List<Allergen> getList() {
        return allergies;
    }
}
