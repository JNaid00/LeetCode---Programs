class Solution {

    public static void main(String[] args) {
        System.out.println("5 -> " + reverse(5));
        System.out.println("-9 -> " + reverse(-9));
        System.out.println("11 -> " + reverse(11));
        System.out.println("-12000000 -> " + reverse(-12000000));
        System.out.println("123 -> " + reverse(123));
        System.out.println("-123 -> " + reverse(-123));
        System.out.println("120 -> " + reverse(120));
        System.out.println("0 -> " + reverse(0));
        System.out.println("-120 -> " + reverse(-120));
    }

    public static int reverse(int x) {

        boolean isNegative = false;
        if (x == 0) {
            return x;
        }
        if (x < 0) {
            isNegative = true;
            x *= -1;
        }

        int temp = x, ans = 0;
        while (temp >= 1) {
            ans *= 10;
            int unit = temp % 10;
            temp -= unit;
            temp /= 10;
            ans += unit;
        }
        return isNegative ? ans * -1 : ans;

    }
}