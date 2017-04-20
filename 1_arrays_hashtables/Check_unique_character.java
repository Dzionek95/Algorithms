import java.util.Random;

public class Check_unique_character{
    Random ran=new Random();

    public static void main(String[] args){

        for(int i=0; i<100000; ++i) {
            System.out.println(checkUniqueChar(createRandomString(ran.nextInt(52))));
        }
    }

    private static StringBuilder createRandomString(int size) {
        StringBuilder test=new StringBuilder("QWERTYUIOPLKJHGFDSAZXCVBNMqwertyuiopasdfghjklzxcvbnm");
        StringBuilder s=new StringBuilder(size);
        for(int i=0; i<size;++i){
            int randomInt=ran.nextInt(test.length());
            s.append(test.charAt(randomInt));
            test.deleteCharAt(randomInt);
        }

        return s;
    }




    private static boolean checkUniqueChar(StringBuilder checkString) {
        boolean[] flags=new boolean[128];
        for(int i=0; i<checkString.length(); ++i){
            int charToCheck=checkString.charAt(i);
            if(flags[charToCheck]) return false;
            flags[charToCheck]=true;

        }
        return true;
    }
}