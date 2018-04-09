/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() <= 1)
            return intervals;
        
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if(o1.start<o2.start)
                    return -1;
                else if(o1.start>o2.start)
                    return 1;
                else
                    return 0;
            }
        });
        
        // intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));
        
        for (int i = 0;i < intervals.size();i++) {
            if (i < intervals.size() - 1 && intervals.get(i).end >= intervals.get(i + 1).start) {
                if (intervals.get(i + 1).end > intervals.get(i).end) intervals.get(i).end = intervals.get(i + 1).end;
                intervals.remove(i + 1);
                i--;
            }
        }
        
        return intervals;
    }
}
