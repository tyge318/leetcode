class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        int temp = 0, ans = 0;
        while( !nestedList.isEmpty()) {
            List<NestedInteger> next = new ArrayList<>();
            for(NestedInteger ni: nestedList) {
                if( ni.isInteger())
                    temp += ni.getInteger();
                else
                    next.addAll(ni.getList());
            }
            ans += temp;
            nestedList = next;
        }
        return ans;
    }
}