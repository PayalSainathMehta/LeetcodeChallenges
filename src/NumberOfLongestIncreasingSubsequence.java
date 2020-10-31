public class NumberOfLongestIncreasingSubsequence {

    static int getCount(int[] nums){
        int n = nums.length;
        if(n == 0 || nums == null)
            return 0;
        int max_len = 0;
        int result = 0; //this will store final count of LIS
        //len[i] => length of IS ending with nums[i]
        //cnt[i] => count of LIS ending with nums[i]
        int[] cnt = new int[n];
        int[] len = new int[n];
        for(int i = 0; i < n; i++){
            cnt[i] = len[i] = 1;
            for(int j = 0; j < i; j++){
                //if new number is greater than previous, we found another increasing subsequence
                if(nums[i] > nums[j]){
                    if(len[i] == len[j] + 1)
                        cnt[i] += cnt[j];
                    if(len[i] < len[j] + 1) {
                        len[i] = len[j] + 1;
                        cnt[i] = cnt[j];
                    }
                }
            }
            //if maximum length is same as length upto i, then add to result
            if(max_len == len[i])
                result += cnt[i];
            if(max_len < len[i]){
                max_len = len[i];
                result = cnt[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,4,7};
        System.out.println(getCount(nums));
    }
}
