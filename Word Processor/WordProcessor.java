

public class WordProcessor {
    public static void main(String[] args) {
        System.out.println(wordprocessor(11,16,"college students in the USA are eligible for selection as finalists"));
    }
    public static String wordprocessor(int n, int k, String e) {
		
        String ans = "",part = "";
        int lengthPrevWord = 0;
        for (int i = 0; i < (n - 1);i++){
            part = e.substring(0, e.indexOf(" "));
            e = e.substring(e.indexOf(" ") + 1, e.length());
            
            if (i == 0){
            ans += part;
            lengthPrevWord = part.length();
            }
            else
            if (lengthPrevWord + part.length() > k){
                ans += "\n" + part;
                lengthPrevWord = part.length();
            }
            else{
                lengthPrevWord = lengthPrevWord + part.length() + 1;
                ans += " " + part;
            }

        }
        part = e;

        if (lengthPrevWord + part.length() > k){
            ans += "\r\n" + part;
            lengthPrevWord = part.length();
        }
        else{
            lengthPrevWord = lengthPrevWord + part.length() + 1;
            ans += " " + part;
        }
        return ans;
    }
}
