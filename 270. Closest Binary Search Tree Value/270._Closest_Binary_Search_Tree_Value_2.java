class Solution {
    public int closestValue(TreeNode root, double target) {
        if( root.val == target)
            return root.val;
        else if( target > root.val) {
            Integer right = null;
            if( root.right != null)
                right = closestValue(root.right, target);
            return right == null ? root.val: (Math.abs(root.val-target) < Math.abs(right-target) ? root.val: right);
        }
        else {
            Integer left = null;
            if( root.left != null)
                left = closestValue(root.left, target);
            return left == null ? root.val: (Math.abs(root.val-target) < Math.abs(left-target) ? root.val: left);
        }
    }
}