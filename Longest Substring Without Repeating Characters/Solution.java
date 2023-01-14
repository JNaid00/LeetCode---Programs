import java.util.HashMap;
import java.util.Map;

class Solution {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubsing("abcbbcbb"));
        System.out.println(lengthOfLongestSubsing("bbbbb"));
        System.out.println(lengthOfLongestSubsing("pwwkew"));
        System.out.println(lengthOfLongestSubsing("zabcabczbb"));
    }
    //bva
    public static int lengthOfLongestSubsing(String s) {
        Map<Character, Integer> chars = new HashMap<>();
        int left = 0;
        int right = 0;
        int res = 0;

        while (right < s.length()) {
            char r = s.charAt(right);
            chars.put(r, chars.getOrDefault(r,0) + 1);



            while (chars.get(r) > 1) {
                char l = s.charAt(left);
                chars.put(l, chars.get(l) -1);
                left++;
            }

            res = Math.max(res, right - left +1);
            right++;
        }
       return res;
    }

}