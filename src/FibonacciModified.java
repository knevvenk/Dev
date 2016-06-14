import java.util.Scanner;

/**
 * Created by bandi on 3/10/2016.
 */
public class FibonacciModified {

    static void fibonacciModified(int a, int b, int n){
        int count = 2,c = -1;
        while(n > count){
            c = a+(b*b);
            a = b;
            b = c;
            count++;

        }
        System.out.println(c);
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int n = in.nextInt();
        fibonacciModified(a,b,n);
    }
}
