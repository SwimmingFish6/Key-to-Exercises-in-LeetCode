public class WordDictionary {
    public class DictNode {
        DictNode[] children = new DictNode[26];
        boolean isLeaf = false;
    }
    
    DictNode root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new DictNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        int depth = 0; 
        DictNode tmp = root;
        
        while (depth < word.length()) {
            if (tmp.children[word.charAt(depth) - 'a'] == null) {
                tmp.children[word.charAt(depth) - 'a'] = new DictNode();
            }
            tmp = tmp.children[word.charAt(depth) - 'a'];
            depth++;
            
            if (depth == word.length()) tmp.isLeaf = true;
        }
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return match(word, root, 0);
    }
    
    public boolean match(String word, DictNode node, int index) {  
        if (index == word.length()) {
            return node.isLeaf;
        }
        
        if (word.charAt(index) != '.') {
            if (node.children[word.charAt(index) - 'a'] == null) return false;
            
            return match(word, node.children[word.charAt(index) - 'a'], index + 1);
        }
        else {
            for (int i = 0;i < 26;i++) {
                if (node.children[i] != null) {
                    if (match(word, node.children[i], index + 1)) return true;
                }
            }
        
            return false;        
        }
        
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */