import java.util.*;

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<String>();
        if (digits.equals("")) return list;
        list.add("");

        Map<Integer, String> map = new HashMap<Integer, String>();
        // map.put(1, "");
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");


        for (int i = 0;i < digits.length();i++) {
            int num = digits.charAt(i) - '0';

            List<String> temp = new ArrayList<String>();

            if (num == 1) continue;

            for (int m = 0;m < map.get(num).length();m++) {
                for (int n = 0;n < list.size();n++) {
                    temp.add(list.get(n) + map.get(num).charAt(m));
                }
            }
            list.clear();
            list.addAll(temp);

        }

        return list;

    }
}