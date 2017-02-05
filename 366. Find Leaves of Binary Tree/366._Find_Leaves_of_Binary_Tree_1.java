class Solution {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(root, ans);
        return ans;
    }
    public int dfs(TreeNode node, List<List<Integer>> ans) {
        if(node == null)
            return -1;
        int height = 1+Math.max(dfs(node.left, ans), dfs(node.right, ans) );
        if( ans.size() <= height)
            ans.add(new ArrayList<>());
        ans.get(height).add(node.val);
        return height;
    }
}