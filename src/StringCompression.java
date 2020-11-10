public class StringCompression {

    static int getCompression(char[] chars){
        int result = 0;
        int index = 0;
        while(index < chars.length){
            //every time new character , reset count to 0
            char currentChar = chars[index];
            int count = 0;
            //keep incrementing till adjacent characters are same
            while(index < chars.length && chars[index] == currentChar){
                index++;
                count++;
            }
            //result is the index we return
            chars[result++] = currentChar;
            if(count != 1){ //more than one character - that is when we do compression
                for(char c: Integer.toString(count).toCharArray()) //12 -> 1, 2
                    chars[result++] = c;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        char[] chars = {'a','b','b','b','b','b','b','b','b','b','b','b','b'};
        System.out.println(getCompression(chars));
    }
}
