/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
class Solution {
    public int maxPoints(Point[] points) {
        if (points == null || points.length == 0) return 0;
        
        Map<Integer, Map<Integer, Integer>> map;
        int maxR = 1;
        
        for (int i = 0;i < points.length;i++) {
            map = new HashMap<Integer, Map<Integer,Integer>>();
            int overlap = 1;
            int max = 0;
            for (int j = i + 1;j < points.length;j++) {
                int x = points[j].x - points[i].x;
                int y = points[j].y - points[i].y;
                
                if (x == 0 && y == 0) {
                    overlap++;
                    continue;
                }
                
                int gcd = generateGCD(x, y);
                if (gcd != 0) {
                    x /= gcd;
                    y /= gcd;
                }
                
                if (!map.containsKey(x)) {
                    Map<Integer, Integer> subMap = new HashMap<Integer, Integer>();
                    subMap.put(y, 1);
                    map.put(x, subMap);
                }
                else {
                    Map<Integer, Integer> subMap = map.get(x);
                    
                    if (!subMap.containsKey(y)) {
                        subMap.put(y, 1);
                    }
                    else {
                        subMap.put(y, subMap.get(y) + 1);
                    }
                }
                max = Math.max(max, map.get(x).get(y));
            }
            maxR = Math.max(maxR, max + overlap);
            
            
        }
        
        return maxR;
        
    }
    
    public int generateGCD(int x, int y) {
        if (y == 0) return x;
        while (true) {
            if (x % y == 0) break;
            x = x % y;
            x = x + y;
            y = x - y;
            x = x - y;
        }
        
        return y;
    }
}
