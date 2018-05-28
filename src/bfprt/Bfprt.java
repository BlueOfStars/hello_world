package bfprt;

import java.util.Arrays;

public class Bfprt {

    public static int getKeyByIndex(int[] arr, int index){
        if(index < 1 || index > arr.length)
            throw new RuntimeException("index输入错误");
        else
            return getKey(arr, 0, arr.length - 1, index - 1);
    }

    private static int getKey(int[] arr, int low, int high, int index){
        if(low < high){
            int i = low;
            int j = high;
            int key = getDatumValue(arr, low, high);
            while(i < j){
                while(i < j && arr[j] >= key) j--;
                if(i < j)
                    arr[i++] = arr[j];
                while(i < j && arr[i] < key) i++;
                if(i < j)
                    arr[j--] = arr[i];
            }
            arr[i] = key;
            if(i == index)
                return arr[i];
            else if(i > index){
                if((i - 1) < low)
                    return getKey(arr, low, low, index);
                else{
                    return getKey(arr, low, i - 1, index);
                }
            }
            else {
                if((i + 1) > high)
                    return getKey(arr, high, high, index);
                else
                    return getKey(arr, i + 1, high, index);
            }
        }else{
            if(low == index)
                return arr[low];
            else
                throw new RuntimeException("未知错误！");
        }
    }

    public static int getDatumValue(int[] arr, int start, int end){
        if(start == end){
            return arr[start];
        }else{
            int len = end - start + 1;
            int groupCount = len / 5 + (len % 5 == 0 ? 0 : 1) ;
            int[] median = new int[groupCount];
            for (int i = 0; i < median.length; i++) {
                int left = i * 5 + start;
                int right = (left + 4) < end ? (left + 4) : end;
                median[i] = getMedian(arr, left, right);
            }
            return getDatumValue(median, 0, median.length - 1);
        }
    }

    private static int getMedian(int[] arr, int left, int right){
        insertSort(arr, left, right);
        return arr[(left + right) / 2];
    }

    private static void insertSort(int[] arr, int left, int right){
        for (int i = left + 1; i <= right; i++) {
            int key = arr[i];
            int index ;
            for (index = i - 1; index >= left; index--) {
                if(arr[index] > key)
                    arr[index + 1] = arr[index];
                else
                    break;
            }
            arr[index + 1] = key;
        }
    }

    private static void printArr(int[] arr){
        for (int i = 1; i <= arr.length; i++) {
            System.out.print(arr[i - 1] + " ");
            if(i % 5 == 0)
                System.out.print("| ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int num = 20;
        int[] arr = new int[num];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100);
        }
        System.out.print("原始数组: ");
        printArr(arr);

        System.out.println(getKeyByIndex(arr, 5));

        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
