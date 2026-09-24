import java.util.Random;

public class Isbn13Generator {

    String generate(String isbn10) {
        IsbnVerifier verifier = new IsbnVerifier();
        if (!verifier.isValid(isbn10)) {
            return null;
        }

        String result = "978-".concat(isbn10);

        char[] array = result.toCharArray();

        while (!verifier.isValidIsbn13(result)) {
            int lastDigit = new Random().nextInt(11);
            if (lastDigit == 10) {
                array[array.length - 1] = 'X';
            } else {
                array[array.length - 1] = (lastDigit + "").charAt(0);
            }
            result = concat(array);
        }
        return result;
    }

    String concat(char[] array) {
        StringBuilder result = new StringBuilder();
        for (char c : array) {
            result.append(c);
        }
        return result.toString();
    }
}
