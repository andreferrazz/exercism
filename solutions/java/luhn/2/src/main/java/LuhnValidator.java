class LuhnValidator {

    boolean isValid(String candidate) {
        candidate = candidate.replace(" ", "");

        if (candidate.length() <= 1 || !candidate.matches("[0-9]+"))
            return false;

        int digit;
        int sum = 0;
        for (int i = candidate.length() - 1; i >= 0; i--) {

            digit = Character.getNumericValue(candidate.charAt(i));

            if (candidate.length() % 2 == 0) {
                if (i % 2 == 0) {
                    digit = doubleIt(digit);
                }
            } else {
                if (i % 2 == 1) {
                    digit = doubleIt(digit);
                }
            }
            sum += digit;
        }
        return sum % 10 == 0;
    }

    private int doubleIt(int digit) {
        digit *= 2;

        if (digit > 9) digit -= 9;

        return digit;
    }
}
