class FoodChain {
    String[] animals = {
            "fly", "spider", "bird", "cat", "dog", "goat", "cow"
    };
    String[] phrases = {
            "It wriggled and jiggled and tickled inside her.",
            "How absurd to swallow a bird!",
            "Imagine that, to swallow a cat!",
            "What a hog, to swallow a dog!",
            "Just opened her throat and swallowed a goat!",
            "I don't know how she swallowed a cow!"
    };

    String verse(int verseNumber) {
        if (verseNumber == 8) {
            return "I know an old lady who swallowed a horse.\nShe's dead, of course!";
        }

        --verseNumber;

        StringBuilder result = new StringBuilder("I know an old lady who swallowed a ");

        result.append(animals[verseNumber]).append(".\n");

        if (verseNumber > 0) {
            result.append(phrases[verseNumber - 1]).append("\n");
            for (int i = verseNumber; i > 0; i--) {
                if (animals[i].equals("bird")) {
                    result.append("She swallowed the bird to catch the spider that wriggled and jiggled and tickled inside her.\n");
                } else {
                    result.append("She swallowed the ")
                            .append(animals[i])
                            .append(" to catch the ")
                            .append(animals[i - 1])
                            .append(".\n");
                }
            }
        }
        result.append("I don't know why she swallowed the fly. Perhaps she'll die.");

        return result.toString();
    }

    String verses(int start, int end) {
        StringBuilder result = new StringBuilder();
        for (int i = start; i < end; i++) {
            result.append(verse(i)).append("\n\n");
        }
        return result.append(verse(end)).toString();
    }
}