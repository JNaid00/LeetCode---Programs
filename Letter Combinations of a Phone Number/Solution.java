import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        System.out.println(letterCombinations("2").toString());
        System.out.println(letterCombinations("9").toString());
        System.out.println(letterCombinations("23").toString());
        System.out.println(letterCombinations("234").toString());
        System.out.println(letterCombinations("2345").toString());
    }

    public static List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.length() == 0)
            return ans;
        String[] data = { "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
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