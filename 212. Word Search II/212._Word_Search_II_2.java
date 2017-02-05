class Solution {
    public class Trie {
        class TrieNode {
            TrieNode[] nexts;
            String word;
            public TrieNode() {
                this.nexts = new TrieNode[26];
            }
        }   
        TrieNode root;
        public Trie() {
            this.root = new TrieNode();
        }
        public void add(String word) {
            TrieNode current = root;
            for(int i=0; i<word.length(); i++) {
                char cc = word.charAt(i);
                int index = cc - 'a';
                if( current.nexts[index] == null)
                    current.nexts[index] = new TrieNode();
                current = current.nexts[index];
            }
            current.word = word;
        }
        public boolean startsWith(String prefix) {
            TrieNode current = root;
            for(int i=0; i<prefix.length(); i++) {
                int index = prefix.charAt(i) - 'a';
                if( current.nexts[index] == null)
                    return false;
                current = current.nexts[index];
            }
            return true;
        }
        public boolean hasWord(String word) {
            TrieNode current = root;
            for(int i=0; i<word.length(); i++) {
                int index = word.charAt(i) - 'a';
                if( current.nexts[index] == null)
                    return false;
                current = current.nexts[index];
            }
            return word.equals(current.word);
        }
    }
    Set<String> ans;
    int m, n;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    public List<String> findWords(char[][] board, String[] words) {
        Trie dict = new Trie();
        for(String s: words) {
            dict.add(s);
        }
        m = board.length;
        n = (m == 0) ? 0: board[0].length;
        boolean[][] visited = new boolean[m][n];
        ans = new HashSet<String>();
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                search(board, visited, dict, "", i, j);
            }
        }
        return (new ArrayList<String>(ans));
    }
    public void search(char[][] board, boolean[][] visited, Trie dict, String prefix, int i, int j) {
        if( i<0 || i>=m || j<0 || j>=n || visited[i][j])
            return;
        prefix += board[i][j];
        if( !dict.startsWith(prefix) )
            return;
        if( dict.hasWord(prefix) )
            ans.add(prefix);
        
        visited[i][j] = true;
        for(int k=0; k<4; k++) 
            search(board, visited, dict, prefix, i+dx[k], j+dy[k]);
        visited[i][j] = false;
    }
}