class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        if( root == null)
            return ans;
        if( root.left != null )
            ans.addAll(inorderTraversal(root.left) );
        ans.add(root.val);
        if( root.right != null)
            ans.addAll(inorderTraversal(root.right) );
        return ans;
    }
}