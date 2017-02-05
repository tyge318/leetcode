class Solution {
    public int eraseOverlapIntervals(Interval[] intervals) {
        if( intervals.length == 0 || intervals == null)
            return 0;
        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                return Integer.compare(i1.end, i2.end);
            } 
        });
        int ans = 1, i = 0;
        for(int j=i+1; j<intervals.length; j++) {
            if( intervals[j].start >= intervals[i].end) {
                ans++;
                i = j;
            }
        }
        return intervals.length-ans;
    }
}