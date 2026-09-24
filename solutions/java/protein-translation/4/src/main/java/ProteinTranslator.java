import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class ProteinTranslator {

    private final Map<String, String> aminoAcids;

    public ProteinTranslator() {
        this.aminoAcids = Map.ofEntries(
                Map.entry("UUU", "Phenylalanine"),
                Map.entry("AUG", "Methionine"),
                Map.entry("UUC", "Phenylalanine"),
                Map.entry("UUA", "Leucine"),
                Map.entry("UUG", "Leucine"),
                Map.entry("UCU", "Serine"),
                Map.entry("UCC", "Serine"),
                Map.entry("UCA", "Serine"),
                Map.entry("UCG", "Serine"),
                Map.entry("UAU", "Tyrosine"),
                Map.entry("UAC", "Tyrosine"),
                Map.entry("UGU", "Cysteine"),
                Map.entry("UGC", "Cysteine"),
                Map.entry("UGG", "Tryptophan"),
                Map.entry("UAA", "STOP"),
                Map.entry("UAG", "STOP"),
                Map.entry("UGA", "STOP"));
    }

    List<String> translate(String rnaSequence) {
        List<String> result = new ArrayList<>();
        String protein;

        for (int i = 0; i + 3 <= rnaSequence.length(); i += 3) {
            protein = aminoAcids.get(rnaSequence.substring(i, i + 3));
            if(protein.equals("STOP")){
                break;
            }
            result.add(protein);
        }
        return result;
    }
}
