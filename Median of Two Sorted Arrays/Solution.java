import java.util.Arrays;

public class Solution {

	public static void main(String[] args) {
		int nums1[] = {1,3,7,10,20}, nums2 []= {2,5,6};
		System.out.println(findMedianSortedArrays(nums1, nums2));
		
		System.out.println(findMedianSortedArrays(new int[] {1}, (new int[] {2})));

		System.out.println(findMedianSortedArrays(new int[] {1, 5}, (new int[] {2})));
	}	
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int combined[] = new int[nums1.length + nums2.length];
		int count1 = 0, count2 = 0;
		for (int i = 0; i < combined.length; i++) {
			if (count1 < nums1.length && count2 < nums2.length) { 
				combined[i] = nums1[count1] < nums2[count2] ? nums1[count1++] : nums2[count2++];
			}else if (count1 < nums1.length){
				combined[i] = nums1[count1++];
			}else{
				combined[i] = nums2[count2++];
			}
		}
		System.out.println(Arrays.toString(combined));
		// System.out.println((combined[combined.length / 2]  + combined[combined.length / 2 - 1]));
		double ans;
		if (combined.length % 2 == 0){
			ans = (combined[combined.length / 2]  + combined[combined.length / 2 - 1]);
			ans /= 2;
		}else{
			ans = combined[(combined.length - 1) / 2];
		}
		return ans;
    }
}
