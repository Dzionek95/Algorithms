
import java.util.Scanner;
import static java.lang.Math.*;
public class main {

    public static void main(String ... args){
        Scanner sc=new Scanner(System.in);
        String firstString=sc.next();
        String secondString=sc.next();


        System.out.println(checkIfStringsAreAlmostSame(firstString,secondString));
    }

    private static boolean checkIfStringsAreAlmostSame(String firstString, String secondString) {
        boolean flag=false;
        char[] arr1=firstString.toCharArray();
        char[] arr2=secondString.toCharArray();
        int counter=0;
        boolean flag2=true;
        if(abs(arr1.length-arr2.length)>1)
            return flag;
        else {
            for (int i = 0; i < arr1.length && i < arr2.length; ++i) {
                if((arr1[i]=='\u0000' || arr2[i]=='\u0000'))
                    break;
                if (arr1[i] != arr2[i]){
                    if(arr1.length>arr2.length) {
                        deleteValue(i, arr1);
                        --i;
                    }
                    else if(arr1.length==arr2.length && flag2){
                        arr1[i]=arr2[i];
                        --i;
                        flag2=false;
                    }
                    else{
                        deleteValue(i,arr2);
                        --i;
                    }
                }
                else{
                    counter++;
                }
                if(arr1.length<arr2.length){
                    if(arr1.length==counter)
                        flag=true;
                }
                else {
                    if(arr2.length==counter)
                        flag=true;
                }
            }
            return flag;
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




