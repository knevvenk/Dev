import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Arrange the integers such a way that program should return Large number.
 * @author banve02
 *
 */
public class LargestNumber {
	
	public static void main(String[] args) {
		List<Integer> A = new ArrayList<>();
		A.add(3);
		A.add(30);
		A.add(34);
		A.add(5);
		A.add(9);
		//output : 9534330
		
		System.out.println(getLargestNumber(A));
	}

	private static String getLargestNumber(List<Integer> A) {
		List<String> list = new ArrayList<>();
        
        int i=0, sum =0;
        while(i<A.size()) {
        	sum += A.get(i);
            list.add(String.valueOf(A.get(i)));
            i++;
        }
        if(sum <=0) {
            return "0";
        }
        Collections.sort(list, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                String a = o1+o2;
                String b = o2+o1;
                return a.compareTo(b) > 0 ? -1 : 1;
            }
        });
        String s= "";
        i =0;
        
        while(i<list.size()) {
            s+=list.get(i);
            i++;
        }
        return s;
	}

}
