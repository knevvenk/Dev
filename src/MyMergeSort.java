/**
 * Created by bandi on 1/3/2016.
 */
public class MyMergeSort {

    private int[] array;
    private int[] mergeArr;
    private int inversionCount;
    public static void main(String a[]){

        int[] inputArr = {5,9,2,16,4,20,12,18};
        MyMergeSort mms = new MyMergeSort();
        mms.sort(inputArr);
        printArray(inputArr);
        System.out.println("Count"+mms.inversionCount);
    }

    private static void printArray(int[] ar) {
    	for(int i:ar){
            System.out.print(i);
            System.out.print(" ");
        }
    }
    public void sort(int inputArr[]) {
        this.array = inputArr;
        int length = inputArr.length;
        this.mergeArr = new int[length];
        inversionCount = 0;
        mergeSort(0, length - 1);
    }

    private void mergeSort(int lowerIndex, int higherIndex) {

        if (lowerIndex < higherIndex) {

            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
            System.out.println(lowerIndex+" "+middle+" "+higherIndex);
            // Below step sorts the left side of the array
            System.out.println("lower");
            mergeSort(lowerIndex, middle);
            // Below step sorts the right side of the array
            System.out.println("higer");
            mergeSort(middle + 1, higherIndex);
            // Now merge both sides
            mergeParts(lowerIndex, middle, higherIndex);
        }
    }

    private void mergeParts(int lowerIndex, int middle, int higherIndex) {
        System.out.println("MergeParts   "+lowerIndex+" "+middle+" "+higherIndex);
        for (int i = lowerIndex; i <= higherIndex; i++) {
            mergeArr[i] = array[i];
        }
        System.out.println("MergeArray is ");
        printArray(mergeArr);
        System.out.println();
        int i = lowerIndex;
        int j = middle + 1;
        int k = lowerIndex;
        while (i <= middle && j <= higherIndex) {
//            System.out.println(tempMergArr[i]+"-----------------"+tempMergArr[j]);
            if (mergeArr[i] <= mergeArr[j]) {
                array[k] = mergeArr[i];
                i++;
            } else {
                array[k] = mergeArr[j];
                //Add the inversion count
                inversionCount += (middle - i)+1;
                j++;
            }
            k++;
            System.out.println();
            System.out.println("aaaa===");
            printArray(array);
        }
        // Copy the left elements into the array
        while (i <= middle) {
//            System.out.println(k+"----"+i+"*************"+tempMergArr[i]);
            array[k] = mergeArr[i];
            k++;
            i++;
        }
        System.out.println("Actual Array is ");
        printArray(array);
    }
}
