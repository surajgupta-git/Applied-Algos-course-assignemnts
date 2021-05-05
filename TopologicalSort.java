import java.util.*;
public class TopologicalSort {
    public static List<Integer> solveByBFS(int[] incLinkCounts, List<List<Integer>> adjs){
        //int[] order = new int[incLinkCounts.length];
        List<Integer> order = new ArrayList<>(incLinkCounts.length);
        Queue<Integer> toVisit = new ArrayDeque<>();
        for (int i = 0; i < incLinkCounts.length; i++) {
            if (incLinkCounts[i] == 0) toVisit.offer(i);
        }
        int visited = 0;
        while (!toVisit.isEmpty()) {
            int from = toVisit.poll();
            //order[visited++]=from;
            order.add(visited++,from);
            for (int to : adjs.get(from)) {
                incLinkCounts[to]--;
                if (incLinkCounts[to] == 0) toVisit.offer(to);
            }
        }
        List<Integer> temp = new ArrayList<>(0);
        return visited == incLinkCounts.length ? order : temp;
    }

    public List<Integer> topoSort(List<List<Integer>> pre_requisites, int total_courses)
    {
        int[][] prerequisites;
        prerequisites = pre_requisites.stream().map(x->x.toArray(new Integer[x.size()])).toArray(int[][]::new);
        int[] incLinkCounts = new int[total_courses];
        List<List<Integer>> adjs = new ArrayList<>(total_courses);
        int n = incLinkCounts.length;
        while (n-- > 0) adjs.add(new ArrayList<>());
        for (int[] edge:prerequisites) {
            incLinkCounts[edge[0]]++;
            adjs.get(edge[1]).add(edge[0]);
        }

        return solveByBFS(incLinkCounts,adjs);
    }

}




