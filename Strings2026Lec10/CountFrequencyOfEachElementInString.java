package src.Strings2026Lec10;

/*
Frequency distribution
 */
public class CountFrequencyOfEachElementInString {
    public static void main(String[] args) {
        String s = "aaabbcddddeee";

        countFrequencyOfEachElement(s);
    }

    /*
    ch = a

    a should get mapped to the point where a is pointing at freqArray
     */
    public static void countFrequencyOfEachElement(String s) {
        int[] freqArr = new int[26];

        for (int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);

            freqArr[ch - 'a'] += 1;
        }


        for (int i=0; i<freqArr.length; i++) {
            if (freqArr[i] != 0) {
                System.out.println((char)(i + 'a') + " -> " + freqArr[i]);
            }
        }
    }
}
