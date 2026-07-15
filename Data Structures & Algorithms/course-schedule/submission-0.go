func canFinish(numCourses int, prerequisites [][]int) bool {
    path := make(map[int][]int)
	visited := make(map[int]struct{})

	for i:=0;i<numCourses;i++{
		path[i] = []int{}
	}

	for _, preq := range prerequisites {
 		course, prereq := preq[0], preq[1]
    	path[course] = append(path[course], prereq)
	}

	var dfs func(course int) (bool)

	dfs = func(course int) (bool) {
		if _,visited := visited[course]; visited {
			return true
		}
		if len(path[course]) == 0 {
			return false
		}
		visited[course] = struct{}{}
		for _, neighbor := range path[course] {
			if isCycle := dfs(neighbor);isCycle {
				return true
			}
		}
		delete(visited,course)
		path[course] = []int{}
		return false
	}

	for course := 0;course < numCourses; course++{
		if isCycle := dfs(course);isCycle {
			return false
		}
	}
	return true
}
