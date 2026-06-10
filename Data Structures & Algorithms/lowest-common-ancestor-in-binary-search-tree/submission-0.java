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
//we know if p > q that q will be in the right subtree of p, if p < q, it is the left subtree
// if p < root < q then there is a split
//if p < q < root or q < p < root some where in left subtree to root
//if root < p < q or root < q < p somewhere in right subtree to root
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if(root != null && p.val < root.val && q.val < root.val){
                return lowestCommonAncestor(root.left,p,q);
            }
            else if(root != null && q.val > root.val && p.val > root.val){
                return lowestCommonAncestor(root.right,p,q);
            } else {
                return root;
            }
    }
}
