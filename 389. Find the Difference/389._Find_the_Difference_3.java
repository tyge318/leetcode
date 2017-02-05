class Solution {
    public char findTheDifference(String s, String t) {
        int ans = 0;
        for(int i=0; i < s.length(); i++) {
            ans ^= s.charAt(i);
            ans ^= t.charAt(i);
        }
        ans ^= t.charAt(t.length()-1);
        return (char)ans;
    }
}