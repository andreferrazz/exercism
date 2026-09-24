class Proverb {

    private final String[] words;

    Proverb(String[] words) {
        this.words = words;
    }

    String recite() {
        if(this.words == null || this.words.length == 0){
            return "";
        }
        StringBuilder text = new StringBuilder();
        for (int i = 1; i < this.words.length; i++) {
            text.append("For want of a ")
                    .append(this.words[i-1])
                    .append(" the ").append(this.words[i])
                    .append(" was lost.\n");
        }
        text.append("And all for the want of a ").append(this.words[0]).append(".");
        return text.toString();
    }
}
