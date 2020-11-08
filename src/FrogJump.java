import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class FrogJump {
    public static boolean canCross(int[] stones) {
        int n = stones.length;
        for(int i = 3; i < n; i++) {
            if (stones[i] > stones[i - 1] * 2) //base case for TLE - i didn't understand this
                return false;
        }
        Stack<Integer> positions = new Stack();
        Stack<Integer> jumps = new Stack();
        Set<Integer> set = new HashSet();
        positions.push(0);
        jumps.push(0);
        int last = stones[n - 1];
        for(int stone: stones) //store all in a set
            set.add(stone);

        while(!positions.isEmpty()){
            int curPos = positions.pop();
            int curJump = jumps.pop();
            for(int i = curJump - 1; i <= curJump + 1; i++){
                if(i <= 0) // avoid jumping backwards or on the same spot continuously.
                    continue;
                int nextPos = curPos + i; //update
                if(nextPos == last) //check
                    return true;
                if(set.contains(nextPos))  //if this position is already recorded
                {
                    positions.push(nextPos);
                    jumps.push(i);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] stones = {0,1,3,5,6,8,12,17};
        System.out.println(canCross(stones));
    }
}
