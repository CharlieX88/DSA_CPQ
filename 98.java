class Solution {
    public boolean isValidBST(TreeNode root) {
        // Initialize the root with the absolute maximum possible bounds
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean validate(TreeNode node, long min, long max) {
        // An empty tree/node is valid
        if (node == null) {
            return true;
        }

        // The current node's value must strictly fit within the min and max limits
        if (node.val <= min || node.val >= max) {
            return false;
        }

        // Left child: upper bound updates to node.val (must be smaller)
        // Right child: lower bound updates to node.val (must be larger)
        return validate(node.left, min, node.val) && 
               validate(node.right, node.val, max);
    }
}
