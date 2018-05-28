package sort.quick;

import java.util.Arrays;

public class QuickSort {

    public static void quickSort(int[] arr){
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int low, int high){
        if(low < high){
            int i = low;
            int j = high;
            int key = arr[low];
            while(i < j){
                while(i < j && arr[j] >= key) {
                    j--;
                }
                if(i < j)
                    arr[i++] = arr[j];
                while(i < j && arr[i] < key) {
                    i++;
                }
                if(i < j)
                    arr[j--] = arr[i];
            }
            arr[i] = key;
            sort(arr, low, i - 1);
            sort(arr, i + 1, high);
        }
    }

    public static void main(String[] args) {
        int[] arr = {8, 1, 6, 4, 7, 5, 9, 2, 0, 3, 1, 2, 5, 6};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
