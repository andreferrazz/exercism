import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class DiamondPrinter {

    List<String> printToList(char a) {
        // parts of each diamond line
        StringBuilder center; // characters and blanks between them
        StringBuilder padding; // blanks around the center

        // amount of diamond lines
        int numberOfLines = (a - 'A') * 2 + 1;

        // build diamond bottom from the middle down
        List<String> bottom = new ArrayList<>();
        for (int i = 0; i <= numberOfLines / 2; i++) {
            center = new StringBuilder();
            padding = new StringBuilder();

            padding.append(" ".repeat(i));

            center.append(a);
            center.append(" ".repeat(Math.max(0, numberOfLines - (i * 2 + 2))));
            if (i != numberOfLines / 2) center.append(a);

            bottom.add(String.valueOf(padding) + center + padding);
            a--;
        }

        // build diamond top
        List<String> top = new ArrayList<>(List.copyOf(bottom.subList(1, bottom.size())));
        Collections.reverse(top);

        // Put the top and bottom together
        List<String> diamond = new ArrayList<>();
        diamond.addAll(top);
        diamond.addAll(bottom);

        return diamond;
    }
}
