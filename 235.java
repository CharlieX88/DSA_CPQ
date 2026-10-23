class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode current = root;
        
        while (current != null) {
            // If both nodes are smaller, move to the left subtree
            if (p.val < current.val && q.val < current.val) {
                current = current.left;
            } 
            // If both nodes are larger, move to the right subtree
            else if (p.val > current.val && q.val > current.val) {
                current = current.right;
            } 
            // We found the split point (or found p or q), which is the LCA
            else {
                return current;
            }
        }
        return null;
    }
}
