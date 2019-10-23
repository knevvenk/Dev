import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
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
    void m2t();
    default void m2(){
        System.out.println("in I1");
    }
}

interface I3 extends I1, I2{
	public static String name = "i3";
}
public class Test12 implements I3{

    public static void method(int i, Map map){
        i+=5;
        map.put("one","one");
        map = new HashMap();
        map.put("two", "two");
    }
    public static void main(String[] args){
    	BigInteger value = new BigInteger("91221152921504606883236");
    	System.out.println(value);
//    	System.out.println(Long.parseLong("11529215046068832360"));

    	String[] list = "DEVICEID".split(",");
		System.out.println(list);
		String s1 = "3DSECURE";
		String s2 = "3dSEcurE";
		System.out.println(s1+"   "+s2);
		if(s1.equals(s2.toUpperCase()))
			System.out.println("TRUEEEE");
		else
			System.out.println("FALSEEE");

        System.out.println(I1.name);
//        System.out.println(name);
        System.out.println(I2.name);

        int i = 10;
        Map map = new HashMap<>();
        Map<Integer, Integer> map1 = new HashMap<>();
        System.out.println(map.get(1));
        method(i, map);
        System.out.println(map.size()+"  "+map.get("one"));
        
        I3 i3 = new Test12();
        i3.m2t();
    }
	@Override
	public void m2t() {
		System.out.println("m2t");
	}
}
