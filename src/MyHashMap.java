import javax.swing.text.html.HTMLDocument;
import java.util.*;

/**
 * Created by bandi on 3/21/2016.
 */
public class MyHashMap {
    public static void main(String[] args){
        Map<String, String> map = new HashMap<>();
        map.put("one","oneV");
        map.put("two","twoV");
        map.put("three","threeV");
        map.put("four","fourV");
        map.put("five","fiveV");
        System.out.println(map);
        System.out.println("+++++++++++++++++++++++++++=");
        Iterator it = map.entrySet().iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        Set<String> set = map.keySet();
        it = set.iterator();
        System.out.println("\n-------------------------------------");
        while(it.hasNext()){
            System.out.println(it.next());
        }
        System.out.println("-------------------------------------");

        Collection<String> coll = map.values();
        it = coll.iterator();
        System.out.println("\n-------------------------------------");
        while(it.hasNext()){
            System.out.println(it.next());
        }
        System.out.println("-------------------------------------");

    }
}
