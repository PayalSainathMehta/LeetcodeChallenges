import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGates {

    static int[][] rooms = {{2147483647,-1,0,2147483647},
            {2147483647,2147483647,2147483647,-1},
            {2147483647,-1,2147483647,-1},
            {0,-1,2147483647,2147483647}};

    static int[][] wallsAndGates(int[][] rooms){
        if(rooms.length == 0 || rooms == null)
            return null;
        int rows = rooms.length;
        int cols = rooms[0].length;
        //we store the i, j of cells which have 0 value - i.e. gates in queue
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(rooms[i][j] == 0)
                    queue.add(new int[]{i,j});
            }
        }

        while(!queue.isEmpty())
        {
            int[] top = queue.remove();
            int row = top[0], col = top[1];
            if(row > 0 && rooms[row - 1][col] == Integer.MAX_VALUE){
                rooms[row - 1][col] = rooms[row][col] + 1;
                queue.add(new int[]{row - 1, col});
            }
            if(row < rows - 1 && rooms[row + 1][col] == Integer.MAX_VALUE){
                rooms[row + 1][col] = rooms[row][col] + 1;
                queue.add(new int[]{row + 1, col});
            }
            if(col > 0 && rooms[row][col - 1] == Integer.MAX_VALUE){
                rooms[row][col - 1] = rooms[row][col] + 1;
                queue.add(new int[]{row, col - 1});
            }
            if(col < cols - 1 && rooms[row][col + 1] == Integer.MAX_VALUE){
                rooms[row][col + 1] = rooms[row][col] + 1;
                queue.add(new int[]{row, col + 1});
            }
        }
        return rooms;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(wallsAndGates(rooms)));
    }
}
