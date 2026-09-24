import java.util.ArrayList;
import java.util.List;

class IsbnVerifier {

    boolean isValid(String stringToVerify) {
        // check if is valid length
        stringToVerify = stringToVerify.trim();
        if (stringToVerify.length() < 10 || stringToVerify.length() > 13) {
            return false;
        }

        // get digits from string
        List<Integer> digits = getDigits(stringToVerify);

        // check if digits amount is valid (equal to 10)
        if (digits.size() != 10) {
            return false;
        }

        // apply formula to check if is valid ISBN
        int sum = 0;
        for (int i = 10; i > 0; i--) {
            sum += i * digits.get(i - 1);
        }
        return sum % 11 == 0;
    }

    List<Integer> getDigits(String stringToVerify) {
        List<Integer> digits = new ArrayList<>();
        for (int i = 0; i < stringToVerify.length(); i++) {
            char c = stringToVerify.charAt(i);

            if (i == stringToVerify.length() - 1 && c == 'X') {
                digits.add(10);

            } else if (Character.isDigit(c)) {
                digits.add(Character.getNumericValue(c));

            } else if (c != '-') {
                return digits; // invalid digits
            }
        }
        return digits;
    }
}
