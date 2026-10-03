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
    public int goodNodes(TreeNode root) {
        Stack<TreeNode> nodes = new Stack<>();
        Stack<Integer> maxVal = new Stack<>();
        int count = 0;
        nodes.push(root);
        maxVal.push(Integer.MIN_VALUE);

        while(!nodes.isEmpty()){
            TreeNode node = nodes.pop();
            int max = maxVal.pop();

            if(node.val >= max){
                max = node.val;
                count++;
            }
            if(node.right != null){
                nodes.push(node.right);
                maxVal.push(max);
            }
            if(node.left != null){
                nodes.push(node.left);
                maxVal.push(max);
            }
        }
        return count;
    }
}
