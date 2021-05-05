import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
class Node
{
    int vertex;
    int depth;

    public Node(int vertex, int depth)
    {
        this.vertex = vertex;
        this.depth = depth;
    }
}

public class BreadthFirstSearch
{
    public static int[] breadthFirstSearch(List<List<Integer>> edges, int vertices)
    {
        if (vertices == 0)
        {
            return new int[0];
        }

        List<List<Integer>> adjacencyList = createAdjacencyList(edges, vertices);
        int[] minimumDistance = new int[vertices];
        boolean[] isVisited = new boolean[vertices];

        for (int i = 0; i < vertices; i++)
        {
            minimumDistance[i] = Integer.MAX_VALUE;
        }

        Queue<Node> queue = new LinkedList<>();
        Node firstElement = new Node(0, 0);
        queue.add(firstElement);
        while (!queue.isEmpty())
        {
            Node node = queue.poll();
            int vertex = node.vertex;
            int distance = node.depth;
            if (minimumDistance[vertex] > distance)
            {
                minimumDistance[vertex] = distance;
            }

            if (!isVisited[vertex])
            {
                List<Integer> children = adjacencyList.get(vertex);
                for (int child : children)
                {
                    queue.add(new Node(child, distance + 1));
                }
            }
            isVisited[vertex] = true;
        }
        for (int i = 0; i < vertices; i++)
        {
            if (minimumDistance[i] == Integer.MAX_VALUE)
            {
                minimumDistance[i] = -1;
            }
        }

        return minimumDistance;
    }
    public static List<List<Integer>> createAdjacencyList(List<List<Integer>> edges, int vertices)
    {
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < vertices; i++)
        {
            adjacencyList.add(new ArrayList<>());
        }
        for (List<Integer> edge : edges)
        {
            int from = edge.get(0);
            int to = edge.get(1);
            adjacencyList.get(from).add(to);
        }
        return adjacencyList;
    }
}