#https://leetcode.com/problems/all-paths-from-source-to-target/
from typing import List
import copy
class Solution:
    paths = []
    graph = ""
    n = -1
    def allPathsSourceTarget(self, graph: List[List[int]]) -> List[List[int]]:
        self.graph = graph
        self.n = len(graph)-1
        self.traverse(0, [0])
        for path in self.paths:
            if path[-1] != self.n:
                self.paths.remove(path)
        return self.paths

    def traverse(self, source, path):
        if source == self.n:
            p = copy.deepcopy(path)
            self.paths.append(p)
            return
        dests = self.graph[source]
        for dest in dests:
            path.append(dest)
            self.traverse(dest, path)
            path.remove(dest)


s = Solution()
inp = [[4,3,1],[3,2,4],[3],[4],[]]
ans = s.allPathsSourceTarget(inp)
print(ans)

