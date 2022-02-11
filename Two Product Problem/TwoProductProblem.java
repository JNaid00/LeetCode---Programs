import java.util.*;

public class TwoProductProblem {
    public static void main(String[] args) {
        int[] arr = twoProduct(new Integer[]{1, 2, -1, 4, 5},110);
        //System.out.println(arr.length);
        // System.out.println(arr[0]);
        // System.out.println(arr[1]);
    }
    public static int[] twoProduct(Integer[] r, int n) {
        List<Integer> t = Arrays.asList(r);
        System.out.println(t);
        for (int x : r) if (n % x == 0 && t.contains(n/x) &&
                   t.indexOf(x) > t.indexOf(n/x)) return new int[] {n/x, x};


      return new int[] {};
    }
    // public static int[] twoProduct(Integer[] arr, int n) {
    //     for (int i = 0; i < arr.length; i++) {
    //         for (int j = i; j >= 0; j--) {
    //             if (arr[i] * arr[j] == n)
    //             return new int[] {arr[j], arr[i]};
    //         }
    //     }
    //     return new int[] {};
    // }


    // public static int[] twoProduct(Integer[] arr, int n) {
	// 	int[] ans = new int[2];
    //     int sumIndex = -1;
    //     int count = 0;
    //     for (int i = 0; i < arr.length; i++) {
    //         for (int j = 0; j < arr.length; j++) {
    //             if (arr[i] * arr[j] == n) {
    //                 count++;
    //                 if  (count == 1)
    //                 {
    //                     ans[0] = arr[i];
    //                     ans[1] = arr[j];
    //                     sumIndex = i + j;
    //                 }
    //                 else{
    //                     if (i + j < sumIndex) {
    //                         ans[0] = arr[i];
    //                         ans[1] = arr[j];
    //                         sumIndex = i + j;
    //                     }
    //                 }
                    
    //             }
    //         }
    //     }
    //     if (count == 0)
    //     return new int[] {};

    //     return ans;
    // }
}
