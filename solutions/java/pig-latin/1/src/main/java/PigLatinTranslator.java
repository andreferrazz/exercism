class PigLatinTranslator {

    String translate(String text) {
        text = text.toLowerCase().trim();
        String result = "";
        String[] words = text.split(" ");
        for (int i = 0; i < words.length; i++) {
            result = result.concat(translateWord(words[i]) + " ");
        }
        result = result.trim();
        return result;
    }

    String translateWord(String word) {
        String result = word;
        boolean beginWithVowelSound;
        boolean beginWithConsonantClusterOfTwoLetters;
        boolean beginWithConsonantClusterOfThreeLetters;
        boolean beginWithYAfterConsonantCluster;
        boolean yIsSecondLetterInTwoLetterWord;

        /*
         * define rules of translator
         */
        beginWithVowelSound = word.charAt(0) == 'a' || word.charAt(0) == 'e' || word.charAt(0) == 'i'
                || word.charAt(0) == 'o' || word.charAt(0) == 'u' || word.substring(0, 2).equals("xr")
                || word.substring(0, 2).equals("yt");

        beginWithConsonantClusterOfTwoLetters = word.substring(0, 2).equals("ch") || word.substring(0, 2).equals("qu")
                || word.substring(0, 2).equals("th");

        yIsSecondLetterInTwoLetterWord = word.length() == 2 && word.charAt(1) == 'y';

        if (word.length() > 2) {
            beginWithConsonantClusterOfThreeLetters = word.substring(0, 3).equals("squ")
                    || word.substring(0, 3).equals("thr") || word.substring(0, 3).equals("sch");
            beginWithYAfterConsonantCluster = word.substring(0, 3).equals("rhy");
        } else {
            beginWithConsonantClusterOfThreeLetters = false;
            beginWithYAfterConsonantCluster = false;
        }

        /*
         * tranlate operation of each rule
         */
        if (beginWithVowelSound) {
            result = result.concat("ay");
            System.out.println("*");
        } else if (yIsSecondLetterInTwoLetterWord) {
            result = "y" + result.charAt(0) + "ay";
            System.out.println("**");
        } else if (beginWithConsonantClusterOfThreeLetters) {
            result = result.substring(3) + result.substring(0, 3) + "ay";
            System.out.println("***");
        } else if (beginWithYAfterConsonantCluster) {
            result = result.substring(2) + result.substring(0, 2) + "ay";
            System.out.println("****");
        } else if (beginWithConsonantClusterOfTwoLetters) {
            result = result.substring(2) + result.substring(0, 2) + "ay";
            System.out.println("*****");
        } else {
            result = result.substring(1) + result.charAt(0) + "ay";
            System.out.println("******");
        }

        return result;
    }
}
