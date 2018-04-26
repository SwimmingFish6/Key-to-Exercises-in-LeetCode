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
    public int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals.length == 0) return 0;
        
        sortInterval(intervals, 0, intervals.length - 1);
        List<Interval> list = new ArrayList<Interval>();
        int res = 0;
        boolean flag = false;
        int end = intervals[0].end;
        
        for (int i = 1;i < intervals.length;i++) {
            if (intervals[i].start >= end) {
                end = intervals[i].end;
            }

            else {
                res++;
            }
        }
        
        return res;
    }
    
    public void sortInterval(Interval[] intervals, int begin, int end) {
        int left = begin, right = end;
        Interval pivot = intervals[begin];
        
        while (left < right) {
            while (left < right && intervals[right].end >= pivot.end) {
                right--;
            }

            intervals[left] = intervals[right];
            
            while (left < right && intervals[left].end < pivot.end) {
                left++;
            }

            intervals[right] = intervals[left];
            

        }
        
        intervals[left] = pivot;
        
        if (left < end) {
            sortInterval(intervals, left + 1, end);
        }
        
        if (right > begin) {
            sortInterval(intervals, begin, right - 1);
        }
        
    }
}