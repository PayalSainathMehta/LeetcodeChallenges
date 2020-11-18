import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    static int[][] merge(int[][] intervals){
        if(intervals.length == 0)
            return new int[0][0];
        List<int[]> result = new ArrayList<>();
        int[] newInterval = intervals[0];
        result.add(newInterval);
        for(int[] interval: intervals){
            if(newInterval[1] >= interval[0]) //start of next is greater than current, then find max of ends
            {
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
            else //merge
            {
                newInterval = interval;
                result.add(newInterval);
            }
        }
        return result.toArray(new int[result.size()][2]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        System.out.println(Arrays.deepToString(merge(intervals)));
    }
}
