package breadth_first_search;

import java.util.*;

public class BFSExample {

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

        // run BFS from vertex(peak) 0
        bfs(graph, 0);  // 0 - 1 - 2 - 3 - 4

        // run BFS from vertex 2
        bfs(graph, 2);  // 2 - 0 - 1 - 3 - 4
    }

    public static void bfs(Map<Integer, List<Integer>> graph, int start) {
        Queue<Integer> queueBFS = new LinkedList<>(); // for BFS
        Set<Integer> visited = new HashSet<>(); // for visited vertexes

        // add and mark as visited our peak
        queueBFS.add(start);
        visited.add(start);

        // while we have vertexes in our queue
        while (!queueBFS.isEmpty()) {
            int node = queueBFS.poll(); // get and remove the head of this queue
            System.out.println("Visited: " + node);

            for (int neighbor : graph.getOrDefault(node, new ArrayList<>())) { // checking neighbors
                if (!visited.contains(neighbor)) { // if not visited
                    // add to queue and mark as visited
                    queueBFS.add(neighbor);
                    visited.add(neighbor);
                }
            }
        }
    }

}
