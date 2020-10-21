import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollisions {

    public static int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        if(n == 0)
            return new int[0];
        Stack<Integer> stack = new Stack();
        for(int i = 0; i < n; i++)
        {
            int cur = asteroids[i];
            //if stack empty or positive asteroid simply push to stack
            if(stack.isEmpty() || cur > 0)
                stack.push(cur);
            else {
                //now start comparing
                while(true){
                  int peek = stack.peek();
                  //if negative in stack, we got to push
                  if(peek < 0){
                      stack.push(cur);
                      break;
                  }
                  //if equal but opp signs, just pop
                  else if(peek == -cur){
                      stack.pop();
                      break;
                  }
                  //if greater, do nothing
                  else if(peek > -cur){
                      break;
                  }
                  //if nothing else pop and push if empty
                  else{
                      stack.pop();
                      if(stack.isEmpty()){
                          stack.push(cur);
                          break;
                      }
                  }
                }
            }
        }

        int m = stack.size();
        int[] output = new int[m];
        for(int i = m - 1; i >= 0; i--)
            output[i] = stack.pop();

        return output;
    }
    public static void main(String[] args) {
        int[] asteroids = {5, 10, -5};
        System.out.println(Arrays.toString(asteroidCollision(asteroids)));
    }
}
