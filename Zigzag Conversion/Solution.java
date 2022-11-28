class Solution {
	public static void main(String[] args) {
		System.out.println(convert("PAYPALISHIRING",3));
		System.out.println();
		System.out.println(convert("PAYPALISHIRING",4));
		System.out.println();

	}
    public static String convert(String s, int numRows) {
		if (numRows == 1){
			return s;
		}
        String done = "";
		int distance = 2 * (numRows - 1);
		for (int i = 0; i < numRows; i++) {
			for (int j = i; j < s.length(); j+=distance) {
				
				done += s.charAt(j);

				if (i > 0 && i < numRows - 1){
					if (j+distance - 2 * i < s.length())
					done += s.charAt(j+distance - 2 * i);
				}
			}
		}
		return done;
    }
}