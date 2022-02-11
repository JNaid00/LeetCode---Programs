import java.util.*;

public class MultipliesInArray {

    public static void main(String[] args){

        int arr[] = arrayOfMultiples(7, 10);
        for (int i = 0;i < 10;i++)
		{
			System.out.println(arr[i]);
		}
    }
	public static int[] arrayOfMultiples(int num, int length) {
		int arr[] = new int[length];
		for (int i = 0;i < length;i++)
		arr[i] = (i + 1) * num;
        return arr;
	}
}