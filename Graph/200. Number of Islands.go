func numIslands(grid [][]byte) int {
	n := len(grid)
	m := len(grid[0])

	visited := make([][]bool, n)
	for i := 0; i < n; i++{
			visited[i] = make([]bool, m)
	}
	count := 0
	for i:= 0; i < n ; i++{
			for j := 0; j < m; j++{
					if !visited[i][j] && grid[i][j] == '1'{
							dfs(grid, visited, i,j,n, m)
							count++
					}
			}
	}
	return count
	
}
var (
	dx = [4]int {0,0,1,-1}
	dy = [4]int {1,-1,0,0}
)
func dfs(grid [][]byte, visited [][]bool,  x int,  y int,  n int,  m int){
	visited[x][y] = true
	for k := 0; k < 4; k++{
			r := x + dx[k]
			c := y + dy[k]
			if r >= 0 && r < n && c >= 0 && c < m && !visited[r][c] && grid[r][c] == '1'{
					dfs(grid, visited, r, c, n, m)
			}
			
	}
	
}