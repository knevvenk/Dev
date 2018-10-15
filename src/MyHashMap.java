import javax.swing.text.html.HTMLDocument;
import java.util.*;
import java.util.Map.Entry;

/**
 * Created by bandi on 3/21/2016.
 */
public class MyHashMap {
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();
		map.put("one", "aoneV");
		map.put("two", "dtwoV");
		map.put("three", "bthreeV");
		map.put("four", "efourV");
		map.put("five", "cfiveV");
		System.out.println(map);
		System.out.println("+++++++++++++++++++++++++++=");
		Iterator it = map.entrySet().iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		Set<String> set = map.keySet();
		it = set.iterator();
		System.out.println("\n-------------------------------------");
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		System.out.println("-------------------------------------");

		Collection<String> coll = map.values();
		it = coll.iterator();
		System.out.println("\n-------------------------------------");
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		System.out.println("-------------------------------------");

		sortByKeys(map);

		sortByValues(map);
	}

	private static void sortByKeys(Map<String, String> map) {
		Set<Entry<String, String>> entries = map.entrySet();
		Comparator<Entry<String, String>> keyComparator = new Comparator<Map.Entry<String, String>>() {

			@Override
			public int compare(Entry<String, String> e1, Entry<String, String> e2) {
				String key1 = e1.getKey();
				String key2 = e2.getKey();

				return key1.compareTo(key2);
			}
		};

		List<Entry<String, String>> listOfEntries = new ArrayList<Entry<String, String>>(entries);
		Collections.sort(listOfEntries, keyComparator);
		System.out.println(listOfEntries);
	}

	private static void sortByValues(Map<String, String> map) {
		Set<Entry<String, String>> entries = map.entrySet();
		Comparator<Entry<String, String>> valueComparator = new Comparator<Map.Entry<String, String>>() {

			@Override
			public int compare(Entry<String, String> e1, Entry<String, String> e2) {
				String value1 = e1.getValue();
				String value2 = e2.getValue();

				return value1.compareTo(value2);
			}
		};

		List<Entry<String, String>> listOfEntries = new ArrayList<Entry<String, String>>(entries);
		Collections.sort(listOfEntries, valueComparator);
		System.out.println(listOfEntries);

	}
}
