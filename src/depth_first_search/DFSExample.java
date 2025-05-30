package depth_first_search;

import java.util.*;

public class DFSExample {

    //             0
    //            / \
    //           1   2
    //          / \
    //         3   4


    public static void main(String[] args) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        graph.put(0, Arrays.asList(1, 2));      // vertex 0 connected with 1 and 2
        graph.put(1, Arrays.asList(0, 3, 4));   // vertex 1 connected with 0, 3, 4
        graph.put(2, List.of(0));           // vertex 2 connected with 0
        graph.put(3, List.of(1));           // vertex 3 with 1
        graph.put(4, List.of(1));           // vertex 4 with 1

        // required Set for recursion and proper DFS operation
        Set<Integer> visitedVertexes = new HashSet<>();

        // run search from vertex 0      output: 0 - 1 - 3 - 4 - 2
//        dfs(graph,0, visitedVertexes); // visitedVertexes - one for all cycles in recursion

        // run search from vertex 2      output: 2 - 0 - 1 - 3 - 4
        dfs(graph,2, visitedVertexes); // visitedVertexes - one for all cycles in recursion
    }

    private static void dfs(Map<Integer, List<Integer>> graph, int node, Set<Integer> visitedVertexes) {
        if (visitedVertexes.contains(node)) return; // if already visited - do nothing

        visitedVertexes.add(node); // mark as visited
        System.out.println("Visited: " + node);

        // checking all neighbors and running dfs (current method) recursively
        for (int neighbor : graph.getOrDefault(node, new ArrayList<>())) {
            dfs(graph, neighbor, visitedVertexes);
        }
    }
}
