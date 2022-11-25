
public class TwoProductProblem {
    public static void main(String[] args) {
        int[] arr = twoProduct(new Integer[]{1, 2, -1, 4, 5},110);
        System.out.println(arr.length);
        System.out.println(arr[0]);
        System.out.println(arr[1]);
    }
    public static int[] twoProduct(Integer[] arr, int n) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j >= 0; j--) {
                if (arr[i] * arr[j] == n)
                return new int[] {arr[j], arr[i]};
            }
        }
        return new int[] {};
    }

}
