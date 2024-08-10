`Time Complexity: O(N)`

`Space Complexity: O(N) for Queue + O(N) for visited array`

```java
class Solution {
    public ArrayList<Integer> bfsOfGraph(int V, 
        ArrayList<ArrayList<Integer>> adj) {
        
        ArrayList<Integer>res = new ArrayList<>();
        boolean[]visited = new boolean[V];
        
        Queue<Integer>q = new LinkedList<>();
        q.add(0);
        visited[0] = true;
        
        while(!q.isEmpty()){
            int node = q.poll();
            res.add(node);
            
            for(Integer idx : adj.get(node)){
                if(visited[idx] == false){
                    visited[idx] = true;
                    q.add(idx);
                }
            }
        }
        
        return res;
    }
}

```