class House {
    String[] phrases = {
            "house that Jack built.",
            "malt that lay in",
            "rat that ate",
            "cat that killed",
            "dog that worried",
            "cow with the crumpled horn that tossed",
            "maiden all forlorn that milked",
            "man all tattered and torn that kissed",
            "priest all shaven and shorn that married",
            "rooster that crowed in the morn that woke",
            "farmer sowing his corn that kept",
            "horse and the hound and the horn that belonged to"
    };

    String verse(int verse) {
        StringBuilder result = new StringBuilder("This is");
        for (int i = verse - 1; i >= 0; i--) {
            result.append(" the ").append(phrases[i]);
        }
        return result.toString();
    }

    String verses(int start, int end) {
        StringBuilder result = new StringBuilder();
        for (int i = start; i < end; i++) {
            result.append(verse(i)).append("\n");
        }
        return result.append(verse(end)).toString();
    }

    String sing() {
        return verses(1, 12);
    }
}
