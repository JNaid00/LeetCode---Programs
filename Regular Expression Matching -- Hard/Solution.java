class Solution {
    public static void main(String[] args) {
        System.out.println(isMatch("aa", "a"));
        System.out.println(isMatch("aa", "a*"));
        System.out.println(isMatch("aa", "c*a*"));
        System.out.println(isMatch("ab", ".*"));
        System.out.println(isMatch("aaaaaaaaaaaa", "a*"));
        System.out.println(isMatch("aaaaaaaaaaaasss", "a*"));
        System.out.println(isMatch("abc", "a*"));
        System.out.println(isMatch("abc", "abc"));
        System.out.println(isMatch("abcz", "abc."));
        System.out.println(isMatch("abczr", "abc."));
        System.out.println(isMatch("abczrrrrrrr", "abc.r*"));
        System.out.println(isMatch("abczrrrf", "abc.r*f"));
        System.out.println(isMatch("abc", "z*.*"));
    }

    public static boolean isMatch(String s, String p) {
        if (s.length() <= 0 || p.length() <= 0) {
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
                    if (s.charAt(i) != pred) {
                        return false;
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
                        if(count + 1 < p.length() && p.charAt(count + 1) == '*')
                        {
                            count++;
                        }else
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
}