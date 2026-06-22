class WordDictionary {
    boolean isEnd;
    WordDictionary[] children;
    public WordDictionary() {
        children = new WordDictionary[27];
        isEnd = false;
    }

    public void addWord(String word) {
        WordDictionary current = this;
        int i = 0;
        while(i < word.length()){
            char c = word.charAt(i);
            int idx = c == '.' ? 26 : c - 'a';
            if(current.children[idx] == null){
                current.children[idx] = new WordDictionary();
            }
            current = current.children[idx];
            i++;
        }
        current.isEnd = true;
    }

    public boolean search(String word) {
        return dfs(word,0,this);
    }
    public boolean dfs(String word, int i,WordDictionary current){
        if(i == word.length()) return current.isEnd;
        char c = word.charAt(i);
        if(c == '.'){
            for(WordDictionary node : current.children){
                if(node != null && dfs(word,i+1,node)) return true;
            }
            return false;
        }            
        int idx = c - 'a';
        if(current.children[idx] == null) return false;
        current = current.children[idx];
        i++;
        return dfs(word,i,current);

    }
}
