package algorithm;

import com.sun.org.apache.regexp.internal.RE;

import static algorithm.demo4.quickSort2;
import static algorithm.demo5.quickSort3;

/**
 * 快排 1.0
 */
public class demo3 {
    public static void quickSort1(int[] arr) {
        if(arr == null || arr.length < 2) {
            return;
        }
        process1(arr, 0, arr.length-1);
    }
    // <= stand  的划分在左边
    // >  stand  的划分在右边
    public static void process1(int[] arr, int L, int R) {
        if(L >= R) {
            return;
        }
        int mid = partition(arr, L, R);
        process1 (arr, L, mid-1);
        process1 (arr, mid + 1, R);
    }

    public static int partition(int[] arr, int L, int R) {
            if(L > R) {
                return -1;
            }
            if(L == R) {
                return L;
            }
            int stand = arr[R]; // 标准
        int less = L - 1;
        int index = L;
        while(index < R) {
            if(arr[index] <= stand) {
                swap(arr, index, less+1);
                less++;
                index++;
            }else {
                index++;
            }
        }
        swap(arr, R, less+1);
        less++;
        return less;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // -- for test --

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    // for test
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    // for test
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // for test
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            int[] arr3 = copyArray(arr1);
            quickSort1(arr1);
            quickSort1(arr2);
            quickSort3(arr3);
            if (!isEqual(arr1, arr2) || !isEqual(arr2, arr3)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Oops!");

    }
}
