public class NumberOf1 {

    static int getHammingBit(int n){
        int count = 0;
        //32 bit
        for(int i = 0; i < 32; i++){
            if(((n >>> i) & 1) == 1)
                count++;
        }
        return count;
    }
    public static void main(String[] args) {
        int n = 00000000000000000000000000001011;
        System.out.println(getHammingBit(n));
    }
}
