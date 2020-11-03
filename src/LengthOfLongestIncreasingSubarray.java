public class LengthOfLongestIncreasingSubarray {

    static int getMaxLength(int[] nums){
        int n = nums.length;
        if(n == 0 || nums == null)
            return 0;
        int maxLen = 1, len = 1;
        for(int i = 1; i < n; i++){
            if(nums[i] > nums[i - 1])
                len++;
            else {
                if (maxLen < len)
                    maxLen = len;
                len = 1;
            }
        }
        return Math.max(maxLen, len);
    }

    public static void main(String[] args) {
        int[] nums = {12, 13, 1, 5, 4, 7, 8, 10, 10, 11};
        System.out.println(getMaxLength(nums));
    }
}
