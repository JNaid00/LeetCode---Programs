import java.util.*;

public class GettheLuckyNumber {
    public static void main(String[] args) {
        System.out.println(getLuckyNumber(25, 5));
    }
    public static int getLuckyNumber(int size, int nth) {
		
        int sieveNum = 2; 
        LinkedList<Integer> arr = new LinkedList<Integer>();
        for (int i = 0; i < size; i++) arr.add(i + 1);
        for (int i = 2; i <= nth; i++) {
            for (int j = sieveNum - 1; j < arr.size(); j = j + sieveNum - 1) arr.remove(j);
            if (arr.contains(sieveNum)) sieveNum = arr.get(arr.indexOf(sieveNum) + 1);
            else{
                int count = 1;
                while (arr.contains(sieveNum + count) == false) count++;
                sieveNum += count;
            }
        }
        return arr.get(nth - 1) ;
    }
}
