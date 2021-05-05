
//critical links /bridges/ cut edges using tarjans algo -- also try SCC and articulation points using tarjan's algo
//
// References: https://medium.com/@bdevapatla/leetcode-1192-critical-connections-in-a-network-a-comprehensive-solution-9a0a9a004f3 - code ref
// https://www.geeksforgeeks.org/tarjan-algorithm-find-strongly-connected-components/ - concept ref
//https://www.geeksforgeeks.org/bridge-in-a-graph/  -- code ref and video

//https://emre.me/algorithms/tarjans-algorithm/ - code ref
//        For any node u, when DFS starts, Low will be set to its Disc 1st.
//                Then later on DFS will be performed on each of its children v one by one, Low value of u can change it two case:
//        Case1 (Tree Edge): If node v is not visited already, then after DFS of v is complete, then minimum of low[u] and low[v] will be updated to low[u].
//                low[u] = min(low[u], low[v]);
//        Case 2 (Back Edge): When child v is already visited, then minimum of low[u] and Disc[v] will be updated to low[u].
//                low[u] = min(low[u], disc[v]);

//notes: suppose you are on a node, if its next node is not visited - complete dfs and then update low[node]=low[node]+low[nextnode]
       // if the next node is visited, take low[node] = low + disc, make sure the next node cant be parent in both cases
import java.util.*;
public class CriticalLink {
    int counter = 0;
    int[] preorder; //discovery times array
    int[] low; //lowest of the disc times in the neighbours subgraph
    int numOfLinks=0;
    public int criticalLink(int n, int[][] links) {
        //converting 2D array to 2D arraylist
        List<List<Integer>> linksList = new ArrayList<>();
        for (int[] ints : links) {
            List<Integer> list = new ArrayList<>();
            for (int i : ints) {
                list.add(i);
            }
            linksList.add(list);
        }
        // making the graphs from the Pairs
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();
        for (int i = 0; i < linksList.size(); i++) {
            int from = linksList.get(i).get(0), to = linksList.get(i).get(1);
            graph[from].add(to);
            graph[to].add(from);
        }
        counter = 0;
        preorder = new int[n];  // preorder[e] = order in which dfs examines e
        low = new int[n];       // low[e] = lowest preorder of any vertex connected to e
        for(int i=0; i < n; i++) {
            preorder[i] = -1;
            low[i] = -1;
        }
        for(int i=0; i < n; i++) {
            if(preorder[i] == -1) //vertex i is not examined yet
                dfs(graph,i,i);
        }
        return numOfLinks;
    }
    public void dfs(List<Integer>[] graph, int vertex, int parent) {
        preorder[vertex] = counter++;
        low[vertex] = preorder[vertex];
        List<Integer> neighbors = graph[vertex];

        for (Integer neighbor : neighbors)
        {
            if (preorder[neighbor] == -1)
            { //implies not visited
                dfs(graph, neighbor, vertex);
                //when done recursion of all possibilities from neighbor the lowest preorder time of vertex is the lowest of the subtree originating from vertex so record it
                low[vertex] = Math.min(low[vertex], low[neighbor]);
                //check the lowest preorder level of neighbor if the lowest preorder level of neighbor is same as preorder level of vertex
                //then the edge between vertex and neighbor is a BRIDGE Meaning there is no other way to reach neighbor from vertex
                if (low[neighbor] != low[vertex]) // or low[neighbor] > preorder[vertex])
                    // in a cycle, the low of all the vertices will be same, when lows are diff implies those 2 vertices belong to bridge
                    numOfLinks++;
            }
            else if (neighbor != parent) //if visited and not a parent
            { //don't include the vertex that led to vertex i.e parent
                low[vertex] = Math.min(low[vertex], preorder[neighbor]);
                //when not in the tree Math.min is between current vertex (vertex) and preorder time of the neighbor (which is not part of the subtree)
            }
        }
    }

    public static void main(String[] args)
    {
        CriticalLink a=new CriticalLink();
        int n=5;
        int[][] links = {{0,1},{0,2},{2,1},{3,0},{4,3}};
        int answer=a.criticalLink(n,links);
        System.out.println(answer);
    }
}

