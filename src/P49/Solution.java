class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<Integer, List<String>> map = new HashMap<Integer, List<String>>();        
        List<List<String>> res = new ArrayList<List<String>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        
        for (int i = 0;i < strs.length;i++) {
            char chs[]=strs[i].toCharArray();
            int hashValue = 0;
            for (int j = 0;j < chs.length;j++) {
                hashValue += chs[j] * chs[j] * (chs[j] * chs[j] - 3 * chs[j]);
            }
            
            if (map.containsKey(hashValue)) {
                map.get(hashValue).add(strs[i]);
            }
            else {
                ArrayList<String> temp = new ArrayList<String>();
                temp.add(strs[i]);
                map.put(hashValue, temp);
            }
        }
        
        for (List<String> value : map.values()) {                 
            res.add(value);             
        }   
        
        return res;
    }
}