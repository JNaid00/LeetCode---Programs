import java.util.Arrays;

public class Solution {

	public static void main(String[] args) {
		int nums1[] = { 1, 3, 7, 10, 20 }, nums2[] = { 2, 5, 6 };
		//1, 2, 3, 5, 6, 7, 10, 20
		System.out.println(findMedianSortedArrays(nums1, nums2));
		System.out.println(findMedianSortedArrays(new int[] { 1 }, (new int[] { 2 })));

		System.out.println(findMedianSortedArrays(new int[] { 1, 5 }, (new int[] { 2 })));
	}	
	// Complexity O(n+m)
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int combined = nums1.length + nums2.length;
		int count1 = 0, count2 = 0;
		double ans = 0, ans2 = 0;
		if (combined % 2 == 1){
			for (int i = 0; i <= combined / 2; i++) {
				if (count1 < nums1.length && count2 < nums2.length) { 
					ans = nums1[count1] < nums2[count2] ? nums1[count1++] : nums2[count2++];
				}else if (count1 < nums1.length){
					ans = nums1[count1++];
				}else{
					ans= nums2[count2++];
				}
			}

			return ans;
		}

		for (int i = 0; i <= combined / 2; i++) {
			ans2 = ans;
			if (count1 < nums1.length && count2 < nums2.length) { 
				ans = nums1[count1] < nums2[count2] ? nums1[count1++] : nums2[count2++];

			}else if (count1 < nums1.length){
				ans = nums1[count1++];
			}else{
				ans= nums2[count2++];
			}
		}

		return (ans + ans2 )/2;
	}
}
