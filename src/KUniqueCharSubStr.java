import java.util.ArrayList;
import java.util.List;

/**
 * Created by bandi on 2/3/2016.
 */
public class KUniqueCharSubStr {
    public static void kUniqueCharSubStr(String s, int k)
    {
        List<Character> charList = new ArrayList<Character>();
        char[] arr = new char[k];
        int j= 0;
        for(int i =0; i<s.length();i++) {
        	char ch = s.charAt(i);
        	if(charList.contains(ch)){
        		j=0;
        		arr[j] = ch;
        		charList.removeAll(charList);
        		charList.add(ch);
        		j++;
        		continue;
        	}else {
        		if(j < k) {
	        		arr[j] = ch;
	        		j++;
	        		charList.add(ch);
        		}else
        			break;
        	}
        }
        for(int i =0; i<arr.length;i++) {
        	int ascii = arr[i];
        	System.out.print(ascii+" "+arr[i]+" ");
        }

    }

    public static void main(String[] args){
        String s  = "lkopwqabcdefgh";
        kUniqueCharSubStr(s,5);

    }
}
