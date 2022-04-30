package dijkstra;

import java.util.*;

public class Dijkstra {
    public static Dictionary[] dijkstra(Graph g, Vertex startingVertex) {
        Dictionary<String, Integer> distances = new Hashtable<>();
        Dictionary<String, Vertex> previous = new Hashtable<>();
        PriorityQueue<QueueObject> queue = new PriorityQueue<>();

        queue.add(new QueueObject(startingVertex, 0));

        for (Vertex v : g.getVertices()) {
            if (v != startingVertex) {
                distances.put(v.getData(), Integer.MAX_VALUE);
            }
            previous.put(v.getData(), new Vertex("Null"));
        }

        distances.put(startingVertex.getData(), 0);

        run(distances, previous, queue);

        return new Dictionary[]{distances, previous};
    }

    private static void run(Dictionary<String, Integer> distances, Dictionary<String, Vertex> previous, PriorityQueue<QueueObject> queue) {
        while (!queue.isEmpty()) {
            Vertex current = queue.poll().vertex;
            current.getEdges().forEach(edge -> {
                Integer alternate = distances.get(current.getData()) + edge.getWeight();
                String neighborValue = edge.getEnd().getData();
                if (alternate < distances.get(neighborValue)) {
                    distances.put(neighborValue, alternate);
                    previous.put(neighborValue, current);
                    queue.add(new QueueObject(edge.getEnd(), distances.get(neighborValue)));
                }
            });
        }
    }

    public static void shortestPathBetween(Graph g, Vertex startingVertex, Vertex targetVertex) {
        Dictionary[] dijkstraDictionaries = dijkstra(g, startingVertex);
        var distances = dijkstraDictionaries[0];
        var previous = dijkstraDictionaries[1];
        Integer distance = (Integer) distances.get(targetVertex.getData());

        System.out.println("Shortest Path between " + startingVertex.getData() + " and " + targetVertex.getData());
        System.out.println(shortestPath(targetVertex, previous) + "\tDistance: " + distance);
    }

    public static void dijkstraResultPrinter(Dictionary[] d) {
        /* Viser den korteste distansen mellom gjeldene vertex og alle andre */
        System.out.println("Distances to:");
        for (var keys = d[0].keys(); keys.hasMoreElements(); ) {
            String nextKey = keys.nextElement().toString();
            System.out.println(nextKey + ": " + d[0].get(nextKey));
        }
        System.out.println(" ");
    }

    private static String shortestPath(Vertex targetVertex, Dictionary<Graph, Vertex> previous) {
        ArrayList<Vertex> path = new ArrayList<>();
        Vertex v = targetVertex;
        while (!Objects.equals(v.getData(), "Null")) {
            path.add(0, v);
            v = previous.get(v.getData());
        }
        StringBuilder shortestPath = new StringBuilder();
        path.forEach(vertex -> {
            shortestPath.append(vertex.getData());
            shortestPath.append("-");
        });

        shortestPath.setLength(shortestPath.length() - 1);
        return "Path: " + "[" + shortestPath + "] ";
    }
}

