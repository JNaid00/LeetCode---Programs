# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution(object):
    def inorderTraversal(self, root : TreeNode):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        ans = []
        def inorder(node : TreeNode):
            if not node:
                return
            inorder(node.left)
            ans.append(node.val)
            inorder(node.right)
        inorder(root)
        return ans

node3 = TreeNode(3)
node2 = TreeNode(2, node3, None)
root = TreeNode(1, None, node2)
sol = Solution()
print(sol.inorderTraversal(root))
print(sol.inorderTraversal(None))