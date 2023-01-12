import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.HashMap;

class Solution {
    public static void main(String[] args) {
        System.out.println(threeSum(new int[] { -1, 0, 1, 2, -1, -4 }).toString());
        System.out.println(threeSum(new int[] { 0, 1, 1 }).toString());
        System.out.println(threeSum(new int[] { 0, 0, 0 }).toString());
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        HashMap<String, String> exsists = new HashMap<String, String>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int j2 = j + 1; j2 < nums.length; j2++) {
                    if (nums[i] + nums[j] + nums[j2] == 0) {
                        int a = nums[i], b = nums[j], c = nums[j2];
                        if (a > c) {
                            int temp = a;
                            a = c;
                            c = temp;
                        }

                        if (a > b) {
                            int temp = a;
                            a = b;
                            b = temp;
                        }
                        if (b > c) {
                            int temp = b;
                            b = c;
                            c = temp;
                        }
                        if (exsists.containsKey(a + "," + b + "," + c) == false) {
                            ans.add(Arrays.asList(a, b, c));
                            exsists.put(a + "," + b + "," + c, "true");
                        }

                    }
                }
            }
        }

        return ans;
    }

}