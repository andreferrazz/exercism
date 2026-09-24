class MicroBlog {
    public String truncate(String input) {

        String[] inputArr = input.split("");
        StringBuilder result = new StringBuilder();


//        for (int i = 0; i < 5 && i < inputArr.length; i++) {
//            System.out.println(inputArr[i]);
//            System.out.println(Character.codePointAt(inputArr, i));
//            System.out.println(Character.isDefined(inputArr[i]));
//
//            if (inputArr[i] != '?')
//                result.append(inputArr[i]);
//        }
        System.out.println(inputArr.length);
        for (String c : inputArr) {
            if (Character.isUnicodeIdentifierStart(c.charAt(0)))
                result.append(c);
            if (c.charAt(0) == ' ')
                result.append(c);
        }

        if (result.length() > 5) {
            return result.toString().substring(0, 5);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(new MicroBlog().truncate("Fly 🛫"));
    }
}
