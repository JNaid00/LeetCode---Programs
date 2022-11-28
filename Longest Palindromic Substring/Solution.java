class Solution {
	public static void main(String[] args) {
		System.out.println(longestPalindrome("babad"));
		System.out.println(longestPalindrome("cbbd"));
		System.out.println(longestPalindrome("babadabab"));
		System.out.println(longestPalindrome("babaddda"));
		System.out.println(longestPalindrome("babadda"));
		System.out.println(longestPalindrome("a"));
		System.out.println(longestPalindrome("bzazbazddza"));
		System.out.println(longestPalindrome("zzzzzzzzzzzzzzzzzzzzzzz"));
	}

	public static String longestPalindrome(String s) {

		int from = 0, to = 0;
		int longFrom = from, longTo = to;
		boolean test = false;
		for (int i = 0; i < s.length(); i++) {
			int oldI = i;
			for (int j = s.length() - 1; j >= 0; j--) {
				if (i < j) {
					if (s.charAt(i) == s.charAt(j)) {
						if (test == false) {
							test = true;
							from = i;
							to = j;
						}
						i++;
					} else {
						test = false;
					}
				} else if (i == j) {
					if (s.charAt(i) == s.charAt(j)) {
						if (test && longTo - longFrom < to - from) {
							longTo = to;
							longFrom = from;
						}
					} else {
						test = false;
					}
				} else {
					if (test && longTo - longFrom < to - from) {
						longTo = to;
						longFrom = from;
					}
				}

			}

			i = oldI;
			test = false;
			from = 0;
			to = 0;
		}
		return s.substring(longFrom, longTo + 1);
	}
}