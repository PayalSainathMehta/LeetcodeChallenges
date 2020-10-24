import java.util.Arrays;

public class BagOfTokens {
    public static int bagOfTokensScore(int[] tokens, int P) {
        //this is a very complicated problem to understand.
        //we need to maximize points
        //nevertheless we can use power to buy tokens and that buys us points
        //if we dont have enough power, but have points, trade points to buy tokens
        //otherwise we are done
        //return max points
        Arrays.sort(tokens);
        int i = 0;
        int j = tokens.length - 1;
        int points = 0;
        int maxPoints = 0;
        while(i <= j)
        {
            //first case - enough power
            if(P >= tokens[i]){
                points++; //gain points
                P -= tokens[i++]; //lose power
                maxPoints = Math.max(maxPoints, points); //maximize points
            }
            //no power but points
            else if(points > 0)
            {
                points--; //trade in points
                P += tokens[j--]; //gain power
            }
            else //no option
                return maxPoints;
        }
        return maxPoints;
    }

    public static void main(String[] args) {
        int[] tokens = {100,200,300,400};
        int p = 200;
        System.out.println(bagOfTokensScore(tokens, p));
    }
}
