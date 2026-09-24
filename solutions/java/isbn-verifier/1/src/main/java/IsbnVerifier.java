import java.util.ArrayList;
import java.util.List;

class IsbnVerifier {

    boolean isValid(String stringToVerify) {
        stringToVerify = stringToVerify.trim();
        if (stringToVerify.length() < 10 || stringToVerify.length() > 13) {
            return false;
        }

        List<Integer> digits = getDigits(stringToVerify);

        if (digits.size() != 10) {
            return false;
        }

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
