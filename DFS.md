```java

class Solution {
    public ArrayList<Integer>dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj){
        
        ArrayList<Integer>res = new ArrayList<>();
        boolean[]visited = new boolean[V];
        
        // #1
        // dfs(startNode, visited, adj, res);

        /**
         * actually the simple difference between 1 and 2 is 
         * in 1 we don't care about distinct components adn there we start with the
         * given starting node.
         * 
         * where as with 2 we do care about all components hence
         * we add a for loop and a visited condition( to do duplicate traversal)
         * */

        //#2
        for(int i = 0;i < V;++i){
            if(visited[i] == false)
                dfs(i, visited, adj, res);
        }
        
        return res;
    }
    private void dfs(int node, boolean[]visited, 
        ArrayList<ArrayList<Integer>> adj, ArrayList<Integer>res){
        
        visited[node] = true;
        res.add(node);
        
        for(Integer idx : adj.get(node)){
            if(visited[idx] == false)
                dfs(idx,visited,adj,res);
        }
    }
}
```