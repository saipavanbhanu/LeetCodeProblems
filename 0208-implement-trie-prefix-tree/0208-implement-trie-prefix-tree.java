class TrieNode{
    boolean isWord;
    TrieNode[] children = new TrieNode[26];
}
class Trie {
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode it = root;
        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            if(it.children[ch-'a'] == null){
                it.children[ch-'a'] = new TrieNode();
            }
            it = it.children[ch-'a'];
        }
        it.isWord = true;
    }
    
    public boolean search(String word) {
        TrieNode it = root;
        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            if(it.children[ch-'a'] != null){
                
            }else{
                return false;
            }
            it = it.children[ch-'a'];
        }
        return it.isWord;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode it = root;
        for(int i = 0; i < prefix.length(); i++){
            char ch = prefix.charAt(i);
            if(it.children[ch-'a'] != null){
                
            }else{
                return false;
            }
            it = it.children[ch-'a'];
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