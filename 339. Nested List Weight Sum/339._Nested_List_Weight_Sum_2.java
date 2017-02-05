class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        return weightDepthSum(1, nestedList);
    }
    public int weightDepthSum(int w, List<NestedInteger> nestedList) {
        int ans = 0;
        for(NestedInteger i: nestedList) {
            if( i.isInteger())
                ans += w*i.getInteger();
            else
                ans += weightDepthSum(w+1, i.getList());
        }
        return ans;
    }
}