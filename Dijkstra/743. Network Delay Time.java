class Solution {
    class Pair{
        int dist, node;
        public Pair(int node, int dist){
            this.dist = dist;
            this.node = node;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        // build adjacency list
        Map<Integer, ArrayList<int[]>> adj = new HashMap();
        for(int i = 0; i < times.length; i++){
            if(!adj.containsKey(times[i][0]))
                adj.put(times[i][0], new ArrayList<int[]>());
            adj.get(times[i][0]).add(new int[]{times[i][1], times[i][2]});
        }
        
        int[] d = dijkstra(adj, k, n);
        
        int max = -1;
        for(int i = 1; i < d.length; i++){
            if(d[i] == Integer.MAX_VALUE)
                return -1;
            max = Math.max(max, d[i]);
        }
        return max;
        
    }
    public int[] dijkstra(Map<Integer, ArrayList<int[]>> adj, int k, int n){
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y)->x.dist - y.dist);
        pq.add(new Pair(k, 0));

        int[] d = new int[n+1];
        Arrays.fill(d, Integer.MAX_VALUE);
        d[k] = 0;

        while(pq.isEmpty() == false){
            Pair curr = pq.poll();
            ArrayList<int[]> nextNodes = adj.get(curr.node);
            if(nextNodes != null){
                for(int[] node : nextNodes){
                    int newDistance = curr.dist + node[1];
                    if(newDistance < d[node[0]]){
                        d[node[0]] = newDistance;
                        pq.add(new Pair(node[0], newDistance));
                    }
                }
            }
            
        }
        
        return d;
    }
}