import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[] { -1, 0, 1, 2, -1, -4 }, 0)));
        System.out.println(Arrays.toString(twoSum(new int[] { -1, 0, 1, 2, -1, -4 }, -4)));
        System.out.println(Arrays.toString(twoSum(new int[] { -1, 0, 1, 2, -1, -4 }, -5)));
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            } else {
                map.put(nums[i], i);
            }
        }

        return new int[] {};
    }
}