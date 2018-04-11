class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> step = new ArrayList();
        step.addAll(triangle.get(triangle.size() - 1));
        
        
        for (int i = 1;i <= triangle.size() - 1;i++) {
            for (int j = 0;j < triangle.size() - i;j++) {
                step.set(j, Math.min(step.get(j), step.get(j + 1)) + triangle.get(triangle.size() - 1 - i).get(j));
            }
        }
        
        return step.get(0);
    }
}
