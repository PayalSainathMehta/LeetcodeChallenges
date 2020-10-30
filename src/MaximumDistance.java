import com.sun.source.tree.Tree;

import java.util.TreeMap;

public class MaximumDistance {

    static int getMaxDistance(int[] seats){
        int n = seats.length;
        TreeMap<Integer, Integer> tmap = new TreeMap<>();
        for(int i = 0; i < n; i++){
            if(seats[i] == 1)
                tmap.put(i, i);
        }
        int index = 0, distance = 0, max = 0;
        for(int i = 0; i < n; i++){
            if(seats[i] == 1)
                continue;
            else{
                if(tmap.floorKey(i) == null)
                    index = tmap.ceilingKey(i);
                else if(tmap.ceilingKey(i) == null)
                    index = tmap.floorKey(i);
                else
                    index = (i - tmap.floorKey(i) > tmap.ceilingKey(i) - i) ? tmap.ceilingKey(i) : tmap.floorKey(i);
            }
            distance = Math.abs(i - index);
            max = Math.max(max, distance);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] seats = {1,0,0,0,1,0,1};
        System.out.println(getMaxDistance(seats));
    }
}
