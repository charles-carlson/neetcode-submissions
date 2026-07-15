func validTree(n int, edges [][]int) bool {
	//check if tree has n-1 edges to nodes that exist in the tree
	if len(edges) != n-1 { return false }
    visited := make(map[int]struct{})
	path := make(map[int][]int)
	for i:=0;i<n;i++{
		path[i] = []int{}
	}
	//undirected graph, nodes go back and forth
	for _, edge := range edges {
		a,b := edge[0], edge[1]
		path[a] = append(path[a],b)
		path[b] = append(path[b],a)
	}
	var dfs func(node int, parent int) (bool)
	dfs = func(node int,parent int) (bool){
		visited[node] = struct{}{}
		for _,n := range path[node] {
			if n == parent {
				continue
			}
			if _,ok := visited[n];ok {
				return false
			}
			if !dfs(n,node) {
				return false
			}
		}
		return true
	}
	isValid := dfs(0,-1)
	return isValid && len(visited) == n
}
