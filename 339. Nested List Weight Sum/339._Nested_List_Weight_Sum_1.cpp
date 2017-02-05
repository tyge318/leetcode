class Solution {
public:
    int depthSum(vector<NestedInteger>& nestedList) {
        return helper(1, nestedList);
    }
    int helper(int depth, vector<NestedInteger>& nestedList) {
        int ans = 0;
        for(auto iter=nestedList.begin(), end = nestedList.end(); iter!=end; ++iter) {
            if( iter->isInteger())    ans += (depth*iter->getInteger());   
            else    ans += helper(depth+1, iter->getList());
        }
        return ans;
    }
};