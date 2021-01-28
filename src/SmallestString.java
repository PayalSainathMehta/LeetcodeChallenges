import java.util.Arrays;

public class SmallestString {
    public static String getSmallestString(int n, int k) {
        char[] ca = new char[n]; //as n length
        Arrays.fill(ca, 'a');
        k = k - n; //as all a right now
        //as k becomes zero, we can keep remaining as 'a'
        while(k > 0){
            ca[--n] += Math.min(k, 25); //highest we can add 25 to 'a' to make 'z'
            k -= Math.min(k, 25);
        }
        return new String(ca);
    }

    public static void main(String[] args) {
        int n = 5, k = 73;
        System.out.println(getSmallestString(n, k));
    }
}
