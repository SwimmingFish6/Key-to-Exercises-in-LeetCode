public class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        Trie root = buildTrie(words);
        List<String> res = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0;i < board.length;i++) {
            for (int j = 0;j < board[0].length;j++) {
                dfs(board, i, j, res, root, sb);
            }
        }
        
        
        return res;
    }

    public void dfs(char[][] board, int i, int j, List<String> res, Trie root, StringBuilder sb) {        
        if (board[i][j] == '#') return;
        
        Trie node = root;
        char c = board[i][j];
        if (node.children[board[i][j] - 'a'] != null) {
            sb.append(board[i][j]);
            node = node.children[board[i][j] - 'a'];
            
            if (node.isLeaf) {
                res.add(sb.toString());
                node.isLeaf = false;
            }

        }
        else return;
        
        board[i][j] = '#';
        
        if (i < board.length - 1) dfs(board, i + 1, j, res, node, sb);
        if (i > 0) dfs(board, i - 1, j, res, node, sb);
        if (j < board[0].length - 1) dfs(board, i, j + 1, res, node, sb);
        if (j > 0) dfs(board, i, j - 1, res, node, sb);

        board[i][j] = c;
        
        sb.deleteCharAt(sb.length() - 1);
    }
    
    public Trie buildTrie(String[] words) {
        Trie root = new Trie();
        
        for (int i = 0;i < words.length;i++) {
            root.insertWord(words[i]);
        }
        
        return root;
    }

    class Trie {
        Trie[] children = new Trie[26];
        boolean isLeaf = false;
        
        public void insertWord(String word) {
            Trie tmp = this;
            
            for (int i = 0;i < word.length();i++) {
                if (tmp.children[word.charAt(i) - 'a'] == null) {
                    tmp.children[word.charAt(i) - 'a'] = new Trie();
                }
                
                tmp = tmp.children[word.charAt(i) - 'a'];
            }
            
            tmp.isLeaf = true;
        }
    }

}