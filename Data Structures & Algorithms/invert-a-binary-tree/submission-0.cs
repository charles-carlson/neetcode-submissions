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
/*
    left = this.left
    this.left = this.right
    this.right = left
*/
public class Solution {
    public TreeNode InvertTree(TreeNode root) {
        return DFS(root);
    }
    public TreeNode DFS(TreeNode root) {
        if(root == null){
            return root;
        }
        var left = root.left;
        var right = root.right;
        root.left = right;
        root.right = left;
        DFS(root.left);
        DFS(root.right);
        return root;
        //SWAP at node
        //THEN MOVE LEFT AND RIGHT

    }
}
