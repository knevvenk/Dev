/**
 * Created by bandi on 1/3/2016.
 */
public class MyInsertionSort {
    //5,3,4,7,1
    void insertionSort(int a[]){
        int n = a.length;
        int i,key,j;
        for(i=1;i<n;i++){
            key = a[i];
            j = i-1;
            while(j>=0&&a[j]>key){
                a[j+1] = a[j];
                j=j-1;
            }
            a[j+1] = key;
            for(int k =0; k<a.length;k++)
                System.out.print(a[k]+", ");
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args){
        int[] a = {5,3,4,7,1};
        MyInsertionSort sort = new MyInsertionSort();
        sort.insertionSort(a);
                for(int i =0; i<a.length;i++){
            System.out.print(a[i]+", ");
        }

    }
}
