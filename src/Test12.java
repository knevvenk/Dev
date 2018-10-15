import java.util.HashMap;
import java.util.Map;

/**
 * Created by bandi on 3/22/2016.
 */

interface I1{
    public static String name="i1";
    default void m1(){
        System.out.println("in I1");
    }
}

interface I2{
    public static String name="i2";
    default void m2(){
        System.out.println("in I1");
    }
}

interface I3 extends I1, I2{
	public static String name = "i3";
}
public class Test12 implements I1, I2{

    public static void method(int i, Map map){
        i+=5;
        map.put("one","one");
        map = new HashMap();
        map.put("two", "two");
    }
    public static void main(String[] args){

        System.out.println(I1.name);
//        System.out.println(name);
        System.out.println(I2.name);

        int i = 10;
        Map map = new HashMap<>();
        Map<Integer, Integer> map1 = new HashMap<>();
        System.out.println(map.get(1));
        method(i, map);
        System.out.println(map.size()+"  "+map.get("one"));
    }
}
