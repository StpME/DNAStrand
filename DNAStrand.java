// Name: Mitchell Stapelman
// Section: DG
// Represents a DNAStrand with a string.
public class DNAStrand {
    private Nucleotide front;
    
    // Constructs a DNAStrand object with the given string.
    public DNAStrand(String dna) {
        front = new Nucleotide(dna.charAt(0));
        Nucleotide curr = front;

        for(int i = 1; i < dna.length(); i++) {
                curr.next = new Nucleotide(dna.charAt(i));
                curr = curr.next;
        }
    }
    
    // Returns the number of times that the given substrand is repeated consecutively in the DNA substrand.
    // Throws an IllegalArgumentException if given substrand is null or empty.
    public int maxConsecutiveRepeats(DNAStrand substrand) {
        if (substrand == null || substrand.front == null) {
            throw new IllegalArgumentException();
        }
        String strSubstrand = substrand.toString();
        int repeats = 0;
        Nucleotide current = front;
        while (current != null) {
            Nucleotide temp = current;
            int index = 0;
            while (temp != null && temp.data == strSubstrand.charAt(index % strSubstrand.length())) {
                index++;
                temp = temp.next;
            }
            if (repeats < (index / strSubstrand.length())) {
                repeats = (index / strSubstrand.length());
            }
            current = current.next;
        }
        return repeats;   
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Nucleotide current = front; current != null; current = current.next) {
            result.append(current.data);
        }
        return result.toString();
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (!(o instanceof DNAStrand)) {
            return false;
        }
        return this.toString().equals(o.toString());
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public static void main(String[] args) {
        DNAStrand dna = new DNAStrand("CTAGATA");
        DNAStrand str = new DNAStrand("AGAT");
        //DNAStrand dna = new DNAStrand("CAACACAAA");
        //DNAStrand str = new DNAStrand("A");
        System.out.println(dna.maxConsecutiveRepeats(str)); 
        
    
    }

    private static class Nucleotide {
        public char data;
        public Nucleotide next;

        public Nucleotide(char data) {
            this.data = data;
            this.next = null;
        }
    }
}
