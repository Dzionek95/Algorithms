import java.util.Collection;
import java.util.HashMap;

class PermutationOfPalindrome{


    public static void main(String[] args){
        String testString="aabb";


        System.out.println(checkIfPermutationOfPalindrome(testString));
    }

    private static boolean checkIfPermutationOfPalindrome(String testString) {
        testString=testString.replaceAll("\\s+","").toLowerCase();
        HashMap<Character, Integer> map= new HashMap<>();

        for(int i=0; i<testString.length(); ++i){
            char checkChar=testString.charAt(i);
            if(!map.containsKey(checkChar))
                map.put(checkChar, 1);
            else
                map.put(checkChar, map.get(checkChar)+1);
        }

        Collection<Integer> set= map.values();
        int counter=0;
        for(int a:set){
            if(a%2!=0)
                ++counter;
        }

        return counter<=1;
    }

}