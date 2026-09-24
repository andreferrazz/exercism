class Darts {
    private final double x;
    private final double y;

    Darts(double x, double y) {
        this.x = x;
        this.y = y;
    }

    int score() {
        final double distanceFromCenter = Math.sqrt(x * x + y * y);

        if (distanceFromCenter <= 1) {
            return 10;
        }
        if (distanceFromCenter <= 5) {
            return 5;
        }
        if (distanceFromCenter <= 10) {
            return 1;
        }
        return 0;
    }
}
