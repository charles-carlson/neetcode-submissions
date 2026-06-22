class PrefixTree {
    boolean isEnd;
    PrefixTree[] children;
    public PrefixTree() {
         isEnd = false;
         children = new PrefixTree[26];
    }

    public void insert(String word) {
        PrefixTree root = this;
        int i = 0;
        while(i < word.length()){
            int idx = word.charAt(i) - 'a';
            if(root.children[idx] == null){
                root.children[idx] = new PrefixTree();
                
            }
            root = root.children[idx];
            i++;
        }
        root.isEnd = true;
    }

    public boolean search(String word) {
        PrefixTree root = this;
        int i = 0;
        while(i < word.length()){
            int idx = word.charAt(i) - 'a';
            if(root.children[idx] == null){
                return false;
            }
            root = root.children[idx];
            i++;
        }
        return root.isEnd;
    }

    public boolean startsWith(String prefix) {
        PrefixTree root = this;
        int i = 0;
        while(i < prefix.length()){
            int idx = prefix.charAt(i) - 'a';
            if(root.children[idx] == null){
                return false;
            }
            root = root.children[idx];
            i++;
        }
        return true;
    }
}
