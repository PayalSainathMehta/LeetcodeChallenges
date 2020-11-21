public class NumbersAtmostGivenNDigit {

    /*
    The logic is complicated to understand at first but
    1. we try to add the permutations upto nstr.length - 1digits for all digit in digits
    2. then we do a second pass to see if there is anyway we can have same number of digits as nstr.length but still be less than n
    for this, we pick digit by digit from digits[] and check < = , when less than we can again use Math.pow to find the permutations
    3. and when == we can recursively keep calling our function
     */
    static int atMostNGivenDigitSet(String[] digits, int n){
        //base case
        if(digits == null || digits.length == 0 || n == 0)
            return 0;

        //count upto length of n
        String nstr = Integer.toString(n);
        int digitsLength = digits.length;

        int result = 0;

        //1 to n - 1 // use upto n - 1 digits to form the number less than n
        //1. of algo
        for(int i = 1; i < nstr.length(); i++)
            result += Math.pow(digitsLength, i);

        //now try to find the number which can be equal to number of digits equal to digits of n but lesser than n
        result += calculateSameLength(digits, nstr, 0);
        return result;
    }

    static int calculateSameLength(String[] digits, String nstr, int index)
    {
        int total = 0;
        //if we are checking for last index of nstr, then simply check if digit <= nstr char and add 1 to total

        if(index == nstr.length() - 1)
        {
            for(String digit: digits)
                if(digit.charAt(0) <= nstr.charAt(index))
                    total++;
            return total;
        }

        //keep doing this only for digits less than or equal to char of n at index
        for(String digit: digits)
        {
            //2. of algo
            if (digit.charAt(0) < nstr.charAt(index))
                total += Math.pow(digits.length, nstr.length() - index - 1);

            //again same length - 3. of algo
            else if (digit.charAt(0) == nstr.charAt(index))
                total += calculateSameLength(digits, nstr, index + 1);
        }
        return total;
    }

    public static void main(String[] args) {
        String[] digits = {"7","8","9"};
        int n = 100;
        System.out.println(atMostNGivenDigitSet(digits, n));
    }
}
