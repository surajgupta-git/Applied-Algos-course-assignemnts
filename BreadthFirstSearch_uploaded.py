class BreadthFirstSearch:
    def breadthFirstSearch(self, edges, vertices):
        self.graph = {i: [] for i in range(vertices)}
        for n1, n2 in edges:
            self.add(n1, n2)
        return self.bfs(vertices)

    def add(self, node1, node2):
        self.graph[node1].append(node2)

    def succ(self, n):
        return self.graph[n]

    def bfs(self, vertices):
        if vertices == 0:
            return []

        visited = [False] * vertices
        shortDist = [-1] * vertices
        parent = [x for x in range(vertices)]
        fringe = []
        fringe.append(0)
        visited[0] = True
        shortDist[0] = 0
        while fringe:
            current_node = fringe.pop(0)
            for node in self.succ(current_node):
                if not visited[node]:
                    visited[node] = True
                    parent[node] = current_node
                    shortDist[node] = shortDist[parent[node]] + 1
                    fringe.append(node)

        return shortDist

# if __name__ == "__main__":
#     g = BreadthFirstSearch()
#     g.add(0, 1)
#     g.add(0, 2)
#     g.add(1, 2)
#     g.add(2, 0)
#     g.add(2, 3)
#     g.add(3, 3)
#     print(g.bfs(2))
