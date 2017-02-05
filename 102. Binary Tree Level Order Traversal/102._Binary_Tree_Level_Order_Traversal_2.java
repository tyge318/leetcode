class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if( root == null )
            return ans;
        addToLevel(root, ans, 0);
        return ans;
    }
    public void addToLevel(TreeNode root, List<List<Integer>> ans, int level) {
        if( ans.size() == level) {
            List<Integer> current = new ArrayList<Integer>();
            current.add(root.val);
            ans.add(current);
        }
        else {
            List<Integer> current = ans.get(level);
            current.add(root.val);
        }
        if( root.left != null )
            addToLevel(root.left, ans, level+1);
        if( root.right != null)
            addToLevel(root.right, ans, level+1);
    }
}