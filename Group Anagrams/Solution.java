import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[] { "eat", "tea", "tan", "ate", "nat", "bat" }).toString());
        System.out.println(groupAnagrams(new String[] {""}).toString());
        System.out.println(groupAnagrams(new String[] {"a"}).toString());
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<Character, Boolean> characters = new HashMap<Character, Boolean>();
        List<List<String>> ans = new ArrayList<List<String>>();
        for (int i = 0; i < strs.length; i++) {
            String temp = strs[i];
            List<String> ans2 = new ArrayList<String>();
            if (temp.length() != 0) {
                ans2.add(temp);
                for (int j = 0; j < temp.length(); j++) {
                    characters.put(temp.charAt(j), true);
                }
                for (int j = i + 1; j < strs.length; j++) {
                    String test = strs[j];
                    Boolean flag = true;
                    if (test.length() != 0) {
                        for (int k = 0; k < test.length(); k++) {
                            if (characters.containsKey(test.charAt(k)) == false) {
                                flag = false;
                                k = test.length();
                            }

                        }
                        if (flag) {
                            ans2.add(test);
                            strs[j] = "";
                        }
                    }

                }
                characters.clear();
                ans.add(ans2);
            }

        }

        return ans;
    }
}