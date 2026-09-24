import java.util.List;

class ResistorColorDuo {
    List<String> colors = List.of(new String[]{
            "black",
            "brown",
            "red",
            "orange",
            "yellow",
            "green",
            "blue",
            "violet",
            "grey",
            "white"
    });

    int value(String[] colors) {
        int firstDigit = this.colors.indexOf(colors[0]);
        int secondDigit = this.colors.indexOf(colors[1]);
        return firstDigit * 10 + secondDigit;
    }
}
