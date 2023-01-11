class Solution {
    public static void main(String[] args) {
        System.out.println(isMatchRecursive("aa", "a"));
        System.out.println(isMatchRecursive("aa", "a*"));
        System.out.println(isMatchRecursive("aa", "c*a*"));
        System.out.println(isMatchRecursive("ab", ".*"));
        System.out.println(isMatchRecursive("aaaaaaaaaaaa", "a*"));
        System.out.println(isMatchRecursive("aaaaaaaaaaaasss", "a*"));
        System.out.println(isMatchRecursive("abc", "a*"));
        System.out.println(isMatchRecursive("abc", "abc"));
        System.out.println(isMatchRecursive("abcz", "abc."));
        System.out.println(isMatchRecursive("abczr", "abc."));
        System.out.println(isMatchRecursive("abczrrrrrrr", "abc.r*"));
        System.out.println(isMatchRecursive("abczrrrf", "abc.r*f"));
        System.out.println(isMatchRecursive("abc", "z*.*"));
        System.out.println(isMatchRecursive("aab", "c*a*b"));
        System.out.println(isMatchRecursive("mississippi", "mis*is*p*."));
        System.out.println(isMatchRecursive("mississippi", "mis*is*ip*."));
    }

    public static boolean isMatch(String s, String p) {
        if (s.length() == 0 && p.length() == 0) {
            return true;
        }
        if (p.length() == 0) {
            return false;
        }
        int count = 0;
        Character pred = ' ';
        Boolean isDot = false;
        for (int i = 0; i < s.length(); i++) {
            if (count == p.length()) {
                return false;
            }
            switch (p.charAt(count)) {
                case '.': {
                    count++;
                    isDot = true;
                    break;
                }
                case '*': {
                    if (isDot == true) {
                        return true;
                    }
                    while (i < s.length() && s.charAt(i) == pred) {
                        i++;
                    }
                    --i;
                    count++;
                    isDot = false;
                    break;
                }

                default: {

                    if (s.charAt(i) != p.charAt(count)) {
                        if (count + 1 < p.length() && p.charAt(count + 1) == '*') {
                            count++;
                        } else
                            return false;
                    }

                    count++;
                    isDot = false;
                    break;
                }

            }
            pred = s.charAt(i);
        }
        return true;
    }

    public static boolean isMatchRecursive(String s, String p) {

        if (p.isEmpty()) {
            return s.isEmpty();
        }

        Boolean first_match = (s.isEmpty() == false && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.'));

        if(p.length() >= 2 && p.charAt(1) == '*'){
                return (isMatchRecursive(s, p.substring(2))) || (first_match && isMatchRecursive(s.substring(1), p));
        }else{
            return first_match && isMatchRecursive(s.substring(1), p.substring(1));
        }
       
    }
}