public class BitComplement {

    static int getComplement(int n){
//        if(n == 0)
//            return 1;
//        if(n == 1)
//            return 0;
//        String temp = Integer.toBinaryString(n);
//        StringBuilder sb = new StringBuilder(temp);
//        for(int i = 0; i < temp.length(); i++) {
//            if (sb.charAt(i) == '0')
//                sb.setCharAt(i, '1');
//            else
//                sb.setCharAt(i, '0');
//        }
//        return Integer.parseInt(sb.toString(), 2);
        int x = 1;
        while(n > x)
            x = x * 2 + 1;
        return x - n;
    }
    public static void main(String[] args) {
        int n = 5;
        System.out.println(getComplement(n));
    }

}
