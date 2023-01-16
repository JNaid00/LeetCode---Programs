import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[] { "eat", "tea", "tan", "ate", "nat", "bat" }).toString());
        System.out.println(groupAnagrams(new String[] {""}).toString());
        System.out.println(groupAnagrams(new String[] {"a"}).toString());
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        List<List<String>> ans = new ArrayList<List<String>>();
        for (int i = 0; i < strs.length; i++) {
            char[] arr = strs[0].toCharArray();
            Arrays.sort(arr);
            String sortedString = new String(arr);
            if (map.containsKey(sortedString)){
                map.get(sortedString).add(strs[0]);
            }else{
                List<String> temp = new ArrayList<String>();
                temp.add(strs[i]);
                map.put(sortedString, temp);
            }
        }
        ans.addAll(map.values());
        return ans;
    }
}