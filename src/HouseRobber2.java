public class HouseRobber2 {

    static int rob(int[] nums){
        int n = nums.length;
        if(n == 1)
            return nums[0];
        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }

    static int rob(int[] nums, int lo, int hi) {
        int include = 0, exclude = 0;
        for(int j = lo; j <= hi; j++){
            int i = include, e = exclude;
            include = e + nums[j];
            exclude = Math.max(e, i);
        }
       return Math.max(include, exclude);
    }
    public static void main(String[] args) {
        int[] nums = {2, 3, 2};
        System.out.println(rob(nums));
    }
}
