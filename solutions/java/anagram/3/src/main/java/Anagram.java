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

        final List<String> result = new ArrayList<>();

        for (String candidate : candidates) {
            if (isAnagram(candidate)) {
                result.add(candidate);
            }
        }
        return result;
    }

    private boolean isAnagram(String candidate){
        candidate = candidate.toLowerCase();
        if (candidate.length() != this.word.length()) {
            return false;
        }
        if (candidate.equals(word)){
            return false;
        }

        long charOccurrencesInCandidate;
        long charOccurrencesInWord;

        for (int i = 0; i < this.word.length(); i++) {
            char wordChar = this.word.charAt(i);
            charOccurrencesInCandidate = candidate.chars().filter(ch -> ch == wordChar).count();
            charOccurrencesInWord = this.word.chars().filter(ch -> ch == wordChar).count();

            if (charOccurrencesInCandidate != charOccurrencesInWord) {
                return false;
            }
        }
        return true;
    }
}