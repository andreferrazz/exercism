class Darts {
    private final double X;
    private final double Y;
    private final double distanceBetweenDartAndCenter;

    Darts(double x, double y) {
        this.X = x;
        this.Y = y;
        this.distanceBetweenDartAndCenter = calculateDistanceBetweenDartAndCenter();
    }

    private double calculateDistanceBetweenDartAndCenter() {
        double xSquared = Math.pow(this.X, 2);
        double ySquared = Math.pow(this.Y, 2);
        return Math.sqrt(xSquared + ySquared);
    }

    int score() {
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
