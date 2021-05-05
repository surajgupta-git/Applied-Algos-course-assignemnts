# I have implemented the Kosaraju's algorithm to find strongly connected components in Python
# references: https://www.programiz.com/dsa/strongly-connected-components
from collections import defaultdict

class StronglyConnectedComponents:
    sccList = []
    V=0 # V is the students count or total num of vertices
    # dfs2
    def dfs2(self, d, visited_vertex,graph):
        visited_vertex[d] = True
        # print(d)
        self.sccList.append(d)
        for i in graph[d]:
            if visited_vertex[i]==False:
                self.dfs2(i, visited_vertex,graph)

    def dfs1(self, d, visited_vertex, stack,graph):
        visited_vertex[d] = True # make that vertex as true
        for i in graph[d]: # on its successors
            if visited_vertex[i]==False:
                self.dfs1(i, visited_vertex, stack,graph)
        #when all successors are completed, add the last successor to the stack
        stack = stack.append(d)

    # Print stongly connected components
    def find_scc(self,graph):
        stack = []
        visited_vertex = [False] * (self.V) # keep all vertices as not visted initially
        for i in range(self.V):
            if visited_vertex[i]==False:
                self.dfs1(i, visited_vertex, stack, graph)

        # 2nd part of the algorithm
        # gr is the transposed graph
        gr = defaultdict(list)
        for i in graph:
            for j in graph[i]:
                gr[j].append(i)

        visited_vertex = [False] * (self.V) # mark all as false for the new vertices of transposed graph
        while stack:
            i = stack.pop()
            if visited_vertex[i]==False:
                self.dfs2(i, visited_vertex,gr)
                self.sccList.append(-1) # marks the formation of stromgly connected components , this line executes when it returns out of recursion from above line=

        return self.sccList


    def scc(self, students: int, knows: [[int]]) -> [[int]]:
        self.V=students
        graph=defaultdict(list)
        for i in knows:
            graph[i[1]].append(i[0])
        answer=self.find_scc(graph)
        bigList = []
        smallList = []
        for i in answer:
            if(i==-1):
                bigList.append(smallList)
                smallList=[]
            else:
                smallList.append(i)
        return bigList



if __name__ == "__main__":
    students = 7
    knows = [[0, 1], [1, 2], [2, 0], [2, 3], [4, 3], [3, 4]]
    b=StronglyConnectedComponents()
    answerList=b.scc(students,knows)
    print(answerList)
