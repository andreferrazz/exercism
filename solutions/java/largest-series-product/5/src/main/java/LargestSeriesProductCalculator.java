class LargestSeriesProductCalculator {
    private final String number;

    LargestSeriesProductCalculator(String inputNumber) {
        if (!(inputNumber.isBlank() || inputNumber.matches("[0-9]+"))) {
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

        long highest = 0;
        long current;

        for (int i = 0; i < this.number.length() - numberOfDigits + 1; i++) {

            current = getCurrent(i, numberOfDigits);

            highest = Math.max(current, highest);
        }
        return highest;
    }

    private long getCurrent(int i, int numberOfDigits) {
        long current = 1;

        for (int j = 0; j < numberOfDigits; j++) {

            current *= Character.getNumericValue(this.number.charAt(i + j));
        }
        return current;
    }
}
