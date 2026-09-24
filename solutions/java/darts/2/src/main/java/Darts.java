class Darts {
    private final double x;
    private final double y;

    Darts(double x, double y) {
        this.x = x;
        this.y = y;
    }

    int score() {
        final double distanceBetweenDartAndCenter = Math.sqrt(x * x + y * y);

        if (distanceBetweenDartAndCenter <= 1) {
            return 10;
        }
        if (distanceBetweenDartAndCenter <= 5) {
            return 5;
        }
        if (distanceBetweenDartAndCenter <= 10) {
            return 1;
        }
        return 0;
    }
}
