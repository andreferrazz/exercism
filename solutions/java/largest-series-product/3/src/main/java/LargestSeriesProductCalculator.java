class LargestSeriesProductCalculator {
    private final String number;

    LargestSeriesProductCalculator(String inputNumber) {
        if (!isOnlyDigits(inputNumber.trim())) {
            throw new IllegalArgumentException("String to search may only contain digits.");
        }
        this.number = inputNumber.trim();
    }

    long calculateLargestProductForSeriesLength(int numberOfDigits) {
        if (numberOfDigits < 0) {
            throw new IllegalArgumentException("Series length must be non-negative.");
        }
        if (numberOfDigits > this.number.length()) {
            throw new IllegalArgumentException("Series length must be less than or equal to the length of the string to search.");
        }

        long largest = 0;
        long current;
        int[] digits;

        for (int i = 0; i < this.number.length() - numberOfDigits + 1; i++) {

            digits = getDigits(i, i + numberOfDigits);

            current = multiplyElements(digits);

            largest = Math.max(current, largest);
        }
        return largest;
    }

    private boolean isOnlyDigits(String inputNumber) {
        for (char c : inputNumber.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    private int[] getDigits(int start, int end) {
        String[] stringDigits = this.number.substring(start, end).split("");
        int[] digits = new int[end - start];
        for (int i = 0; i < end - start; i++) {
            digits[i] = Integer.parseInt(stringDigits[i]);
        }
        return digits;
    }

    private long multiplyElements(int[] arr) {
        long result = 1;
        for (int element : arr) {
            result *= element;
        }
        return result;
    }
}
