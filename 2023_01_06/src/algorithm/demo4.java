package algorithm;

import com.sun.scenario.effect.impl.sw.java.JSWColorAdjustPeer;

/**
 * 快排 2.0
 */
public class demo4 {
    public static void quickSort2(int[] arr) {
        if(arr == null || arr.length < 2) {
            return;
        }
        process2(arr, 0, arr.length-1);
    }

    public static void process2(int[] arr, int L , int R) {
        if(L >= R) {
            return;
        }
        swap(arr, L + (int) (Math.random() * (R - L + 1)), R);
        int[] M = netherlandsFlag(arr, L, R); // 在 arr[L, R]上划分三个区域 < stand    = stand    > stand
        process2(arr, L, M[0]-1);
        process2(arr, M[1]+1, R);
    }

    public static int[] netherlandsFlag(int[] arr, int L , int R) {
        if (L > R) {
            return new int[]{-1, -1};
        }
        if (L == R) {
            return new int[]{L, R};
        }
        int stand = arr[R];
        int less = L - 1;
        int more = R;
        int index = L;
        while (index < more) {
            if (arr[index] < stand) {
                swap(arr, index, less + 1);
                less++;
                index++;
            } else if (arr[index] == stand) {
                index++;
            } else {
                swap(arr, index, more - 1);
                more--;
            }
        }
        swap(arr, more, R);
        more++;
        return new int[] {less + 1, more - 1};
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 5, 3, 1, 10, 6};
        quickSort2(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
