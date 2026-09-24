class RaindropConverter {

    String convert(int number) {
        String result = "";

        if (number % 3 == 0)
            result += "Pling";

        if (number % 5 == 0)
            result += "Plang";

        if (number % 7 == 0)
            result += "Plong";

        if (number % 3 != 0)
            if (number % 5 != 0)
                if (number % 7 != 0)
                    return "" + number;
        return result;
    }

}
