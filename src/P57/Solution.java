import java.util.List;

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
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int[][] records = {{-1, 0}, {-1, 0}};
        
        for (int i = 0;i < intervals.size();i++) {
            Interval tmp = intervals.get(i);
            
            if (newInterval.start > tmp.end) {
                if (i + 1 == intervals.size()) {
                    records[0][0] = i;
                    records[0][1] = i + 1;
                }
                
                continue;
            }
            else if (newInterval.start < tmp.start) {
                records[0][0] = i - 1;
                records[0][1] = i;
                break;
            }
            else {
                records[0][0] = i;
                records[0][1] = i;
                break;
            }
        }
        
        
        for (int i = 0;i < intervals.size();i++) {
            Interval tmp = intervals.get(i);
            
            if (newInterval.end > tmp.end) {
                if (i + 1 == intervals.size()) {
                    records[1][0] = i;
                    records[1][1] = i + 1;
                }
                continue;
            }
            else if (newInterval.end < tmp.start) {
                records[1][0] = i - 1;
                records[1][1] = i;
                break;
            }
            else {
                records[1][0] = i;
                records[1][1] = i;
                break;
            }
        }
        
        if (records[0][0] != records[0][1]) {
            if (records[1][0] != records[1][1]) {
                for (int i = records[1][0];i >= records[0][1];i--) {
                    intervals.remove(i);
                }
                
                intervals.add(records[0][1], newInterval);
            }
            else {
                newInterval.end = intervals.get(records[1][0]).end;
                
                for (int i = records[1][0];i >= records[0][1];i--) {
                    intervals.remove(i);
                }
                
                intervals.add(records[0][1], newInterval);
            }
        }
        else {
            if (records[1][0] != records[1][1]) {
                newInterval.start = intervals.get(records[0][0]).start;
                
                for (int i = records[1][0];i >= records[0][1];i--) {
                    intervals.remove(i);
                }
                
                intervals.add(records[0][1], newInterval);
            }
            else {
                newInterval.start = intervals.get(records[0][0]).start;
                newInterval.end = intervals.get(records[1][0]).end;
                
                for (int i = records[1][0];i >= records[0][1];i--) {
                    intervals.remove(i);
                }
                
                intervals.add(records[0][1], newInterval);
                
            }
        }
        
        return intervals;
    }
}
