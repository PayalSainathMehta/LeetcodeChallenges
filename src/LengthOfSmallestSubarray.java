public class LengthOfSmallestSubarray {
    //returns length of smallest subarray with sum >= S
    public static int findMinSubArray(int S, int[] arr) {
        // TODO: Write your code here
        int length = arr.length;
        int windowSum = 0;
        int windowStart = 0;
        for(int i = 0; i < arr.length; i++){
            windowSum += arr[i];
            //since window size not fixed, we take while.
            while(windowSum >= S){
                length = Math.min(length, i - windowStart + 1);
                windowSum -= arr[windowStart]; //remove it
                windowStart++; //slide
            }
        }
        return length;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 2, 3, 2};
        int S = 7;
        System.out.println(findMinSubArray(S, arr));
    }
}
