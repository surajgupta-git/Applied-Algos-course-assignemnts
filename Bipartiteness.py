class Bipartiteness:
    '''
    The idea is to implement BFS and color every successor with a different
    color than the parent. If we find a conflict, then return -1 else return 1. 
    '''
    def bipartite(self, edges, vertices):
        if vertices == 0 or vertices == 1:
            return 1
        self.graph = {x : [] for x in range(vertices)}
        self.add_edges(edges)
        return self.bfs(vertices)

    def add_edges(self, edges):
        for node1, node2 in edges:
            self.graph[node1].append(node2)
            self.graph[node2].append(node1)
    
    def successor(self, node):
        return self.graph[node]

    def bfs(self, vertices):
        color = [-1 for x in range(vertices)]
        fringe = []
        for i in range(vertices):
            if color[i] == -1:
                fringe.append((i, 0))
                color[i] = 0

                while fringe:
                    node, col = fringe.pop(0)
                    for succ in self.graph[node]:
                        if color[succ] == col:
                            return -1
                        if color[succ] == -1:
                            color[succ] = 1 - col
                            fringe.append((succ, color[succ]))
        return 1
