class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        if( root == null )
            return ans;
        ans.add(root.val);
        ans.addAll(preorderTraversal(root.left) );
        ans.addAll(preorderTraversal(root.right) );
        return ans;
    }
}