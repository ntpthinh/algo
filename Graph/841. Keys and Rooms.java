class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> visited = new HashSet<>();
        dfs(rooms, visited, 0);
        return visited.size() == rooms.size();
    }

    void dfs(List<List<Integer>> rooms, Set<Integer> visited, int cur) {
        visited.add(cur);
        for (int nextRoom : rooms.get(cur)) {
            if (!visited.contains(nextRoom)) {
                dfs(rooms, visited, nextRoom);
            }
        }
    }
}