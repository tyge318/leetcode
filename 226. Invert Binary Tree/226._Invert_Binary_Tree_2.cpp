class Solution {
public:
    TreeNode* invertTree(TreeNode* root) {
        if( root == NULL)   return root;
        TreeNode* temp = invertTree(root->left);
        root->left = invertTree(root->right);
        root->right = temp;
        return root;
    }
};