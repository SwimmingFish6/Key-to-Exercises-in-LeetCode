import java.util.HashMap;
import java.util.Map;
// import java.util.Stack;

class Solution {
    public int romanToInt(String s) {
        Map<Character,Integer> map = new HashMap();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);


        int num = 0;
        int temp = 0;

        int preValue = map.get(s.charAt(0));
        // temp = map.get(bit);

        for (int i = 1;i < s.length();i++) {
            if (map.get(s.charAt(i)) > preValue) {
                num -= preValue;
            }
            else {
                num += preValue;
            }
            preValue = map.get(s.charAt(i));
        }

        num += preValue;

        return num;
    }
}