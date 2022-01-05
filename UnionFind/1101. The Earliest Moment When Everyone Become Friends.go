func earliestAcq(logs [][]int, n int) int {
	sort.SliceStable(logs, func(i, j int) bool{
			return logs[i][0] < logs[j][0]
	})
	uf := initUnionFind(n)
	for i := 0; i < len(logs); i++{
			if uf.union(logs[i][1], logs[i][2]){
					n--
			}
			
			if n == 1{
					return logs[i][0]
			}
	}
	
	
	return -1
}

type UnionFind struct {
	size int
	parent, rank []int    
}

func initUnionFind(s int) *UnionFind {
	uf := UnionFind{
			size : s,
			parent : make([]int,s),
			rank : make([]int, s),
	}
	for i := 0; i < s; i++ {
			uf.parent[i] = i
			uf.rank[i] = 0
	}
	return &uf
}

func (uf *UnionFind) find(i int) int{
	if i == uf.parent[i]{
			return i
	}
	return uf.find(uf.parent[i])
}

func (uf *UnionFind) union(u int, v int) bool{
	rootU := uf.find(u)
	rootV := uf.find(v)
	if rootU == rootV {
			return false
	}
	if uf.rank[rootU] < uf.rank[rootV] {
			uf.parent[rootU] = rootV
	}else{
			uf.parent[rootV] = rootU
			if uf.rank[rootU] == uf.rank[rootV]{
					uf.rank[rootU] += 1
			}
	}
	return true
}