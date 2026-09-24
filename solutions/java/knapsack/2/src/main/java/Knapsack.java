import java.util.List;

class Knapsack {

    int maximumValue(int capacity, List<Item> items) {

        // number of elements
        int n = items.size();

        int[][] table = new int[n + 1][capacity + 1];

        // initializing table with zero in the first column and row
        for (int i = 0; i <= capacity; i++)
            table[0][i] = 0;
        for (int i = 1; i <= n; i++)
            table[i][0] = 0;

        // storage the value and weight of the item in current iteration
        int value;
        int weight;

        // filling the table to obtain the maximum value that the knapsack can carry
        for (int i = 1; i <= n; i++) {

            value = items.get(i - 1).getValue();
            weight = items.get(i - 1).getWeight();

            for (int j = 1; j <= capacity; j++) {

                if (weight <= j) {

                    table[i][j] = Math.max((value + table[i - 1][j - weight]), table[i - 1][j]);

                } else {
                    table[i][j] = table[i - 1][j];
                }
            }
        }

        // last element of the table is the max value in the knapsack
        return table[n][capacity];
    }
}

class Item {

    private final int weight;
    private final int value;

    public Item(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public int getWeight() {
        return weight;
    }
}
