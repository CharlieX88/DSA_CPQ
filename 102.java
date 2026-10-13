
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> result = new ArrayList<>();
      
        if (root == null) {
            return result;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
      


        
        while (!queue.isEmpty()) {
            // List to store current level's node values
            List<Integer> currentLevel = new ArrayList<>();
          
            // Get the number of nodes at current level
            int levelSize = queue.size();
          
            // Process all nodes at current level
            for (int i = 0; i < levelSize; i++) {
                // Remove and process the front node
                TreeNode currentNode = queue.poll();
                currentLevel.add(currentNode.val);
            
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
          
            result.add(currentLevel);
        }
      
        return result;
    }
}