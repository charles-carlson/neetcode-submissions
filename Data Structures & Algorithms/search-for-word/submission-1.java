class Solution {
    char[][] board;
    String word;
    public boolean exist(char[][] board, String word) {
        this.board = board; 
        this.word = word;
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                Set<List<Integer>> visited = new HashSet<>();
                if (traverse(visited, r, c, 0)) return true;
            }
        }
        return false;
    }
    public boolean traverse(Set<List<Integer>> visited, int row, int col, int i){
       if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return false;
       }
       if (visited.contains(Arrays.asList(row, col))) return false;
       if (board[row][col] != word.charAt(i)) return false;
       if(i == word.length()-1){
            return true;
        }
        List<Integer> point = Arrays.asList(row,col);
        visited.add(point);
        boolean found = traverse(visited, row-1,col,i+1) ||
        traverse(visited, row,col+1,i+1) ||
        traverse(visited, row,col-1,i+1) ||
        traverse(visited, row+1,col,i+1);
        visited.remove(Arrays.asList(row,col));
        return found;
    }
}   
