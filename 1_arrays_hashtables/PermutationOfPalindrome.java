import java.util.Collection;
import java.util.HashMap;

class PermutationOfPalindrome{


    public static void main(String[] args){
        String tesString="aabbcd".replaceAll("\\s+","").toLowerCase();


        System.out.println(checkIfPermutationOfPalindrome(tesString));
    }

    private static boolean checkIfPermutationOfPalindrome(String tesString) {
        int counter=0;
        HashMap<Character, Integer> map= new HashMap<>();
        for(int i=0; i<tesString.length();++i){
            char checkChar=tesString.charAt(i);
            if(!map.containsKey(checkChar))
                map.put(checkChar, 1);
            else
                map.put(checkChar, map.get(checkChar)+1);

        }
        Collection<Integer> set= map.values();
        for(int a:set){
            if(a%2!=0)
                counter++;
        }

        return counter<=1 ? true:false;
    }


}