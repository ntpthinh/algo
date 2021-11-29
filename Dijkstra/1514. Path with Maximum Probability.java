class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        // build adjacency list
        Map<Integer, ArrayList<double[]>> adj = new HashMap();
        for(int i = 0; i < edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            if(!adj.containsKey(u))
                adj.put(u, new ArrayList<double[]>());
            if(!adj.containsKey(v))
                adj.put(v, new ArrayList<double[]>());
            adj.get(u).add(new double[]{v, succProb[i]});
            adj.get(v).add(new double[]{u, succProb[i]});
        }
        
        return dijkstra(adj, start,end, n);
        
    }
    
    public double dijkstra(Map<Integer, ArrayList<double[]>> adj, int start, int end, int n){
        double[] dist = new double[n];
        Arrays.fill(dist, 0);
        dist[start] = 1;
        
        PriorityQueue<double[]> pq = new PriorityQueue<>((a,b)->Double.compare(b[1], a[1]));
        pq.add(new double[]{start, 1});
        
        while(pq.isEmpty() == false){
            double[] cur = pq.poll();
            if(cur[0]==end)return cur[1];
            ArrayList<double[]> nextNodes = adj.get((int)cur[0]);
            if(nextNodes!=null){
                for(double[] node: nextNodes){
                    double p = dist[(int)cur[0]]*node[1];
                    if(p>dist[(int)node[0]]){
                        dist[(int)node[0]] = p;
                        pq.add(new double[]{node[0], p});
                    }
                }
            }
        }
        return 0;
    }
}