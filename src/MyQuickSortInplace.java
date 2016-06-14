import java.util.Scanner;

/**
 * Created by bandi on 1/5/2016.
 */
public class MyQuickSortInplace {
    static void sort(int[] ar, int minPos, int maxPos){
        if(minPos >= maxPos)
            return;
        int pos = partition(ar,minPos,maxPos);
        sort(ar,minPos,pos-1);
        sort(ar,pos+1,maxPos);

    }
    static int partition(int ar[], int minPos, int maxPos){
        printArray(ar);
        int pivot = ar[maxPos];
        int temp = 0;
        int j = minPos;
        for(int i=minPos;i<maxPos;i++){
            if(ar[i]<pivot){

                if(i>j){
                    temp = ar[i];
                    ar[i] = ar[j];
                    ar[j] = temp;
                }
                j++;
            }
        }
        temp = ar[j];
        ar[j] = pivot;
        ar[maxPos] = temp;
        printArray(ar);
        return j;
    }

    static void printArray(int[] ar) {
        for(int n: ar){
            System.out.print(n+" ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int i=0;i<n;i++){
            ar[i]=in.nextInt();
        }
        sort(ar,0,ar.length-1);
    }
}
