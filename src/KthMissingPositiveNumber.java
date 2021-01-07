public class KthMissingPositiveNumber {

    static int findMissing(int[] arr, int k){
        //using frequency array
        //given numbers are in range of 1000
        //TC O(n), SC O(1001) ~ O(1)
        int[] freq = new int[1001];
        for(int ele: arr)
            freq[ele] = 1;

        //traverse
        for(int i = 1; i < 1001; i++){
            if(freq[i] == 0)
                k--;
            if(k == 0)
                return i;
        }
        return 1000 + k; //default return when reached end of element
    }

    static int findMissingBinarySearch(int[] arr, int k){
        //binary search as array is sorted.
        //TC O(logn), SC O(1)
        int left = 0;
        int right = arr.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            int noOfMissingEle = arr[mid] - (mid + 1);
            if(noOfMissingEle >= k)
                right = mid - 1; //as our no. should be in left so we move r to l
            else
                left = mid + 1; //as our no. should be on right so we move l to r
        }
        //arr[left] - (left + 1) - k + 1 = arr[left] - left - k = arr[left] - (left + k)
//        int noOfMissingEleOnLeft = arr[left] - (left + 1);
//        int stepsBackward = noOfMissingEleOnLeft - k + 1;
//        return arr[left] - stepsBackward;
        return left + k; //cant access arr[left] now so avoid above 3 lines
    }

    public static void main(String[] args) {
        int[] arr = {2,3,4,5,11};
        int k = 5;
        System.out.println(findMissing(arr, k));
        System.out.println(findMissingBinarySearch(arr, k));
    }
}
