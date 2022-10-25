class Node {
    int i, j;
    Node(int i, int j) {
        this.i = i;
        this.j = j;
    }
    public String toString(){
        String str = "("+i+","+j+") ";
        return str;
    }
}
class Solution {
    boolean borderFlag;
    boolean[][] visited;
    public void solve(char[][] board) {
        int rows = board.length, cols = board[0].length;
        visited = new boolean[rows][cols];
        List < Node > tList = null;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!visited[i][j]) {
                    if (board[i][j] == 'X') {
                        visited[i][j] = true;
                    } else {
                        borderFlag = false;
                        tList = new ArrayList < > ();
                        dfs(i, j, tList, board);
                        //System.out.println(tList);
                        //System.out.println(borderFlag);
                        if (borderFlag == false) {
                            for (Node n: tList) {
                                board[n.i][n.j] = 'X';
                            }
                        }
                    }
                }
            }
        }
    }

    void dfs(int i, int j, List < Node > tList, char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        visited[i][j] = true;
        if(i == 0 || i == rows-1 || j == 0 || j == cols-1)
            borderFlag = true;
        
        tList.add(new Node(i, j));
        int k = i - 1;
        int l = j;
        if (k >= 0 && board[k][l] == 'O' && visited[k][l] == false) {
            if (k == 0) {
                borderFlag = true;
            }
            dfs(k, l, tList, board);
        }

        k = i;
        l = j + 1;
        if (l < cols && board[k][l] == 'O' && visited[k][l] == false) {
            if (l == cols - 1) {
                borderFlag = true;
            }

            dfs(k, l, tList, board);

        }

        k = i + 1;
        l = j;
        if (k < rows && board[k][l] == 'O' && visited[k][l] == false) {
            if (k == rows - 1) {
                borderFlag = true;
            }

            dfs(k, l, tList, board);

        }

        k = i;
        l = j - 1;
        if (l >= 0 && board[k][l] == 'O' && visited[k][l] == false) {
            if (l == 0) {
                borderFlag = true;
            }

            dfs(k, l, tList, board);

        }
    }

}