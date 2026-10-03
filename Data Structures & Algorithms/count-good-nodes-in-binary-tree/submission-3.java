class Solution {
    public int goodNodes(TreeNode root) {
        int count = 0;
        Stack<TreeNode> nodes = new Stack<>();
        Stack<Integer> maxStack = new Stack<>();
        
        nodes.push(root);
        maxStack.push(Integer.MIN_VALUE);

        while (!nodes.isEmpty()) {
            TreeNode node = nodes.pop();
            int max = maxStack.pop();
            
            if (node.val >= max) {
                count++;
                max = node.val;
            }
            
            if (node.right != null) {
                nodes.push(node.right);
                maxStack.push(max);
            }
            if (node.left != null) {
                nodes.push(node.left);
                maxStack.push(max);
            }
        }
        
        return count;
    }
}