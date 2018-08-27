import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * 
 * @author banve02
 * Sort elements by frequency
 * 
 *  Input:  arr[] = {2, 5, 2, 8, 5, 6, 8, 8}
	Output: arr[] = {8, 8, 8, 2, 2, 5, 5, 6} //2 Should come first before 5 as 2's index is smaller than 5

	Input: arr[] = {2, 5, 2, 6, -1, 9999999, 5, 8, 8, 8}
	Output: arr[] = {8, 8, 8, 2, 2, 5, 5, 6, -1, 9999999}

 */
public class SortByFrequency {

	public static void main(String[] args) {
		//Take the input array and convert into the list of Elements objects
		ArrayList<Elements> list = new ArrayList<>();
		list.add(new Elements(999, 0, 1));
		list.add(new Elements(9, 1, 3));
		list.add(new Elements(8, 4, 2));
		list.add(new Elements(6, 2, 2));
		
		Collections.sort(list, new FrequencyComparator());
		System.out.println(list);
	}

}

class Elements{
	Integer data;
	Integer index;
	Integer frequency;
	
	public Elements(Integer data, Integer index, Integer frequency) {
		this.data = data;
		this.index = index;
		this.frequency = frequency;
	}

	public String toString() {
		return this.data.toString();
	}
}

class FrequencyComparator implements Comparator<Elements>{
	@Override
	public int compare(Elements e1, Elements e2) {
		if(e2.frequency != e1.frequency)
			return e2.frequency.compareTo(e1.frequency);
		else
			return e1.index.compareTo(e2.index);
	}
}