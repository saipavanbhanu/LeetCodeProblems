class Node implements Comparable<Node>{
    int i, j;
    Integer no;
    Node(int i, int j, Integer no){
        this.i = i;
        this.j = j;
        this.no = no;
    }
    public int compareTo(Node node2){
        return this.no.compareTo(node2.no);
    }
    @Override
    public boolean equals(Object obj){
        if(this == obj)
                return true;

        if(obj == null || obj.getClass()!= this.getClass())
            return false;

        // type casting of the argument. 
        Node node = (Node) obj;

        // comparing the state of argument with 
        // the state of 'this' Object.
        return (node.i == this.i && node.j == this.j);
    }
    
    @Override
    public int hashCode(){
        return this.i + this.j;
    }
}

class Solution {
    public int kthSmallest(int[][] arr, int k) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0,0, arr[0][0]));
        int result = arr[0][0];
        boolean [][] visited = new boolean[arr.length][arr.length];
        visited[0][0] = true;
        for(int it = 1; it <= k; ){
            Node polled = pq.poll();
            int i = polled.i;
            int j = polled.j;
            result = arr[i][j];
            it++;
            if(j+1 < arr[0].length){
                Node temp = new Node(i, j+1, arr[i][j+1]);
                if(visited[i][j+1] == false){
                    visited[i][j+1] = true;
                    pq.add(temp);
                }
            }
            if(i+1 < arr.length){
                Node temp = new Node(i+1, j, arr[i+1][j]);
                if(visited[i+1][j] == false){
                    visited[i+1][j] = true;
                    pq.add(temp);
                }
            }
        }
        return result;
    }
}