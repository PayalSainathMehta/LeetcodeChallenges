public class StoneGame4 {
    public static boolean winnerSquareGame(int n) {
        boolean[] dp = new boolean[n + 1];
        for(int i = 1; i <= n; i++){
            for(int j = 1; j * j <= i; j++){
                //we check for other to be false, so we are true
                if(!dp[i - j * j]){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 7;
        System.out.println(winnerSquareGame(n));
    }
}
