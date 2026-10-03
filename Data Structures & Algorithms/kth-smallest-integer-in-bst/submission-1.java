/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> nodes = new Stack<>();
        if (root == null)
            return -1;

        while (root != null || !nodes.isEmpty()) {
            while (root != null) {
                nodes.push(root);
                root = root.left;
            }
            root = nodes.peek();
            nodes.pop();
            if (--k == 0)
                return root.val;
            root = root.right;
        }
        return -1;
    }
}
