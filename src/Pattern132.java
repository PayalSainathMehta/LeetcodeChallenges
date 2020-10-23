import java.util.Stack;

public class Pattern132 {

    static boolean find132Pattern(int[] nums){
        //approach, we form a min array to store leftmost minimum value at each pos
        //we push in stack if nums of current value is greater or equal to mins of current value
        int n = nums.length;
        if(n == 0)
            return false;
        int[] mins = new int[n];
        mins[0] = nums[0];
        for(int i = 1; i < n; i++)
            mins[i] = Math.min(nums[i], mins[i - 1]);

        Stack<Integer> st = new Stack();
        for(int j = n - 1; j >= 0; j--){
            if(nums[j] > mins[j]){
                //keep popping till peek is less than eq to min
                while(!st.isEmpty() && st.peek() <= mins[j])
                    st.pop();
                //found 132 pattern when nums is greater than peek
                if(!st.isEmpty() && st.peek() < nums[j])
                    return true;
                //push
                st.push(nums[j]);
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int[] nums = {-1,3,2,0};
        System.out.println(find132Pattern(nums));
    }
}
