import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ProteinTranslator {

    List<String> translate(String rnaSequence) {
        Map<String, String> aminoAcids= getAminoAcids();
        List<String> codons = getCodons(rnaSequence);
        List<String> result = new ArrayList<>();

        for(String codon : codons){
            result.add(aminoAcids.get(codon));
        }
        return result;
    }

    private List<String> getCodons(String rnaSequence){
        List<String> codons = new ArrayList<>();
        String aux;
        for (int i = 0; i + 3 <= rnaSequence.length(); i+=3) {
            aux = rnaSequence.substring(i, i+3);
            if(aux.equals("UAA") || aux.equals("UAG") || aux.equals("UGA")){
                break;
            }
            codons.add(aux);
        }
        return codons;
    }

    private Map<String, String> getAminoAcids(){
        Map<String, String> aminoAcids= new HashMap<>();
        aminoAcids.put("AUG", "Methionine");
        aminoAcids.put("UUU", "Phenylalanine");
        aminoAcids.put("UUC", "Phenylalanine");
        aminoAcids.put("UUA", "Leucine");
        aminoAcids.put("UUG", "Leucine");
        aminoAcids.put("UCU", "Serine");
        aminoAcids.put("UCC", "Serine");
        aminoAcids.put("UCA", "Serine");
        aminoAcids.put("UCG", "Serine");
        aminoAcids.put("UAU", "Tyrosine");
        aminoAcids.put("UAC", "Tyrosine");
        aminoAcids.put("UGU", "Cysteine");
        aminoAcids.put("UGC", "Cysteine");
        aminoAcids.put("UGG", "Tryptophan");
        aminoAcids.put("UAA", "STOP");
        aminoAcids.put("UAG", "STOP");
        aminoAcids.put("UGA", "STOP");
        return aminoAcids;
    }
}
