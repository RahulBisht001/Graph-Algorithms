```java


// # Dijkstra's Algorithm

//1: PriorityQueue version
--------------------------


class Solution {
    static int[] dijkstra(int v, ArrayList<ArrayList<ArrayList<Integer>>> adj,
        int src) {
        
        // Min Heap -> Distance and node
        PriorityQueue<int[]>pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        
        
        int[]distance = new int[v];
        for(int i = 0; i < v; ++i)
            distance[i] = Integer.MAX_VALUE;
        
        distance[src] = 0;
        pq.add(new int[]{0, src});
        
        while(!pq.isEmpty()){
            int dist = pq.peek()[0];
            int node = pq.peek()[1];
            
            pq.poll();
            
            // now because its a ArrayList<ArrayList<ArrayList<Integer>>> adj
            // adj.get(node) will give us a ArrayList where we have neighbour 
            // node along with their weights
            
            // for (int i = 0; i < adj.get(node).size(); ++i) {
            //     int edgeWeight = adj.get(node).get(i).get(1);
            //     int adjNode = adj.get(node).get(i).get(0);

            //     if (dist + edgeWeight < distance[adjNode]) {
            //         distance[adjNode] = dist + edgeWeight;
            //         pq.add(new int[] {distance[adjNode], adjNode });
            //     }
            // }
            
            for(ArrayList<Integer>neighbours : adj.get(node)){
                int adjNode = neighbours.get(0);
                int edgeWeight = neighbours.get(1);
                
                if(dist + edgeWeight < distance[adjNode]){
                    distance[adjNode] = dist + edgeWeight;
                    pq.add(new int[]{distance[adjNode], adjNode});
                }
            }
        }
        
        return distance;
    }
}
```