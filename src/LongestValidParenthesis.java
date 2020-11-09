import java.util.Stack;

public class LongestValidParenthesis {

    //this is similar to min remove to make valid parenthesis - Lc 1249
    static int getLength(String s){
        Stack<Integer> stack = new Stack();
        String[] str = s.split("");
        //initializations
        stack.push(-1);
        int result = 0;
        int curlen = 0;
        for(int i = 0; i < str.length; i++)
        {
            if(str[i].equals("("))
                stack.push(i);
            else
            {
                stack.pop();
                if(!stack.isEmpty()){
                    curlen = Math.abs(i - stack.peek());
                    result = Math.max(result, curlen);
                }
                else
                    stack.push(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "(()";
        System.out.println(getLength(s));
    }
}
