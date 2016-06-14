/**
 * Created by bandi on 2/6/2016.
 */
public class MyHeapSort {

    private static int length;

    //12,6,5,10,9,17,19,4,15,7
    public static void sort(int[] a){
        int k =0;
        length = a.length-1;
        heapify(a);
        for(int i = length; i>0; i--){
            k++;
            swap(a,0,i);
            if(k == 3)
                System.out.println(a[length]);
            length = length - 1;
            maxHeap(a,0);
        }
    }

    public static void heapify(int[] a){
        for(int i = length/2;i >= 0; i--){
            maxHeap(a, i);
        }
    }

    public static void maxHeap(int[] a, int i)
    {
        int n = length;
        int left = 2*i+1;
        int right = 2*i+2;
        int max = i;
        if(left <= n && a[left]>a[max])
            max = left;
        if(right <= n && a[right]>a[max])
            max = right;

        if(max != i){
            swap(a, i, max);
            maxHeap(a, max);
        }
    }

    public static void swap (int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    public static void main(String[] args){
        int[] arr = {12,6,5,10,9,17,19,4,15,7};
        sort(arr);

        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+" ");

    }
}
