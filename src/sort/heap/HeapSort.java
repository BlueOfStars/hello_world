package sort.heap;

import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args) {
        int[] arr = new int[]{4, 6, 8, 5, 9};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void heapSort(int[] arr){
        //建堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, arr.length, i);
        }
        //交换并重新调整堆
        for(int i = arr.length - 1; i > 0; i--){
            swap(arr, 0, i);
            adjustHeap(arr, i, 0);
        }
    }

    private static void adjustHeap(int[] arr, int arrayLength, int parentNodeIndex){
        int initialParentNodeValue = arr[parentNodeIndex];
        for(int childNodeIndex = parentNodeIndex * 2 + 1; childNodeIndex < arrayLength; childNodeIndex = parentNodeIndex * 2 + 1){
            if((childNodeIndex + 1) < arrayLength && arr[childNodeIndex] < arr[childNodeIndex + 1]){
                childNodeIndex++;
            }
            if(arr[childNodeIndex] > initialParentNodeValue){
                arr[parentNodeIndex] = arr[childNodeIndex];
                parentNodeIndex = childNodeIndex;
            }else{
                break;
            }
        }
        arr[parentNodeIndex] = initialParentNodeValue;
    }

    private static void swap(int[] arr, int m, int n){
        int temp = arr[m];
        arr[m] = arr[n];
        arr[n] = temp;
    }

}
