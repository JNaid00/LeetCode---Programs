import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        System.out.println(letterCombinationsRecursive("2").toString());
        System.out.println(letterCombinationsRecursive("9").toString());
        System.out.println(letterCombinationsRecursive("23").toString());
        System.out.println(letterCombinationsRecursive("234").toString());
        System.out.println(letterCombinationsRecursive("2345").toString());
    }

    static String[] data = { "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public static List<String> letterCombinationsRecursive(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.length() == 0) {
            return ans;
        }
        recursive(0, digits.length(), new StringBuilder(), ans, digits);

        return ans;
    }

    private static void recursive(int pos, int length, StringBuilder sb, List<String> ans, String digits) {
        if (pos == length)
            ans.add(sb.toString());
        else {
            String characters = data[Character.getNumericValue(digits.charAt(pos)) - 1];
            for (int i = 0; i < characters.length(); i++) {
                recursive(pos + 1, length, new StringBuilder(sb).append(characters.substring(i, i + 1)), ans, digits);
            }
        }

    }

    public static List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.length() == 0)
            return ans;

        int firstIndex = (int) digits.charAt(0) - 49;
        for (int i = 0; i < data[firstIndex].length(); i++) {
            String temp = data[firstIndex].substring(i, i + 1);
            if (digits.length() >= 2) {
                int secondIndex = (int) digits.charAt(1) - 49;
                String reserve = temp;
                for (int j = 0; j < data[secondIndex].length(); j++) {
                    temp += data[secondIndex].substring(j, j + 1);
                    if (digits.length() >= 3) {
                        int thirdIndex = (int) digits.charAt(2) - 49;
                        String reserve2 = temp;
                        for (int j2 = 0; j2 < data[thirdIndex].length(); j2++) {
                            temp += data[thirdIndex].substring(j2, j2 + 1);
                            if (digits.length() >= 4) {
                                int forthIndex = (int) digits.charAt(3) - 49;
                                String reserve3 = temp;
                                for (int k = 0; k < data[forthIndex].length(); k++) {
                                    temp += data[forthIndex].substring(k, k + 1);
                                    ans.add(temp);
                                    temp = reserve3;
                                }
                            } else {
                                ans.add(temp);
                            }

                            temp = reserve2;
                        }
                    } else {
                        ans.add(temp);
                    }

                    temp = reserve;
                }
            } else {
                ans.add(temp);
            }
        }
        return ans;
    }
}