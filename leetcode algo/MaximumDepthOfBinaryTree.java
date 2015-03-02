/*
 * Given a binary tree, find its maximum depth.

 * The maximum depth is the number of nodes along the longest path from the 
 * root node down to the farthest leaf node.
 */
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class MaximumDepthOfBinaryTree {

/**************************** Recursive Solution ****************************/

    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

/**************************** Iterative Solution *****************************/

    public int maxDepth(TreeNode root) {
        if(root == null) 
            return 0;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        int depth = 0;
        TreeNode prev = null;
        while(!stack.isEmpty()) {
            TreeNode cur = stack.peek();
            if(prev == null || prev.left == cur || prev.right == cur) {
                if(cur.left != null)
                    stack.push(cur.left);
                else if(cur.right != null)
                    stack.push(cur.right);
            }
            else if(cur.left == prev) {
                if(cur.right != null)
                    stack.push(cur.right);
            }
            else
                stack.pop();
            prev = cur;
            if(stack.size() > depth)
                depth = stack.size();
        }
        return depth;
    }
}   
