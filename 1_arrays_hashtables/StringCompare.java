
import java.util.Scanner;
import static java.lang.Math.*;
public class StringCompare{

    public static void main(String ... args){
        Scanner sc=new Scanner(System.in);
        String firstString=sc.next();
        String secondString=sc.next();
        System.out.println(checkIfStringsAreAlmostSame(firstString,secondString));
    }
    // Overall complexity of my algorithm should be less than O(n+m)
    // In best case complexity is O(n)
    private static boolean checkIfStringsAreAlmostSame(String firstString, String secondString) {
        boolean returnFlag=false;
        boolean stopFlag=true;
        char[] firstStr=firstString.toCharArray();
        char[] secondStr=secondString.toCharArray();
        int counter=0;

        if(abs(firstStr.length-secondStr.length)>1)
            return returnFlag;
        else {
            //O(n) we're entering first loop
            for (int i = 0; i < firstStr.length && i < secondStr.length; ++i) {
                if((firstStr[i]=='\u0000' || secondStr[i]=='\u0000'))
                    break;
                if (firstStr[i] != secondStr[i]){
                    if(firstStr.length>secondStr.length && stopFlag) {
                        //O(n + m) if condition is true we're entering second (lazy) loop which deletes char
                        deleteValue(i, firstStr);
                        --i;
                        stopFlag=false;
                    }
                    else if(firstStr.length==secondStr.length && stopFlag){
                        firstStr[i]=secondStr[i];
                        --i;
                        stopFlag=false;
                    }
                    else{
                        //O(n + m)
                        deleteValue(i,secondStr);
                        --i;
                    }
                }
                else{
                    ++counter;
                }
                if(firstStr.length<secondStr.length){
                    if(firstStr.length==counter)
                        returnFlag=true;
                }
                else {
                    if(secondStr.length==counter)
                        returnFlag=true;
                }
            }
            return returnFlag;
        }
    }

    private static char[] deleteValue(int i, char[] arr){
        for(int j=i; j<arr.length-1;++j){
            arr[j]=arr[j+1];
        }
        arr[arr.length-1]='\u0000';
        return arr;
    }
}




