class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        count = 0
        rows = len(grid)
        cols = len(grid[0])
        visited = [[False] * cols for r in range(rows)]
        for r in range(rows):
            for c in range(cols):
                if grid[r][c] == "1" and not visited[r][c]:
                    count += 1
                    self.dfs(grid,visited,r,c)
        return count

    def dfs(self,grid,visited,r,c):
        if r < 0 or r >= len(grid) or c < 0 or c >= len(grid[0]):
            return
        if visited[r][c] or grid[r][c] == "0":
            return
        visited[r][c] = True
        self.dfs(grid,visited,r,c+1)
        self.dfs(grid,visited,r,c-1)
        self.dfs(grid,visited,r+1,c)
        self.dfs(grid,visited,r-1,c)

        
        
        