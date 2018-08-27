/**
 * Created by bandi on 3/22/2016.
 */
class A{
    A(){
        System.out.println("A");
    }
    void f1(){
        System.out.println("f1a");
    }
}

class B extends A{
    B(){

        System.out.println("B");
    }

    void f1(){
        System.out.println("f1b");
    }
}

class C extends B{
    int x=0;
    C(){
        this(1);
        System.out.println(this.x+"---"+x);
        x = 2;
        System.out.println("C");
        System.out.println(this.x+"---"+x);

    }
    C(int y){
        this.x = y;
        System.out.println(x);
    }
    void f1(){
        System.out.println(this.x+"****"+x);
        x = 5;
        System.out.println(this.x+"****"+x);
    }
}
public class Test1 {
    public static void main(String[] args){
        A a = new C();
//        C c = new C();
        a.f1();
        int i = 1_2;
//        System.out.println(c.x);
    }

}
