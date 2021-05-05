class TopologicalSort:
    def dfs(self, g, i, st, visiting, visited):
        visiting.add(i)
        for nbr in g[i]:
            if nbr in visiting:
                return True
            elif nbr not in visited:
                if self.dfs(g, nbr, st, visiting, visited):
                    return True
        visited.add(i)
        visiting.remove(i)
        st.append(i)
        return False

    def topo_sort(self, g, n):
        visiting, visited, st = set([]), set([]), []
        for i in range(n):
            if i not in visited:
                if self.dfs(g, i, st, visiting, visited):
                    return []
        st.reverse()
        return st

    def topoSort(self, pre_requisites: [[int]], total_courses: int) -> [int]:
        g = {} #tree
        for i in range(total_courses):
            g[i] = []
        for pre in pre_requisites:
            u, v = pre[1], pre[0]
            g[v].append(u)  # adjacency list have been used
        order = self.topo_sort(g, total_courses)
        return order



