class Solution {

    public static void main(String[] args) {
        System.out.println("3 -> " + intToRoman(3));
        System.out.println("58 -> " + intToRoman(58));
        System.out.println("1994 -> " + intToRoman(1994));
        System.out.println("3999 -> " + intToRoman(3999));
        System.out.println("1000 -> " + intToRoman(1000));
        System.out.println("500 -> " + intToRoman(500));
        System.out.println("584 -> " + intToRoman(584));
    }

    public static String intToRoman(int num) {
        String ansString = "";

        int length = String.valueOf(num).length();
        if (length == 1) {
            switch (num) {
                case 1:
                    return "I";
                case 2:
                    return "II";
                case 3:
                    return "III";
                case 4:
                    return "IV";
                case 5:
                    return "V";
                case 6:
                    return "VI";
                case 7:
                    return "VII";
                case 8:
                    return "VIII";
                case 9:
                    return "IX";

                default:
                    break;
            }
        } else {
            int rightSide = (int) Math.pow(10, length - 1);
            int ans = num - (num % rightSide);
            int temp = String.valueOf(ans).length();
            String a, b, c;
            int test = 1;
            if (temp == 2) {
                a = "X";
                b = "L";
                c = "C";
                test = ans / 10;
            } else if (temp == 3) {
                a = "C";
                b = "D";
                c = "M";
                test = ans / 100;
            } else {
                a = "M";
                b = "M";
                c = "M";
                test = ans / 1000;
            }

            switch (test) {
                case 1:
                    ansString = a;
                    break;

                case 2:
                    ansString = a + a;
                    break;
                case 3:
                    ansString = a + a + a;
                    break;
                case 4:
                    ansString = a + b;
                    break;
                case 5:
                    ansString = b;
                    break;
                case 6:
                    ansString = b + a;
                    break;
                case 7:
                    ansString = b + a + a;
                    break;
                case 8:
                    ansString = b + a + a + a;
                    break;
                case 9:
                    ansString = a + c;
                    break;

                default:
                    break;
            }

            return ansString + intToRoman(num - ans);

        }
        return ansString;
    }
}