import java.util.ArrayList;
import java.util.List;

public class Anagram {

    private final String word;

    public Anagram(String word) {
        this.word = word.toLowerCase();
    }

    public List<String> match(List<String> candidates) {
        if(candidates == null){
            return new ArrayList<>();
        }
        final List<String> result = new ArrayList<>(candidates.size());
        boolean isAnagram;
        String lowercaseCandidate;
        for (String candidate : candidates) {
            lowercaseCandidate = candidate.toLowerCase();
            if (lowercaseCandidate.length() != this.word.length()) {
                continue;
            }
            if (lowercaseCandidate.equals(word)){
                continue;
            }
            isAnagram = verifyStringIsAnagram(lowercaseCandidate);
            if (isAnagram) {
                result.add(candidate);
            }
        }
        return result;
    }

    private boolean verifyStringIsAnagram(String candidate){
        long charOccurrencesInCandidate;
        long charOccurrencesInWord;
        for (int i = 0; i < this.word.length(); i++) {
            final char wordChar = this.word.charAt(i);
            charOccurrencesInCandidate = candidate.chars().filter(ch -> ch == wordChar).count();
            charOccurrencesInWord = this.word.chars().filter(ch -> ch == wordChar).count();

            if (!candidate.contains(wordChar + "") || charOccurrencesInCandidate != charOccurrencesInWord) {
                return false;
            }
        }
        return true;
    }
}