class Solution {
    public boolean isBalanced(TreeNode root) {
        return (height(root) != -1);
    }
    public int height(TreeNode current) {
        if( current == null)
            return 0;
        int left = height(current.left);
        int right = height(current.right);
        
        if(left == -1 || right == -1 || Math.abs(right-left) > 1)
            return -1;
        
        return Math.max(left, right)+1;
    }
}