

class Solution {
    public static void main(String[] args) {
        System.out.println(strStr("dddsadbutsad", "sad"));
        System.out.println(strStr("leetcode", "leeto"));
        System.out.println(strStr("leetcodeleeto", "leeto"));
    }
    public static int strStr(String haystack, String needle) {
        int i = 0;
        while (i <= haystack.length() - needle.length()) {
            int j = 0;
            while(j < needle.length() && haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
            }
            if(j == needle.length()){
                return i - needle.length();
            }

            i = i - j  + 1;
        }
        return -1;
    }
}