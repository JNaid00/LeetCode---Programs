public class PronicNumber {
    public static void main(String[] args) {
        System.out.println(isHeteromecic(7));
    }
	public static boolean isHeteromecic(int n) {
        for (int i = 0; i <= n; i++)
        {
            if ((i + 1) * i == n)
            return true;
        }

        return false;
	}
    public static boolean RecursiveIsHeteromecic(int n) {
        
        if ((n - 1) * n == n)
        return true;

        return RecursiveIsHeteromecic(n - 1);
    }
}