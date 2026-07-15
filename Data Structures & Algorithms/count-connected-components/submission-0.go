type DSU struct {
    parent []int
    rank []int
}
func NewDSU(n int) *DSU {
    parent := make([]int,n)
    rank := make([]int, n)
    for i := range parent {
        parent[i] = i
    }
    return &DSU{parent:parent,rank:rank}
}
func (d *DSU) Find(i int) int {
    if d.parent[i] == i {
        return i
    }
    d.parent[i] = d.Find(d.parent[i])
    return d.parent[i]
}
func (d *DSU) Union(i, j int) bool {
    rootI := d.Find(i)
    rootJ := d.Find(j)
    if rootI == rootJ {return false}
    if d.rank[rootI] < d.rank[rootJ] {
        d.parent[rootI] = rootJ
    } else if d.rank[rootI] > d.rank[rootJ]{
        d.parent[rootJ] = rootI
    } else {
        d.parent[rootJ] = rootI
        d.rank[rootI]++
    }
    return true
}
func countComponents(n int, edges [][]int) int {
    // start nodes as n amount of components
    res := n
    dsu := NewDSU(n)
    for _, edge := range edges {
        i,j := edge[0],edge[1]
        if ok := dsu.Union(i,j); ok {
            res--
        }
    }
    return res
}
