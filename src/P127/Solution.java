class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<String>();
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        
        Set<String> wordSet = new HashSet<String>(wordList);
        
        if (!wordSet.contains(endWord)) return 0;
        
        queue.offer(beginWord);
        map.put(beginWord, 1);
        
        while (!queue.isEmpty()) {
            String tmp = queue.poll();
            char[] newWord = tmp.toCharArray();
            
            for (int i = 0;i < tmp.length();i++) {
                char old = newWord[i];
                for (int j = 0;j < 26;j++) {                    
                    if ('a' + j == newWord[i]) continue;
                    
                    newWord[i] = (char) ('a' + j);
                    
                    String newStr = String.valueOf(newWord);
                    
                    if (newStr.equals(endWord)) return map.get(tmp) + 1;
                    
                    if (!map.containsKey(String.valueOf(newStr)) && wordSet.contains(newStr)) {
                        map.put(newStr, map.get(tmp) + 1);
                        queue.offer(newStr);
                    }
                    
                    newWord[i] = old;
                }
                
            }
            
        }
        
        return 0;
    }
}