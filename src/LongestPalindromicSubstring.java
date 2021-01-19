public class LongestPalindromicSubstring {
    static int low, maxlen;
    static String longestPalindromicSub(String s){
        int n = s.length();
        if(n < 2) //only one character
            return s;
        for(int i = 0; i < n - 1; i++){ //go till second last char
            //odd length palindrome
            extendPalindrome(s, i, i);
            //even length palindrome
            extendPalindrome(s, i, i + 1);
        }
        return s.substring(low, low + maxlen);
    }

    static void extendPalindrome(String s, int i, int j){
        //extend outwards till same character
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)){
            i--;
            j++;
        }

        if(maxlen < j - i - 1){
            maxlen = j - i - 1;
            low = i + 1;
        }
    }

    public static void main(String[] args) {
        String s = "bdadadss";
        System.out.println(longestPalindromicSub(s));
    }
}
