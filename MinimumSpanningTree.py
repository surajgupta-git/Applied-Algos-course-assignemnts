class MinimumSpanningTree:
    def find(self, parent, i):
        if parent[i] == i:
            return i
        return self.find(parent, parent[i])

    def union(self, parent, rank, x, y):
        xroot = self.find(parent, x)
        yroot = self.find(parent, y)
        if rank[xroot] < rank[yroot]:
            parent[xroot] = yroot
        elif rank[xroot] > rank[yroot]:
            parent[yroot] = xroot
        else:
            parent[yroot] = xroot
            rank[xroot] += 1

    def mst(self, edges: [[int]], vertices: int) -> int:
        result, graph, parent, rank = [], [], [], []
        i = 0  # An index variable, used for iterating on  all the sorted edges
        j = 0  # An index variable, used for result[]
        for edge in edges:
            graph.append([edge[0], edge[1], edge[2]])
        graph = sorted(graph, key=lambda item: item[2])  # sorted by weight
        # Create V subsets with single elements
        for node in range(vertices):
            parent.append(node)
            rank.append(0)
        while j < vertices - 1:  # MST contains |V|-1 num of edges in result, < is used - vertices start with index 0
            # Step 2: Pick the smallest edge and increment the index for next iteration
            u, v, w = graph[i]
            i = i + 1
            x = self.find(parent, u)
            y = self.find(parent, v)
            # If this edge doesn't cause cycle, include it in result and increment the index of result for next edge
            if x != y:
                j = j + 1
                result.append([u, v, w])
                self.union(parent, rank, x, y)
            # Else discard the edge
        minimumCost = 0
        for u, v, weight in result:
            minimumCost += weight
        return minimumCost


if __name__ == '__main__':
    a = MinimumSpanningTree()
    vertices = 4
    edges = [[0, 1, 10], [0, 2, 6], [0, 3, 5], [1, 3, 15], [2, 3, 4]]
    ans = a.mst(edges, vertices)
    print(ans)
