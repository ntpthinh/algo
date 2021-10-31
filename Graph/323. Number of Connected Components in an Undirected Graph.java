class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);

        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                dfs(adjList, visited, i);
            }
        }
        return count;
    }

    public void dfs(List<List<Integer>> graph, boolean[] visited, int cur) {
        for (Integer node : graph.get(cur)) {
            if (!visited[node]) {
                visited[node] = true;
                dfs(graph, visited, node);
            }

        }
    }
}