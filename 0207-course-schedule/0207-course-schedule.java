class Graph{
    int v;
    LinkedList<Integer>[] adj;
    Graph(int v){
        this.v = v;
        adj = new LinkedList[v];
        for(int i = 0; i < v; i++){
            adj[i] = new LinkedList<>();
        }
    }
    void addEdge(int i, int j){
        adj[j].add(i);
    }
}
class Solution {
    public boolean canFinish(int v, int[][] pre) {
        Graph g = new Graph(v);
        initGraph(g, pre);
        
        boolean visited[] = new boolean[v];
        for(int i = 0; i < v; i++){
            if(visited[i] == false){
                visited[i] = true;
                boolean stack[] = new boolean[v];
                if(dfs(i, stack, visited, g)){
                    return false;    
                }  //dfs will return true if it is cyclic
            }
        }
        return true;
    }
    
    boolean dfs(int vertex, boolean stack[], boolean[] visited, Graph g){
        stack[vertex] = true;
        for(Integer e : g.adj[vertex]){
            if(visited[e] == false){
                stack[e] = true;
                visited[e] = true;
                if(dfs(e, stack, visited, g)){
                    return true;
                }
            }
            if(stack[e] == true){
                return true;
            }
        }
        stack[vertex] = false;
        return false;
    }
    
    
    void initGraph(Graph g, int[][] pre){
        for(int[] dep : pre){
            g.addEdge(dep[1], dep[0]);
        }
    }
}