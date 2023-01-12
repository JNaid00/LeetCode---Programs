import java.util.Arrays;

class Solution {
    
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[] {2,7,11,15}, 9)));
        System.out.println(Arrays.toString(twoSum(new int[] {2,3,4}, 6)));
        System.out.println(Arrays.toString(twoSum(new int[] {-1, 0}, -1)));
        System.out.println(Arrays.toString(twoSum(new int[] {-50,-5,2,7,11,15}, 9)));

    }
    public static int[] twoSum(int[] numbers, int target) {
        int index1 = 0, index2 = numbers.length - 1;

        while(index1 < index2){
            if(numbers[index1] + numbers[index2] == target){
                return new int[]{index1 + 1,index2 + 1};
            }else if (numbers[index1] + numbers[index2] > target){
                index2--;
            }else{
                index1++;
            }
        }




        return new int[0];
    }
}