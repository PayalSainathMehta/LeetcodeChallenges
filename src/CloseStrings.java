import java.util.Arrays;

public class CloseStrings {

    public static boolean closeStrings(String word1, String word2) {
        //we either want the frequency to be same for each character - swap
        //or we want the frequencies to be same in ascending order - transfer
        int[] c1 = new int[26];
        int[] c2 = new int[26];
        for(char c: word1.toCharArray())
            c1[c - 'a']++;
        for(char c: word2.toCharArray())
            c2[c - 'a']++;

        //we check character matching
        for(int i = 0; i < 26; i++){
            if(c1[i] == c2[i])
                continue;
            if(c1[i] == 0 || c2[i] == 0) //character doesnt exist in exactly c1 or c2, we can neither swap nor transfer
                return false;
        }
        //now we just check for transfer of frequencies.
        Arrays.sort(c1);
        Arrays.sort(c2);

        for(int i = 0; i < 26; i++)
            if(c1[i] != c2[i])
                return false;
        return true;
    }

    public static void main(String[] args) {
        //here we can transfer the frequencies
        String word1 = "aabc";
        String word2 = "ccba";
        System.out.println(closeStrings(word1, word2));
    }
}
