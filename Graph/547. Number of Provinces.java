class Solution {
    public int findCircleNum(int[][] isConnected) {
        List<List<Integer>> adjList = new ArrayList<>();
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (isConnected[row][col] == 1) {
                    adjList.get(row).add(col);
                    adjList.get(col).add(row);
                }
            }
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

    public void dfs(List<List<Integer>> adjList, boolean[] visited, int cur) {
        for (int nextNode : adjList.get(cur)) {
            if (!visited[nextNode]) {
                visited[nextNode] = true;
                dfs(adjList, visited, nextNode);
            }
        }
    }
}