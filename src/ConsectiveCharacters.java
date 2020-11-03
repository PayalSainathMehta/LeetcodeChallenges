//This code is similar to
//1. fruit in baskets - 2 baskets hence only two types of fruits - LC #904
//2. longest-substring-with-at-most-two-distinct-characters - 2 unique characters - LC #159


import java.util.HashMap;
import java.util.Map;

//LC - #1446
//now coming to this problem, we have to find the maximum length of a non-empty substring that contains only one unique character
public class ConsectiveCharacters {

    static int getLength(String s){
        int n = s.length();
        if(n == 0 || s == null)
            return 0;
        int i = 0, j = 0, max = 0;
        Map<Character, Integer> map = new HashMap<>();
        while(j < n)
        {
            if(map.size() <= 1) //since one unique character
                map.put(s.charAt(j), j++);
            if(map.size() > 1)
            {
                int min = n - 1;
                for(int value: map.values())
                    min = Math.min(min, value);
                i = min + 1;
                map.remove(s.charAt(min));
            }
            max = Math.max(max, j - i);
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "abbcccddddeeeeedcba";
        System.out.println(getLength(s));
    }
}
