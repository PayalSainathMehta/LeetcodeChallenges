public class SearchInRotatedArray12 {

    static boolean search(int[] nums, int target){
        //this solution is for search in sorted rotated array 2, with comments for sisra 1
        int low = 0;
        int high = nums.length - 1;
        while(low <= high)
        {
            int mid = low + (high - low) / 2;
            if(nums[mid] == target)
                return true; //return mid for other problem

            //handling duplicates
            while(nums[mid] == nums[low] && low != mid)
                low++;
            while(nums[mid] == nums[high] && high != mid)
                high--;

            //now same as problem 1
            if(nums[low] <= nums[mid])
            {
                //target lies in between low and mid
                if (nums[low] <= target && target < nums[mid])
                    high = mid - 1;
                else
                    low = mid + 1;
            }
            else //when nums[low] > nums[mid]
            {
                if (nums[mid] < target && target <= nums[high])
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,1,1,1};
        System.out.println(search(nums, 3));
    }

}
