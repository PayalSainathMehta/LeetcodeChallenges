public class ConcatenationBinary {
    public static int concatenatedBinary(int n) {
        int MOD = (int)(1e9 + 7);
        long res = 0;
        for (int i = 1; i <= n; i++) {
            int bitLen = (int)(Math.log(i) / Math.log(2)) + 1; //get binary length
            // System.out.println(bitLen);
            //bitLen = 1 for 1, 2 for 10, 2 for 11 (1 to 3) for n = 3
            // System.out.println("Res: " + res + " and bitlen: " + bitLen + " and result: " + (res << bitLen));
            res = ((res << bitLen) + i) % MOD;
            //res = (0000 0000 << 1) + 1 = 1
            //res = (0000 0001 << 2) + 2 = 6
            //res = (0000 0110 << 2) + 3 = 0001 1000 + 3 = 24 + 3 = 27
        }
        return (int)res;
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(concatenatedBinary(n));
    }
}
