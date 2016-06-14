import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by bandi on 1/5/2016.
 */
public class myQuickSort {

    static void quickSort(int[] ar, int minPos, int maxPos){
        if(minPos >= maxPos)
            return;
        int pos = partition(ar,minPos,maxPos);
        quickSort(ar,minPos,pos-1);
        quickSort(ar,pos+1,maxPos);
        printArray(ar, minPos, maxPos);
    }

    static int partition(int[] ar, int minPos, int maxPos) {
        int p = ar[minPos], pos;
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();

        for(int i=minPos+1;i<=maxPos;i++){
            if(p>ar[i]){
                left.add(ar[i]);
            }
            else
                right.add(ar[i]);
        }
        updateArray(left,ar,minPos);
        pos = left.size()+minPos;
        ar[pos] = p;
        updateArray(right,ar,pos+1);
        return pos;
    }

    static void updateArray(ArrayList<Integer> list, int ar[], int pos){
        for(int i=0;i<list.size();i++){
            ar[pos] = list.get(i);
            pos++;
        }
    }

    static void printArray(int[] ar, int minPos, int maxPos) {
        for(int n=minPos;n<=maxPos;n++){
            System.out.print(ar[n]+" ");
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
        quickSort(ar,0,ar.length-1);
    }
}
