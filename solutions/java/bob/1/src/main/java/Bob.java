class Bob {
    String hey(String param) {
        param = param.trim();

        String result = "Whatever."; // presume anything else

        boolean isQuestion = param.endsWith("?");
        boolean isYell = param.toUpperCase().equals(param) && hasAlpha(param);
        boolean isEmpty = param.isEmpty();

        if(isEmpty){
            result = "Fine. Be that way!";
        }else if (isQuestion && isYell) {
            result = "Calm down, I know what I'm doing!";
        } else if (isQuestion) {
            result = "Sure.";
        } else if (isYell) {
            result = "Whoa, chill out!";
        }

        return result;
    }

    boolean hasAlpha(String s){
        if (s == null) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')) {
                return true;
            }
        }
        return false;
    }
}