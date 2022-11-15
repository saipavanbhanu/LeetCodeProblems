class Solution {
    int count(int[][] arr, int k, int l){
        int r = arr.length;
        int c = arr[0].length;
        int count = 0;
        for(int i = k-1; i <= k+1; i++){
            for(int j = l-1; j <= l+1; j++){
                if( (i >= 0 && i < r) && ( j >= 0 && j < c) ){
                    if(i == k && j == l){
                        continue;
                    }else if(arr[i][j] == 4 || arr[i][j] == 5 || arr[i][j] == 1){
                        count++;
                    }
                }
            }
        }
        return count;
    }
    public void gameOfLife(int[][] arr) {
        /*
            O-N-S
            0-0-2
            0-1-3
            1-0-4
            1-1-5
        */
        int R = arr.length; int C = arr[0].length;
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                int lc = count(arr, i, j);
                if(arr[i][j] == 1){
                    if(lc == 2 || lc == 3){
                        arr[i][j] = 5;
                    }else{
                        arr[i][j] = 4;
                    }
                }else{
                    if(lc == 3){
                        arr[i][j] = 3;
                    }else{
                        arr[i][j] = 2;
                    }
                }
            }
        }
        
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                if(arr[i][j] == 2 || arr[i][j] == 4){
                    arr[i][j] = 0;
                }else{
                    arr[i][j] = 1;
                }
            }
        }
        
    }
}