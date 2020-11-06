public class DivisorWithinThreshold {

    static int getSmallestDivisor(int[] nums, int threshold){
        // we use binary search
        int low = 1; //smallest divisor
        int high = 0; //in high, we store the max of the array
        int sum = 0; //cumulative sum
        int result = 0; //final result which will be smallest divisor
        for(int num: nums)
            high = Math.max(num, high);
        while(low <= high)
        {
            int mid = low + (high - low) / 2;
            sum = 0;
            for(int num: nums)
            {
                if(num % mid == 0) //divisible
                    sum += num / mid;
                else
                    sum += (num / mid) + 1;
            }
            if(sum > threshold) //we went ahead, set low
                low = mid + 1;
            else { //found it, store
                high = mid - 1;
                result = mid;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,5,9};
        int threshold = 6;
        System.out.println(getSmallestDivisor(nums, threshold));
    }
}
