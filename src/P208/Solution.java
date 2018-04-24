class TrieNode {
    char val;
    boolean isLeaf;
    List<TrieNode> children;
    
    public TrieNode(char val) {
        this.val = val;
        boolean isLeaf = false;
        this.children = new ArrayList<TrieNode>();
    }
}


public class Trie {
    
    TrieNode root;
    
    /** Initialize your data structure here. */
    public Trie() {
        this.root = new TrieNode((char) 0);
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode tmp = root;
        int index = 0;
        int depth = 0;
        
        while (depth < word.length()) {
            int size = tmp.children.size();
            
            for (index = 0;index < size;index++) {
                if (word.charAt(depth) == tmp.children.get(index).val) {
                    tmp = tmp.children.get(index);
                    depth++;
                    break;
                }
            }
            
            if (index == size) break;
        }
        
        if (depth == word.length()) {
            tmp.isLeaf = true;
            return;
        }
        
        for (int i = depth;i < word.length();i++) {
            TrieNode newNode = new TrieNode(word.charAt(i));
            if (i == word.length() - 1) newNode.isLeaf = true;
            tmp.children.add(newNode);
            tmp = newNode;
        }
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode tmp = root;
        int index = 0;
        int depth = 0;
        
        while (depth < word.length()) {
            int size = tmp.children.size();
            
            for (index = 0;index < size;index++) {
                if (word.charAt(depth) == tmp.children.get(index).val) {
                    tmp = tmp.children.get(index);
                    depth++;
                    break;
                }
            }
            
            if (index == size)  return false;;
        }
        
        if (tmp.isLeaf) return true;
        
        return false;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode tmp = root;
        int index = 0;
        int depth = 0;
        
        while (depth < prefix.length()) {
            int size = tmp.children.size();
            
            for (index = 0;index < size;index++) {
                if (prefix.charAt(depth) == tmp.children.get(index).val) {
                    tmp = tmp.children.get(index);
                    depth++;
                    break;
                }
            }
            
            if (index == size)  return false;;
        }
        
        return true;
        
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */