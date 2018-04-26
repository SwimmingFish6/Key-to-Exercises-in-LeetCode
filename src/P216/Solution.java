import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {


        return helper(k, 1, n);
    }

    public List<List<Integer>> helper(int k, int begin, int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        if (k == 0) {
            if (n == 0) res.add(new ArrayList<Integer>());
            return res;
        }


        for (int i = begin;i <= 9;i++) {
            if (k == 1) {
                if (n - i == 0) {
                    List<Integer> tmp = new ArrayList<Integer>();
                    tmp.add(i);
                    res.add(tmp);
                    return res;
                }
            }
            else {
                List<List<Integer>> tmp = helper(k - 1, i + 1, n - i);
                for (int j = 0;j < tmp.size();j++) {
                    tmp.get(j).add(0, i);
                }
                res.addAll(tmp);
            }

            if (k != 1 && n - i < i + 1) break;
        }

        return res;

    }
}