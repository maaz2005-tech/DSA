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
    class Info{
        int max,ans;
        public Info(int max,int ans){
            this.max=max;
            this.ans=ans;
        }
    }
    Info solve(TreeNode root){
        if(root==null) return new Info(0,0);
        Info left=solve(root.left);
        Info right=solve(root.right);
        if(root.val>=left.max && root.val>=right.max){
            return new Info(root.val,1+left.ans+right.ans);
        }
        return new Info(Math.max(left.max,right.max),left.ans+right.ans);
    }
    public int countDominantNodes(TreeNode root) {
        return solve(root).ans;
    }
}