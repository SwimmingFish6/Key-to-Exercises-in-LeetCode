class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        Set<String> dict = new HashSet<String>();
        
        // for (int i = 0;i < wordDict.length;i++) {
        //     dict.add(wordDict.get(i));
        // }
        
        List<String> res = dfs(s, wordDict, map);

        return res;
    }
    
    public List<String> dfs(String s, List<String> dict, Map<String, List<String>> map) {
        List<String> res = new ArrayList<String>();
        
        if (s.length() == 0) {
            res.add(new String());
            
            return res;
        }
        
        if (map.containsKey(s)) {
            return map.get(s);
        }
        
        for (String word : dict) {
            if (s.startsWith(word)) {
                List<String> tmp = dfs(s.substring(word.length()), dict, map);
                for (int i = 0;i < tmp.size();i++) {
                    res.add((tmp.get(i).isEmpty()?word:word + " ") + tmp.get(i));
                }
            }
        }
        
        map.put(s, res);
        
        return res;
    }
}