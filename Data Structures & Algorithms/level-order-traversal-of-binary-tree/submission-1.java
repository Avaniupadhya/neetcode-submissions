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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> Q = new LinkedList<>();
        List<List<Integer>> nodeList = new ArrayList<>();
        if (root == null)
            return nodeList;
        Q.add(root);

        while (!Q.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = Q.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = Q.poll();

                list.add(node.val);

                if (node.left != null) {
                    Q.add(node.left);
                }
                if (node.right != null) {
                    Q.add(node.right);
                }
            }
            nodeList.add(list);
        }
        return nodeList;
    }
}
