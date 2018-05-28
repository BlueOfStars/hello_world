package sort.merge;

import java.util.Arrays;

public class MergeSort {

    public static void mergeSort(int[] arr){
        int[] temp = new int[arr.length];
        recursion(arr, 0, arr.length - 1, temp);
    }

    private static void recursion(int[] arr, int left, int right, int[] temp){
        if(left < right){
            int mid = (left + right) / 2;
            recursion(arr, left, mid, temp);
            recursion(arr, mid + 1, right, temp);
            insertSort(arr, left, mid, right, temp);
        }
    }

    private static void insertSort(int[] arr, int left, int mid, int right, int[] temp){
        int i = left;
        int j = mid + 1;
        int t = 0;
        while(i <= mid && j <= right){
            if(arr[i] < arr[j]){
                temp[t++] = arr[i++];
            }else{
                temp[t++] = arr[j++];
            }
        }
        while(i <= mid){
            temp[t++] = arr[i++];
        }
        while(j <= right){
            temp[t++] = arr[j++];
        }
        t = 0;
        while(left <= right){
            arr[left++] = temp[t++];
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 15, 8, 11, 7, 2, 18, 14, 5, 6, 13};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
