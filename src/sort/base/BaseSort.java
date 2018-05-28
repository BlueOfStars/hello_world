package sort.base;

import java.util.Arrays;

public class BaseSort {

    public static void insertSrot(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int index;
            for (index = i - 1; index >= 0 ; index--) {
                if(arr[index] > key)
                    arr[index + 1] = arr[index];
                else
                    break;
            }
            arr[index + 1] = key;
        }
    }

    public static void selectSort(int[] arr){
        int maxIndex ;
        int temp ;
        for (int i = arr.length - 1; i > 0; i--) {
            maxIndex = 0;
            for (int j = 1; j <= i; j++) {
                if(arr[maxIndex] < arr[j])
                    maxIndex = j;
            }
            temp = arr[maxIndex];
            arr[maxIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public static void bubbleSort(int[] arr){
        int temp ;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if(arr[j] > arr[j + 1]){
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 9, 1, 3, 4, 6, 8, 7, 0, 15, 17, 13, 16, 12, 19, 11};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
