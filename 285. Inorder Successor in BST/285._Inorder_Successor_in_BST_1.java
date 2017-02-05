class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode ans = null;
        while( root != null ) {
            if( p.val < root.val ) {
                ans = root;
                root = root.left;
            }
            else
                root = root.right;
        }
        return ans;
    }
}