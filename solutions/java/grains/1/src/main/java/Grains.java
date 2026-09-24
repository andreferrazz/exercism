import java.math.BigInteger;

class Grains {

    BigInteger grainsOnSquare(final int square) {
        if (square < 1 || square > 64) throw new IllegalArgumentException("square must be between 1 and 64");

        BigInteger result = new BigInteger("1");
        BigInteger two = new BigInteger("2");

        for (int i = 1; i < square; i++)
            result = result.multiply(two);

        return result;
    }

    BigInteger grainsOnBoard() {
        BigInteger result = new BigInteger("0");

        for (int i = 1; i <= 64; i++)
            result = result.add(grainsOnSquare(i));

        return result;
    }
}
