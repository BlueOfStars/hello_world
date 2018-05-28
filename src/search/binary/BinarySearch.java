package search.binary;

import java.util.Arrays;

public class BinarySearch {

    public static int binarySearch(int[] arr, int key){
        int left = 0;
        int right = arr.length - 1;
        int mid ;
        while(left <= right){
            mid = (left + right) / 2;
            if(arr[mid] == key)
                return mid;
            else if(arr[mid] < key)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {9, 7 ,4, 3, 2};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int index = binarySearch(arr, 3);
        System.out.println(index);
    }

}
