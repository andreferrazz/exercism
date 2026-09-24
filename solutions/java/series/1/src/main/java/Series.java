import java.util.ArrayList;
import java.util.List;

class Series {

    private final String numbers;

    public Series(String numbers) {
        this.numbers = numbers;
    }

    List<String> slices(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("Slice size is too small.");
        }
        if (n > this.numbers.length()) {
            throw new IllegalArgumentException("Slice size is too big.");
        }

        List<String> result = new ArrayList<>();

        for (int i = 0; i <= this.numbers.length() - n; i++) {
            result.add(this.numbers.substring(i, i + n));
        }
        return result;
    }
}