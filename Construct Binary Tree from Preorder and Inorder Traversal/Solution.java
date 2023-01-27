import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        print(buildTree(new int[] {3,9,20,15,7}, new int[] {9,3,15,20,7}));
        System.out.println();
        print(buildTree(new int[] {1, 2 , 4, 5 , 8, 3, 6, 7, 9, 10}, new int[] {4,2,8,5,1,6,3,9,7,10}));
        System.out.println();
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length == 0){
            return null;
        }

        TreeNode root = new TreeNode(preorder[0]);
        int index = -1;
        for (int i = 0; i < inorder.length; i++) {
            if(preorder[0] == inorder[i]){
                index = i;
                i = inorder.length;
            }
        }

        root.left = buildTree(Arrays.copyOfRange(preorder, 1, index + 1), Arrays.copyOfRange(inorder, 0, index));
        root.right = buildTree(Arrays.copyOfRange(preorder, index + 1, preorder.length), Arrays.copyOfRange(inorder, index+ 1, inorder.length));

        
        return root;
    }
    public static void print(TreeNode node){
        if (node != null){
            System.out.print(node.val + " ");
            print(node.left);
            
            print(node.right);
        }
    }
}
