class IsogramChecker {

    boolean isIsogram(String phrase) {
        if (phrase == null) {
            throw new IllegalArgumentException("phrase must be not null.");
        }
        phrase = phrase.toLowerCase();
        for (int i = 0; i < phrase.length(); i++) {
            if (phrase.charAt(i) == '-' || phrase.charAt(i) == ' ') {
                continue;
            }
            if (phrase.indexOf(phrase.charAt(i)) != phrase.lastIndexOf(phrase.charAt(i))) {
                return false;
            }
        }
        return true;
    }

}
