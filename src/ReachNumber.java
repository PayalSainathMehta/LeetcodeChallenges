public class ReachNumber {

    public static int reachNumber(int target) {
        int count = 0;
        int sum = 0;
        if(target == 0)
            return 0;
        target = Math.abs(target);
        while(sum < target)
        {
            sum += count; //keep adding number of steps done
            count++; //increment countwed
        }
        while((sum - target) % 2 == 1) //difference is odd
        {
            sum += count; //keep adding number of steps done
            count++; //increment count
        }
        return count - 1;
    }

    public static void main(String[] args) {
        int target = 2;
        System.out.println(reachNumber(target));
    }
}
