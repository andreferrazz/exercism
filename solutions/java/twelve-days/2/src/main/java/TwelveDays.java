class TwelveDays {
    String[] ordinals = {
            "first", "second", "third", "fourth", "fifth", "sixth",
            "seventh", "eighth", "ninth", "tenth", "eleventh", "twelfth"
    };
    String[] strings = {
            "a Partridge", "two Turtle Doves", "three French Hens", "four Calling Birds", "five Gold Rings", "six Geese-a-Laying", "seven Swans-a-Swimming",
            "eight Maids-a-Milking", "nine Ladies Dancing", "ten Lords-a-Leaping", "eleven Pipers Piping", "twelve Drummers Drumming"
    };

    String verse(int verseNumber) {
        verseNumber--;
        StringBuilder result = new StringBuilder(String.format("On the %s day of Christmas my true love gave to me: ", ordinals[verseNumber]));

        for (int i = verseNumber; i >= 0; i--) {

            if (i == 0 && verseNumber != 0) {
                result.append("and ");
            }

            result.append(strings[i]);

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
