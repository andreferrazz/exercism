class PhoneNumber {
    private String number;

    public PhoneNumber(String number) {
        String resultNumber = number.replaceAll("[+()-.\\s]", "");

        if (resultNumber.length() == 11) {
            if (resultNumber.charAt(0) != '1') {
                throw new IllegalArgumentException("11 digits must start with 1");
            } else {
                resultNumber = resultNumber.substring(1);
            }
        }
        if (resultNumber.length() > 11) {
            throw new IllegalArgumentException("more than 11 digits");
        }
        if (resultNumber.length() < 10) {
            throw new IllegalArgumentException("incorrect number of digits");
        }
        if (resultNumber.matches("(.*)[A-Za-z](.*)")) {
            throw new IllegalArgumentException("letters not permitted");
        }
        if (!resultNumber.matches("[0-9]+")) {
            throw new IllegalArgumentException("punctuations not permitted");
        }
        if (resultNumber.charAt(0) == '0') {
            throw new IllegalArgumentException("area code cannot start with zero");
        }
        if (resultNumber.charAt(0) == '1') {
            throw new IllegalArgumentException("area code cannot start with one");
        }
        if (resultNumber.charAt(3) == '0') {
            throw new IllegalArgumentException("exchange code cannot start with zero");
        }
        if (resultNumber.charAt(3) == '1') {
            throw new IllegalArgumentException("exchange code cannot start with one");
        }

        this.number = resultNumber;
    }

    String getNumber() {
        return this.number;
    }
}
