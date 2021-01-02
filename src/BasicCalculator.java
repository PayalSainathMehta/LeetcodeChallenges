import java.util.Stack;

public class BasicCalculator {

    static Stack<Integer> stack = new Stack();
    static int result = 0; //final result
    static int number = 0; //temp
    static int evaluate(String s){
        //push in stack only when opening bracket and reset result and sign
        //pop from stack only when closing bracket and reset number

        //for digit, calculate temp number
        //for +, calculate result, reset sign and number
        //for -, calculate result, reset sign and number

        int sign = 1; // + , -
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            //we got only 5 possibilities
            if(Character.isDigit(c)){
                //add to temp number
                number = 10 * number + (int)(c - '0');
            }
            else if(c == '+'){
                //calculate result and reset
                result += sign * number;
                sign = 1;
                number = 0;
            }
            else if(c == '-'){
                //calculate result and reset
                result += sign * number;
                sign = -1;
                number = 0;
            }
            else if(c == '('){
                //push to stack, first result then sign, reset both
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            }
            else if(c == ')') {
                //update result, pop
                result += sign * number;
                number = 0;
                result *= stack.pop(); //for sign
                result += stack.pop(); //for number
            }
        }
        if(number != 0)
            result += sign * number;
        return result;
    }

    //this is for basic calculator2 where we won't have paranthesis however we have * and /
    static int evaluate2(String s){
        stack = new Stack();
        char sign = '+'; //we always push first time
        int n = s.length();
        for(int i = 0; i < n; i++){
            char c = s.charAt(i);
            boolean isDigit = Character.isDigit(c);
            boolean isSpace = (c == ' ');
            if(isDigit)
                number = number * 10 + c - '0';
            if(!isDigit && !isSpace || i == n - 1)
            {
                if(sign == '+')
                    stack.push(number);
                if(sign == '-')
                    stack.push(-number);
                if(sign == '*')
                    stack.push(stack.pop() * number);
                if(sign == '/')
                    stack.push(stack.pop() * number);

                sign = c;
                number = 0;
            }
        }
        for(int val: stack)
            result += val;

        return result;
    }

    public static void main(String[] args) {
        String s = "(1+(4+5+2)-3)+(6+8)";
        System.out.println(evaluate(s));
        String s2 = " 3/2 ";
        System.out.println(evaluate2(s2));
    }
}
