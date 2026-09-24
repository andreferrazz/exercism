import java.util.Map;

class NucleotideCounter {

    private final String dna;

    public NucleotideCounter(String dna) {
        if (!dna.matches("[ATCG]+") && !dna.isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.dna = dna;
    }

    Map<Character, Integer> nucleotideCounts() {
        int a = 0;
        int c = 0;
        int g = 0;
        int t = 0;

        for (char ch : this.dna.toCharArray()) {

            if (ch == 'A') a++;
            else if (ch == 'C') c++;
            else if (ch == 'G') g++;
            else if (ch == 'T') t++;
        }
        return Map.of('A', a, 'C', c, 'G', g, 'T', t);
    }
}
