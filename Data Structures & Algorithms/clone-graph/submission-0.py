"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

class Solution:
    def cloneGraph(self, node: Optional['Node']) -> Optional['Node']:

        if node is None:
            return None

        clone = {}
        def dfs(neighbor):

            if clone.get(neighbor,0) != 0:
                return clone.get(neighbor)

            clonedNode = Node(neighbor.val)
            clone[neighbor] = clonedNode

            for n in neighbor.neighbors:
                clonedNode.neighbors.append(dfs(n))
            return clonedNode

        return dfs(node)
               
