public class PoorPigs {

    /*
    followed this explanation - https://leetcode.com/problems/poor-pigs/discuss/94266/Another-explanation-and-solution
     */
    public static int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int pigs = 0;
        int timeLeft = minutesToTest/minutesToDie + 1;

        while(Math.pow(timeLeft, pigs) < buckets)
            pigs += 1;
        return pigs;
    }

    public static void main(String[] args) {
        System.out.println(poorPigs(25, 15, 60));
    }
}
