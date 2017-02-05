class Solution {
    public NestedInteger deserialize(String s) {
        Stack<NestedInteger> st = new Stack<NestedInteger>();
        
        NestedInteger current = null;
        StringBuilder temp = new StringBuilder();
        for(int i=0; i<s.length(); i++) {
            char cc = s.charAt(i);
            if( cc == '[' ) {
                if( current != null)
                    st.push(current);
                current = new NestedInteger();
            } 
            if( (cc >= '0' && cc <= '9') || cc == '-' ) {
                temp.append(cc);
                continue;
            }
            if( cc == ',') {
                if( temp.length() != 0) {
                    NestedInteger inner = new NestedInteger(Integer.parseInt(temp.toString()));
                    current.add(inner);
                    temp.delete(0, temp.length());
                }
                continue;
            }
            if( cc == ']') {
                if( temp.length() != 0) {
                    NestedInteger inner = new NestedInteger(Integer.parseInt(temp.toString()));
                    current.add(inner);
                    temp.delete(0, temp.length());
                }
                NestedInteger hold = current;
                if( st.empty() )    return current;
                current = st.pop();
                //System.out.println("(before add) current = " + printList(current.getList()) );
                current.add(hold);
                //System.out.println("(after add) current = " + printList(current.getList()) );
            }
        }
        if( temp.length() != 0)
            return (new NestedInteger(Integer.parseInt(temp.toString())) );
        return (new NestedInteger());
    }
    public String printList(List<NestedInteger> list) {
        StringBuilder ans = new StringBuilder();
        ans.append('[');
        for(NestedInteger ni: list) {
            if( ans.length() != 1)  
                ans.append(',');
            if( ni.getInteger() == null ) {
                ans.append(printList(ni.getList()));
            }
            else
                ans.append(ni.getInteger());
        }
        ans.append(']');
        return ans.toString();
    }
}