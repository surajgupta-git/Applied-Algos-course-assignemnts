import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Bipartiteness {
    public static int bipartite(List<List<Integer>> edges, int vertices) {
        List<List<Integer>> Adj_list = new ArrayList<List<Integer>>();
        for (int i = 0; i < vertices; i++) {
            List<Integer> l = new ArrayList<Integer>();
            Adj_list.add(l);
        }
        int color[]= new int[vertices];
        for (int i = 0; i < edges.size(); i++) {
            var a = edges.get(i);
            Adj_list.get(a.get(0)).add(a.get(1));
            Adj_list.get(a.get(1)).add(a.get(0));
        }
        for (int j=0;j<vertices;j++)
        {
            color[j]=-1;
        }
        int k=0;
        LinkedList<Integer> q = new LinkedList<Integer>();
        while(k<vertices) {
            if(color[k]==-1) {
                color[k] = 1;
                q.add(k);
                while (!q.isEmpty()) {
                    int u = q.poll();
                    for (int v : Adj_list.get(u)) {
                        if ( color[v] == -1) {
                            color[v] = 1 - color[u];
                            q.add(v);
                        } else if (color[v] == color[u]) {
                            return -1;
                        }
                    }
                }
            }
            k++;
        }
        return 1;
    }

//    public static void main(String[] args) {
//        int vertices = 20;
//        // [u, v, w]
////        Integer[][] ed = {{0, 7}};
////        Integer[][] ed = {{5, 14}, {10, 19}, {14,10},{14,19}};
////        Integer[][] ed = {{0, 6}, {1, 6}, {1,2}, {5, 6}, {3, 2}, {3, 4}};
////        Integer[][] ed = {{4, 3}, {0, 6}, {2,3}, {2, 6}, {1, 6}};
//
//        List<List<Integer>> edges = new ArrayList<>();
//        for (Integer[] arr : ed) edges.add(new ArrayList(Arrays.asList(arr)));
//        int k=bipartite(edges,vertices);
//        System.out.println(k);
//    }
}