import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (target == 0) {
            result.add(new ArrayList<Integer>());
            return result;
        }



        for (int i = 0;i < candidates.length;i++){
            int num = candidates[i];
            List<List<Integer>> tmp;
            if (target < num) continue;
            tmp = combinationSum(candidates, target - num);

            for (int j = 0;j < tmp.size();j++) {
                tmp.get(j).add(num);
            }

            while (i < candidates.length - 1 && candidates[i + 1] == num) {
                i++;
            }

            result.addAll(tmp);
        }

        return result;
    }
}