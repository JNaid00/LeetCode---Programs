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
		double m1, m2;
		if (nums1.length == 0 && nums2.length == 0) {
			return 0;
		}
		if (nums1.length == 1 && nums2.length == 1) {
			return (double) (nums1[0] + nums2[0]) / 2;
		}

		m1 = getMedian(nums1);
		m2 = getMedian(nums2);

		if (m1 == m2){
			return m1;
		}else if (m1 > m2){
			//Median lies in this range [m2, m1]

		}else{
			//Median lies in this range [m1, m2]
		}
		return 0;
	}

	private static double getMedian(int[] arr) {

		return arr.length % 2 == 0 ? (double) (arr[arr.length / 2] + arr[arr.length / 2 - 1])
				: arr[(arr.length - 1) / 2];
	}
}
