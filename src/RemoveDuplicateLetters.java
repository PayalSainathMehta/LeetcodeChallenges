import java.util.LinkedList;
import java.util.Stack;

public class RemoveDuplicateLetters {
    //similar to smallestSubsequence with distinct letters

    /*
        1. Get last indices of each char
        2.
     */
    static String smallestSubsequence(String s){
        if(s == null || s.length() == 0)
            return s;
        int n = s.length();
        Stack<Integer> stack = new Stack<>();
        int[] last = new int[26];
        int[] seen = new int[26];
        //first pass get the last indices of each char
        for(int i = 0; i < n; i++)
            last[s.charAt(i) - 'a'] = i;
        //now check
        for(int i = 0; i < n; i++){
            int ch = s.charAt(i) - 'a';
            if(seen[ch]++ > 0)
                continue;
            while(!stack.isEmpty() && stack.peek() > ch && i < last[stack.peek()])
                seen[stack.pop()] = 0;
            stack.push(ch);
        }
        StringBuilder sb = new StringBuilder();
        for(int i: stack)
            sb.append((char)('a' + i));
        return sb.toString();
    }
    public static void main(String[] args) {
        String s = "cbacdcbc";
        System.out.println(smallestSubsequence(s));
    }
}
