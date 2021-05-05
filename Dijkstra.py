import math
from heapq import heappop, heappush


# A class to store a graph edge
class Edge:
    def __init__(self, source, dest, weight):
        self.source = source
        self.dest = dest
        self.weight = weight


# A class to store a heap node
class Node:
    def __init__(self, vertex, weight):
        self.vertex = vertex
        self.weight = weight

    # Override the `__lt__()` function to make `Node` class work with a min-heap
    def __lt__(self, other):
        return self.weight < other.weight


class Dijkstra:
    def shortestDistance(self, edges, vertices):
        if vertices<1:
            return []
        edges1 = []
        for edge in edges:
            edges1.append(Edge(edge[0], edge[1], edge[2]))
        adj = [[] for i in range(vertices)]
        for edge in edges1:
            adj[edge.source].append(edge)
        # create a min-heap and push source node having distance 0
        pq = []
        source = 0
        heappush(pq, Node(source, 0))
        dist = [math.inf] * vertices
        dist[source] = 0
        # list to track vertices for which minimum cost is already found
        done = [False] * vertices
        done[source] = True
        while pq:
            node = heappop(pq)  # Remove and return the best vertex
            u = node.vertex  # get the vertex number
            # do for each neighbor `v` of `u`
            for edge in adj[u]:
                v = edge.dest
                weight = edge.weight
                # Relaxation step
                if not done[v] and (dist[u] + weight) < dist[v]:
                    dist[v] = dist[u] + weight
                    heappush(pq, Node(v, dist[v]))
            # mark vertex `u` as done so it will not get picked up again
            done[u] = True
        for i in range(0, vertices):
            if dist[i] == math.inf:
                dist[i] = -1
        return dist
