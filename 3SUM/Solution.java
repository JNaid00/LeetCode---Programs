import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        System.out.println(threeSum(new int[] { -1, 0, 1, 2, -1, -4 }).toString());
        System.out.println(threeSum(new int[] { 0, 1, 1 }).toString());
        System.out.println(threeSum(new int[] { 0, 0, 0 }).toString());
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int low = i + 1, high = nums.length - 1;
            while (low < high) {
                if (nums[low] + nums[high] == nums[i] * -1) {
                    ans.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    low++;
                    while (nums[low] == nums[low - 1] && low < high) {
                        low++;
                    }
                } else if (nums[low] + nums[high] > nums[i] * -1) {
                    high--;
                } else {
                    low++;
                }

            }

        }

        return ans;
    }

}