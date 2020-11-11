import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicates {
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        //now you only add in the result list if you have seen a number before.
        //how do you know that?
        //you take the absolute value of nums[i] and subtract 1 (as array is 0 indexed)
        //you then check if this value is less than 0, if it is, that means you have seen it before - so add to result list
        //in any case multiply this by -1
        //let's implement it!!

        for(int num: nums)
        {
            int cur = Math.abs(num);
            if(nums[cur - 1] < 0)
            {
                result.add(cur);
            }
            nums[cur - 1] *= -1;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(findDuplicates(nums).toString());
    }
}
