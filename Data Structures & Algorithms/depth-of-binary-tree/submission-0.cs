/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class Solution {
    public int MaxDepth(TreeNode root) {
        return DFS(root,0);
    }
    public int DFS(TreeNode root, int depth){
        if(root == null) {
            return depth;
        }
        depth = 1 + Math.Max(DFS(root.left,depth),DFS(root.right,depth));
        return depth;
    }
}
