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
    int preindex;
    TreeNode root;
    Map<Integer,Integer> indexes;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0) return null;
        indexes = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            indexes.put(inorder[i],i);
        }
        preindex = 0;
        return dfs(preorder, 0, inorder.length - 1);
    }
    public TreeNode dfs(int[] preorder, int left, int right){
        if(left > right) return null;
        int rootVal = preorder[preindex++];
        TreeNode root = new TreeNode(rootVal);
        int mid = indexes.get(rootVal);
        root.left = dfs(preorder,left,mid-1);
        root.right = dfs(preorder,mid+1,right);
        return root;
    }
}
