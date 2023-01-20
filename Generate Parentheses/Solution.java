import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {

    public static void main(String[] args) {
        System.out.println(generateParenthesis(1).toString());
        System.out.println(generateParenthesis(2).toString());
        System.out.println(generateParenthesis(3).toString());
        System.out.println(generateParenthesis(4).toString());
    }

    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<String>();
        if (n == 0){
            return ans;
        }
        generate(ans, n, 1, 0, "(");
        return ans;
    }

    private static void generate(List<String> ans, int n, int opening, int closing, String temp) {
        if (n == opening && n == closing) {
            if (ans.contains(temp) == false)
                ans.add(temp);

            return;
        }
        if (opening == closing) {
            generate(ans, n, opening + 1, closing, temp + "(");
        }

        if (opening == n) {
            generate(ans, n, opening, closing + 1, temp + ")");
        }
        if (opening > closing && (opening < n && closing < n)) {
            generate(ans, n, opening + 1, closing, temp + "(");
            generate(ans, n, opening, closing + 1, temp + ")");
        }

    }
}