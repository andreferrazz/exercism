class BeerSong {
    final String VERSE_TEMPLATE = "%s of beer on the wall, %s of beer.\n" +
            "Take one down and pass it around, %s of beer on the wall.";
    final String FINAL_VERSE = "No more bottles of beer on the wall, no more bottles of beer.\n" +
            "Go to the store and buy some more, 99 bottles of beer on the wall.";

    StringBuilder verse(int verseNumber) {
        StringBuilder verse = new StringBuilder();
        switch (verseNumber) {
            case 0:
                verse.append(FINAL_VERSE);
                break;
            case 1:
                verse.append(String.format(VERSE_TEMPLATE, "1 bottle", "1 bottle", "no more bottles")
                        .replace("one", "it"));
                break;
            case 2:
                verse.append(String.format(VERSE_TEMPLATE, "2 bottles", "2 bottles", "1 bottle"));
                break;
            default:
                verse.append(String.format(
                        VERSE_TEMPLATE,
                        verseNumber + " bottles",
                        verseNumber + " bottles",
                        (verseNumber - 1) + " bottles"));
        }
        return verse;
    }

    String sing(int start, int amount) {
        StringBuilder song = new StringBuilder();
        for (int i = 0; i < amount; i++) {
            song.append(verse(start--)).append("\n\n");
        }
        return song.toString();
    }

    String singSong() {
        return sing(99, 100);
    }
}
