import java.util.ArrayList;
import java.util.List;

public class Permutations2 {

    public static List<List<Integer>> getPermutations(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        dfs(nums, visited, new ArrayList<>(), result);
        return result;
    }

    static void dfs(int[] nums, boolean[] visited, List<Integer> temp, List<List<Integer>> result){
        if (temp.size() == nums.length)
        {
            result.add(new ArrayList<>(temp));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(visited[i] || i > 0 && nums[i - 1] == nums[i] && !visited[i - 1])
                continue;
            visited[i] = true; //mark visited
            temp.add(nums[i]); //add
            dfs(nums, visited, temp, result);
            //backtrack
            visited[i] = false;
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2};
        System.out.println(getPermutations(nums).toString());
    }

}
