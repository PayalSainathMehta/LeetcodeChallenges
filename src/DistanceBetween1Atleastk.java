public class DistanceBetween1Atleastk {
    public static boolean kLengthApart(int[] nums, int k) {
        int count = k; //start with what you want
        for(int num: nums){
            if(num == 1){
                if(count < k) //if below simply false
                    return false;
                count = 0; //reset when 1
            }
            else //increment when 0
                count++;
        }
        return true; //none fell below k
    }

    public static void main(String[] args) {
        int[] nums = {1,0,0,0,1,0,1};
        int k = 2;
        System.out.println(kLengthApart(nums, k));
    }
}
