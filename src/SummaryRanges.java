import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public static List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        int n = nums.length;
        //if no elements
        if(n == 0)
            return result;
        //if one, then add that and return
        if(n == 1){
            result.add(nums[0] + "");
            return result;
        }
        //traverse
        for(int i = 0; i < n; i++){
            int ele = nums[i];
            //increment till the consecutive difference is only one
            while(i + 1 < n && (nums[i + 1] - nums[i]) == 1)
                i++;
            //if not equal then add both
            if(ele != nums[i])
                result.add(ele + "->" + nums[i]);
            else
                //if equal then add
                result.add(ele + "");
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {0,2,3,4,6,8,9};
        System.out.println(summaryRanges(nums).toString());
    }
}
