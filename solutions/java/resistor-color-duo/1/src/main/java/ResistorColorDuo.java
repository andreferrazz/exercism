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
        return this.colors.indexOf(colors[0]) * 10 + this.colors.indexOf(colors[1]);
    }
}
