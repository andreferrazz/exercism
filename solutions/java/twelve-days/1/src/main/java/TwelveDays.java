class TwelveDays {
    String[] ordinals = {
            "first", "second", "third", "fourth", "fifth", "sixth",
            "seventh", "eighth", "ninth", "tenth", "eleventh", "twelfth"
    };
    String[] cardinals = {
            "a", "two", "three", "four", "five", "six",
            "seven", "eight", "nine", "ten", "eleven", "twelve"
    };
    String[] words = {
            "Partridge", "Turtle Doves", "French Hens", "Calling Birds", "Gold Rings", "Geese-a-Laying", "Swans-a-Swimming",
            "Maids-a-Milking", "Ladies Dancing", "Lords-a-Leaping", "Pipers Piping", "Drummers Drumming"
    };

    String verse(int verseNumber) {
        verseNumber--;
        StringBuilder result = new StringBuilder(String.format("On the %s day of Christmas my true love gave to me: ", ordinals[verseNumber]));

        for (int i = verseNumber; i >= 0; i--) {

            if (i == 0 && verseNumber != 0) {
                result.append("and ");
            }

            result.append(cardinals[i]).append(" ").append(words[i]);

            if (i != 0) {
                result.append(", ");
            }
        }
        result.append(" in a Pear Tree.\n");
        return result.toString();
    }

    String verses(int startVerse, int endVerse) {
        StringBuilder result = new StringBuilder();
        for (int i = startVerse; i < endVerse; i++) {
            result.append(verse(i)).append("\n");
        }
        result.append(verse(endVerse));
        return result.toString();
    }

    String sing() {
        return verses(1, 12);
    }
}
