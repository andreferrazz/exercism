import java.util.List;

class ResistorColor {
    private final String[] colors = {
            "black",
            "brown",
            "red",
            "orange",
            "yellow",
            "green",
            "blue",
            "violet",
            "grey",
            "white",
    };

    int colorCode(String color) {
        return List.of(this.colors).indexOf(color);
    }

    String[] colors() {
        return this.colors;
    }
}
