import java.util.HashMap;
import java.util.Map;

public class MaxOperations {

    public static int maxOperations(int[] nums, int k) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        //we store number, frequency
        for(int num: nums)
        {
            int complement = k - num;
            if (map.containsKey(complement)) {//exists we just count it
                count++;
                //we remove only if only 1 pair found as we need max operations to perform
                if (map.get(complement) == 1)
                    map.remove(complement);
                else
                    map.put(complement, map.get(complement) - 1);
            }
            else
                map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {3,1,3,4,3};
        int k = 6;
        System.out.println(maxOperations(nums, k));
    }
}
