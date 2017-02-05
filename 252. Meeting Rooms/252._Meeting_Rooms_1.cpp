class Solution {
public:
    bool canAttendMeetings(vector<Interval>& intervals) {
        sort(intervals.begin(), intervals.end(), compare);
        for(int i=1; i<intervals.size(); i++) {
            if(intervals[i].start < intervals[i-1].end)
                return false;
        }
        return true;
    }
    
    static bool compare(Interval& i1, Interval& i2) {
        return i1.start < i2.start;
    }
};