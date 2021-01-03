public class BeautifulArrangement {

    static int count = 0;
    /*
        a beautiful arrangement is where for entire arrangement (index is divisible by number or number is divisible by i)
        so for n = 2,
        [1, 2] -> index 1 is divisible by 1 and index 2 is divisible by 2
        [2, 1] -> 2 is divisible by index 1 and index 2 is divisible by 1
    */
    // we use backtracking
    public static int countArrangement(int n){
        int[] used = new int[n + 1]; //to track used indices
        helper(n, 1, used);
        return count;
    }

    static void helper(int n, int pos, int[] used){
        //base condition - return if pos has exceeded our n value
        if(pos > n){
            count++;
            return;
        }
        //now traverse for all i upto n starting from 1
        for(int i = 1; i <= n; i++){
            if(used[i] == 0 && (i % pos == 0 || pos % i == 0)){
                used[i] = 1; //mark used
                helper(n, pos + 1, used); //call
                used[i] = 0; //backtrack
            }
        }
    }

    public static void main(String[] args) {
        int n = 3;
        /*
           input: 1,2,3 -> [1,2,3] [2,3,1] [3,2,1]
        */
        System.out.println(countArrangement(n));
    }
}
