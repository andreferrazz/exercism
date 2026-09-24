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
        List<String> codons = getCodons(rnaSequence);
        List<String> result = new ArrayList<>();

        for (String codon : codons) {
            result.add(aminoAcids.get(codon));
        }
        return result;
    }

    private List<String> getCodons(String rnaSequence) {
        List<String> codons = new ArrayList<>();
        String aux;

        for (int i = 0; i + 3 <= rnaSequence.length(); i += 3) {
            aux = rnaSequence.substring(i, i + 3);
            if (aminoAcids.get(aux).equals("STOP")) {
                break;
            }
            codons.add(aux);
        }
        return codons;
    }
}
