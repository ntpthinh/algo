class Solution {
    class Stop{
        int dest, cost, remaining;
        public Stop(int dest, int cost, int remaining){
            this.dest = dest;
            this.cost = cost;
            this.remaining = remaining;
        }
    }
    
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, ArrayList<int[]>> adj = new HashMap();
        for(int i = 0; i < flights.length; i++){
            if(!adj.containsKey(flights[i][0]))
                adj.put(flights[i][0], new ArrayList<int[]>());
            adj.get(flights[i][0]).add(new int[]{flights[i][1], flights[i][2]});
        }

        PriorityQueue<Stop> pq = new PriorityQueue<>((x,y)->{
            if(x.remaining == y.remaining) return x.cost - y.cost;
            return x.remaining - y.remaining;
        });
        pq.add(new Stop(src, 0, 0));
        
        int[] dist = new int[n];
        int[] steps = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        while(!pq.isEmpty()){
            Stop cur = pq.poll();
            
            ArrayList<int[]> nextNodes = adj.get(cur.dest);
            if(nextNodes!=null){
                    for(int[] neighbor : nextNodes){
                        int newCost = cur.cost + neighbor[1];
                        if(newCost < dist[neighbor[0]] && cur.remaining <= k){
                                pq.add(new Stop(neighbor[0], newCost, cur.remaining + 1));
                                dist[neighbor[0]] = newCost;
                            }
                        }
            }        
            
        }
        return dist[dst] == Integer.MAX_VALUE?-1:dist[dst];
    }
}