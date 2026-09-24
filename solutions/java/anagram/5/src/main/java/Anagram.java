import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Anagram {

    private final String word;

    public Anagram(String word) {
        this.word = word;
    }

    public List<String> match(List<String> candidates){
        List<String> result = new ArrayList<>();
        if(candidates == null){
            return result;
        }
        for(String candidate : candidates){
            if(isAnagram(candidate)){
                result.add(candidate);
            }
        }
        return result;
    }

    private boolean isAnagram(String candidate){
        String sortedWord = sortString(this.word.toLowerCase());
        String sortedCandidate = sortString(candidate.toLowerCase());
        return sortedWord.equals(sortedCandidate) && !word.equalsIgnoreCase(candidate);
    }

    private String sortString(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}