import java.util.ArrayList;
import java.util.List;

public class Allergies {

    private final List<Allergen> allergies;

    public Allergies(int score) {
        allergies = new ArrayList<>();

        for (Allergen allergy : Allergen.values()) {
            if ((allergy.getScore() & score) != 0) {
                allergies.add(allergy);
            }
        }
    }

    public boolean isAllergicTo(Allergen allergen) {
        return allergies.contains(allergen);
    }

    public List<Allergen> getList() {
        return allergies;
    }
}