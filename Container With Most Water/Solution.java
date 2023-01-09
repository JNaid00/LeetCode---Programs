class Solution {

    public static void main(String[] args) {
        System.out.println("{1,8,6,2,5,4,8,3,7} -> Max container: " + maxArea(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 }));
        System.out.println("{1,1} -> Max container: " + maxArea(new int[] { 1,1}));
        System.out.println("{1,8,6,2,5,4,8,3} -> Max container: " + maxArea(new int[] { 1, 8, 6, 2, 5, 4, 8, 3}));
    }

    public static int maxArea(int[] height) {
        int max = 0;

        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int x = j - i;
                int y = height[i] > height[j] ? height[j] : height[i];

                if (max < x * y) {
                    max = x * y;
                }
            }
        }
        return max;
    }
}