class RomanNumeral {

    private final int num;
    private final char[] romanNumbers = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
    private final int[] arabicNumbers = {1, 5, 10, 50, 100, 500, 1000};

    public RomanNumeral(int num) {
        if (num < 1) {
            throw new IllegalArgumentException("must be positive");
        }
        this.num = num;
    }

    String getRomanNumeral() {
        int number = this.num;
        int count = 0;
        StringBuilder result = new StringBuilder();

        for (int i = this.romanNumbers.length - 1; i >= 0; ) {

            if (number / this.arabicNumbers[i] > 0) {

                result.append(this.romanNumbers[i]);
                number -= this.arabicNumbers[i];

                if (result.length() > 4 && count == 3 && result.charAt(result.length() - 5) == this.romanNumbers[i + 1]) {
                    result = new StringBuilder(result.substring(0, result.length() - 5));
                    result.append(this.romanNumbers[i]).append(this.romanNumbers[i + 2]);

                } else if (count == 3) {
                    result = new StringBuilder(result.substring(0, result.length() - 3));
                    result.append(this.romanNumbers[i + 1]);
                }
                count++;

            } else {
                count = 0;
                i--;
            }
        }
        return result.toString();
    }
}
