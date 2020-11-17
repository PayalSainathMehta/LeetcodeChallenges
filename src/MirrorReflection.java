public class MirrorReflection {

    public static int mirrorReflection(int p, int q) {

        // extension * q = reflection * p
        int extension = q;
        int reflection = p;
        //both cant be even
        while(extension % 2 == 0 && reflection % 2 == 0){
            extension /= 2;
            reflection /= 2;
        }

        //even, odd
        if(extension % 2 == 0 && reflection % 2 != 0)
            return 0;
        //odd, odd
        if(extension % 2 != 0 && reflection % 2 == 0)
            return 2;
        //odd, even
        if(extension % 2 != 0 && reflection % 2 != 0)
            return 1;
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(mirrorReflection(2, 3));
    }
}
