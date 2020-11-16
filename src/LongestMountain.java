public class LongestMountain {

    public static int longestMountain(int[] A) {
        int n = A.length;
        int result = 0;
        int[] up = new int[n];
        int[] down = new int[n];
        //trace the mountain
        //from left to right, add 1 as long as its increasing.
        //from right to left, add 1 as long as its increasing.
        for(int i = n - 2; i >= 0; i--)
            if(A[i] > A[i + 1])
                down[i] = down[i + 1] + 1;
        for(int i = 0; i < n; i++)
            if(i > 0 && A[i] > A[i - 1])
                up[i] = up[i - 1] + 1;
        //after this, for A[] = {2,1,4,7,3,2,5}
        //up[] = {0,0,1,2,0,0,0}
        //down[] = {0,0,0,2,1,0,0,0}
        for(int i = 0; i < n; i++){
            if(up[i] > 0 && down[i] > 0)
                result = Math.max(result, up[i] + down[i] + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a  = {2,1,4,7,3,2,5};
        System.out.println(longestMountain(a));
    }
}
