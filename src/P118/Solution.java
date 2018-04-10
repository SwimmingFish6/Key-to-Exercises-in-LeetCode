class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (numRows == 0) return res;
        res.add(Arrays.asList(new Integer[]{1}));
        
        for (int i = 2;i <= numRows;i++) {
            List<Integer> tmp = new ArrayList<Integer>();
            for (int j = 0;j < i;j++) {
                tmp.add(j == 0?res.get(i - 2).get(0):j == i - 1? res.get(i - 2).get(i - 2):res.get(i - 2).get(j - 1) + res.get(i - 2).get(j));
            }
            res.add(tmp);
        }
        
        return res;
    }
}