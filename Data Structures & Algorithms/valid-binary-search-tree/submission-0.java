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
    public boolean isValidBST(TreeNode root) {
        if(root == null) return false;
        TreeNode prev = null;
        Stack<TreeNode> stackNodes = new Stack<>();
        while(root!=null || !stackNodes.isEmpty()){
            while(root!=null){
                stackNodes.push(root);
                root = root.left;
            }
            stackNodes.peek();
            root = stackNodes.pop();
            if(prev != null && prev.val >= root.val)
             return false;
            prev = root;
            root = root.right;
        }
        return true;        
    }

   
}
