import java.util.*;

public class PostfixNotation {
    public static void main(String[] args) {
        System.out.println(postfix("5"));
        // String expr = "5 6 * 2 1 + /";
        // String[] split = expr.split(" ");
        // for (int i = 0; i < split.length;i++)
        // System.out.println(split[i]);
    }
    public static int postfix(String expr) {
		Stack<Integer> x = new Stack<>();  

        for (int i = 0; i < expr.length();i++){
            int count = 0;
            if (Character.isDigit(expr.charAt(i))){
                while (i+ count < expr.length() && Character.isDigit(expr.charAt(i + count)))
                count++;
                x.push(Integer.parseInt(expr.substring(i, i + count)));
                i += count - 1;
            }
            else{
                switch(expr.charAt(i)){
                case '+' :{
                    int ans = x.pop();
                    ans += x.pop();
                    x.push(ans);
                    break;
                }
                case '-' :{
                    int ans = x.pop();
                    ans = x.pop() - ans;
                    x.push(ans);
                    break;
                }
                case '/' :{
                    int ans = x.pop();
                    ans = x.pop() / ans;
                    x.push(ans);
                    break;
                }
                case '*' :{
                    int ans = x.pop();
                    ans *= x.pop();
                    x.push(ans);
                    break;
                }
            }
            }
        }
        return x.pop();
    }
}
