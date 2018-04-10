class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList();
        long num = 1;
        res.add(1);
        
        for (int i = 1;i <= rowIndex;i++) {
            num = num * (rowIndex - i + 1) / i;
            
            res.add((int) num);
        }
        
        return res;
    }
}