import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by bandi on 1/8/2016.
 */
public class NextLexicoStr {

    static String getNextLexicographic(String s){
        if(s.length() == 1){
            return "no answer";
        }
        if(s.length() == 2){
            if((s.charAt(0) == s.charAt(1)) || (s.charAt(0)>s.charAt(1))){
                return "no answer";
            }
            else{
                s = Character.toString(s.charAt(1))+Character.toString(s.charAt(0));
                return s;
            }
        }
        char[] c = s.toCharArray();
        int i = c.length-1;
        for(;i>0;i--){
            if(c[i]>c[i-1])
                break;
        }
        if(i==0){
            return "no answer";
        }
        int j = c.length-1;
        while(c[j] <= c[i-1]){
            j--;
        }
        swap(c, i-1,j);
        j = c.length-1;
        while(i<j){
            swap(c,i,j);
            i++;
            j--;
        }
        String newString ="";
        for(int k =0;k<c.length;k++)
            newString += c[k];

        return newString;
    }

    static void swap(char c[],int i, int j){
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<String> listOfStr = new ArrayList<>();
        for(int i=0;i<n;i++){
            String s=in.next();
            listOfStr.add(getNextLexicographic(s));
        }
        listOfStr.forEach(System.out::println);
    }
}
