import java.util.Arrays;
import java.util.Stack;

public class MostCompetitiveSubsequence {

    public static int[] mostCompetitive(int[] nums, int k) {
        //monotonic - increasing stack
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < n; i++){
            while(!stack.isEmpty() && nums[i] < stack.peek() && stack.size() - 1 + n - i >= k)
                stack.pop();
            if(stack.size() < k)
                stack.push(nums[i]);
        }
        int[] result = new int[k];
        int j = 0;
        //since iterating, you directly go through internal implementation of stack which is deque.
        for(int res: stack)
            result[j++] = res;
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2,4,3,3,5,4,9,6};
        int k = 4;
        System.out.println(Arrays.toString(mostCompetitive(nums, k)));
    }

}
