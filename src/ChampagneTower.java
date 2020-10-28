public class ChampagneTower {

    static double champagneTower(int poured, int query_row, int query_glass){
        double[][] dp = new double[101][101]; //as constraint given is 1 to 100
        dp[0][0] = poured; //first glass - pour everything in glass1
        for(int r = 0; r <= query_row; r++){ //go till query row
            for(int c = 0; c <= r; c++){ //at every line we have that number of glasses - at 1 - 1, 2 - 2, 3 - 3
                double overflow = (dp[r][c] - 1.0) / 2.0; //divide by half everytime
                if(overflow > 0){ //now put in the next glass
                    dp[r + 1][c] += overflow; //assign to next
                    dp[r + 1][c + 1] += overflow; //assign to next
                }
            }
        }
        return Math.min(1, dp[query_row][query_glass]); //return minimum as we started with poured as 2.
    }
    public static void main(String[] args) {
        int poured = 2, query_row = 1, query_glass = 1;
        System.out.println(champagneTower(poured, query_row, query_glass));
    }
}
