import java.util.HashMap;
import java.util.Map;

public class ArrayFormation {

    static boolean canFormStringBuilder(int[] arr, int[][] pieces){
        //main sb
        StringBuilder sb = new StringBuilder();
        for(int a: arr){
            sb.append(a);
            sb.append("#");
        }
        //now check for each piece
        for(int i = 0; i < pieces.length; i++){
            StringBuilder res = new StringBuilder();
            for(int j = 0; j < pieces[i].length; j++){
                res.append(String.valueOf(pieces[i][j]));
                res.append("#");
            }
            if(!sb.toString().contains(res.toString()))
                return false;
        }
        return true;
    }

    static boolean canFormHashMap(int[] arr, int[][] pieces){
        Map<Integer, int[]> mp = new HashMap<>();
        //map is basically
        // 78 -> {78},
        // 4 -> {4, 64},
        // 91 -> {91}
        //for input:- arr = [91,4,64,78], pieces = [[78],[4,64],[91]]
        for(int[] piece: pieces){
            mp.put(piece[0], piece);
        }
        int start = 0;
        //increment start when there are two values in the map
        while(start<arr.length){
            if(mp.containsKey(arr[start]))
            {
                int[] piece = mp.get(arr[start]);
                for(int i=0;i<piece.length;i++){
                    //91 = 91
                    //4 = 4
                    //64 = 64
                    if(arr[start] != piece[i])
                        return false;
                    else
                        start++;
                }
            }
            else
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {91,4,64,78};
        int[][] pieces = {{78},{4,64},{91}};
        System.out.println(canFormStringBuilder(arr, pieces));
        System.out.println(canFormHashMap(arr, pieces));
    }
}
