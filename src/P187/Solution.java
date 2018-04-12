class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<String>();
        
        if (s.length() < 10) return res;
        
        Map<String, Integer> map = new HashMap<String, Integer>();
        
        for (int i = 0;i < s.length() - 9;i++) {
            String subS = s.substring(i, i + 10);
            if (!map.containsKey(subS)) map.put(subS, 1);
            else {
                if (map.get(subS) == 1) {
                    res.add(subS);
                    map.put(subS, 2);
                }
            }
        }
        
        return res;
    }
}