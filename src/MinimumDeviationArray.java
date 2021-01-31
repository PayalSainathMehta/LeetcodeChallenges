import java.util.PriorityQueue;

public class MinimumDeviationArray {

    /* ALGORITHM
        1. we add only even numbers to pq (maxHeap which will have max number at top)
        2. we are interested in minimum deviation which is max of array - min of array
        3. we try to minimize the max of array by dividing by 2 when its even
        4. we get the max as top of maxHeap
        5. we stop when max is odd, as we cant divide by 2 anymore
     */
    static int getMinDeviation(int[] nums){
        int min = Integer.MAX_VALUE;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        for(int num: nums){
            if(num % 2 == 1) //odd
                num *= 2;
            //add only even to pq
            min = Math.min(min, num);
            maxHeap.add(num);
        }

        int diff = Integer.MAX_VALUE;

        while(maxHeap.peek() % 2 == 0) //till max is even, we can reduce it by div by 2
        {
            int max = maxHeap.poll();
            diff = Math.min(diff, max - min); //current diff
            //reducing the max by dividing
            int new_max = max / 2;
            min = Math.min(min, new_max);
            maxHeap.add(new_max);
        }
        return Math.min(diff, maxHeap.poll() - min);
    }
    public static void main(String[] args) {
        int[] nums = {2,10,8};
        System.out.println(getMinDeviation(nums));
    }
}
