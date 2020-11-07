public class ShortestUnsortedSubArray {

    static int getShortestLength(int[] nums){
// Algorithm
//1. start scanning from left to right - find the start index where current number > next number
//2. start scanning from right to left - find the end index where current number < prev number
//3. now find min and max in this range
//4. find the immediate element greater than min in index 0 to start,find the immediate element smaller than max in index end + 1 to n - 1,
//5. return new end - new start + 1
        int n = nums.length;
        int start = 0;
        int end = n - 1;
        int min, max;
        //1.
        for(int i = 0; i < n - 1; i++)
        {
            if(nums[i] > nums[i + 1]){
                start = i;
                break;
            }
        }
        //base check - when array is sorted
        if(start == 0)
            return 0;

        //2.
        for(int i = n - 1; i > 0; i--)
        {
            if(nums[i] < nums[i - 1]){
                end = i;
                break;
            }
        }
        //min, max - 3.
        min = max = nums[start];
        for(int i = start + 1; i <= end; i++){
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }

        //4.
        for(int i = 0; i < start; i++)
        {
            if(nums[i] > min)
            {
                start = i;
                break;
            }
        }

        for(int i = n -1; i >= end + 1; i--)
        {
            if(nums[i] < max)
            {
                end = i;
                break;
            }
        }
        return end - start + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(getShortestLength(nums));
    }
}
