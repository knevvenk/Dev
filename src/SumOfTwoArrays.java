/**
 * Created by bandi on 2/3/2016.
 *
 * int a[] = {9,9,2};
 int b[] = {0,1,3};
 output c[] = {1,0,0,5}
 */

public class SumOfTwoArrays {

    public static void sumOfTwoArrays(int a[], int b[]){
        int c[], carry = 0;
        int aLen = a.length-1;
        int bLen = b.length-1;
        if(aLen>bLen)
            c =new int[a.length+1];
        else if(aLen<bLen)
            c = new int[b.length+1];
        else
            c = new int[a.length+1];
        c[0] = 0;
        int cLen = c.length-1;
        while(aLen>=0 || bLen>=0){
            if(aLen<0)
                c[cLen] = b[bLen];
            else if(bLen<0)
                c[cLen] = a[aLen];
            else
            {
                int sum = a[aLen]+b[bLen]+carry;
                if(sum > 9)
                {
                    sum -= 10;
                    c[cLen] = sum;
                    carry = 1;
                }
                else {
                    c[cLen] = sum;
                    carry = 0;
                }
            }
            aLen--;
            bLen--;
            cLen--;
        }
        if(carry == 1)
            c[0] = 1;
        for(int i = 0; i<c.length;i++)
            System.out.print(c[i]+" ");
    }
    public static void main(String[] args)
    {
        int a[] = {1,2,3};
        int b[] = {4,5,6};
        sumOfTwoArrays(a,b);
    }
}
