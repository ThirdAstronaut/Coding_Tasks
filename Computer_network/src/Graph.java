import java.util.*;

public class Graph {

    private Set<Edge> edges;
    private Map<Vertex, Set<Edge>> graphRepresentation;

    public Graph() {
        edges = new HashSet<>();
        graphRepresentation = new HashMap<>();
    }

    /**
     * Add vertex with given unique IP
     *
     * @param ip vertex value
     * @return true if addition was correct
     */
    boolean addVertex(String ip) throws IllegalArgumentException {
        boolean unique = true;
        for (Vertex vertex : graphRepresentation.keySet()) {
            if (vertex.getIp().equals(ip)) {
                unique = false;
            }
        }

        if (unique) {
            graphRepresentation.put(new Vertex(ip), new HashSet<>());
            return true;
        }

        return false;
    }

    /**
     * Add edge between two given vertices with given ping
     *
     * @param firstServer  first vertex IP value
     * @param secondServer second vertex IP value
     * @param ping         edge weight
     * @return true if addition was correct
     */
    boolean addEdge(String firstServer, String secondServer, long ping) {

        Vertex firstVertex = getVertexByIp(firstServer);
        Vertex secondVertex = getVertexByIp(secondServer);

        if (firstVertex != null && secondVertex != null && !firstServer.equals(secondServer)) {
            for (Edge edge : graphRepresentation.get(firstVertex)) {
                if (edge.getDestination().equals(secondVertex)) {
                    graphRepresentation.get((firstVertex)).remove(edge);
                }
            }
            Edge edgeToAdd = new Edge(firstVertex, secondVertex, ping);
            graphRepresentation.get((firstVertex)).add(edgeToAdd);

            for (Edge edge : graphRepresentation.get(secondVertex)) {
                if (edge.getDestination().equals(firstVertex)) {
                    graphRepresentation.get((secondVertex)).remove(edge);
                }
            }

            Edge edge2 = new Edge(edgeToAdd);
            switchSourceAndDestination(edge2);
            graphRepresentation.get((secondVertex)).add(edge2);
            edges.add(edgeToAdd);
            return true;
        }


        return false;
    }

    private void switchSourceAndDestination(Edge edge2) {
        Vertex tmp = edge2.getSource();
        edge2.setSource(edge2.getDestination());
        edge2.setDestination(tmp);
    }

    /**
     * @param ip vertex value
     * @return vertex IP and adjacent vertices IP with ping between them
     */
    AbstractMap.SimpleEntry<String, Map<String, Long>> getVertex(String ip) {
        Vertex vertex = getVertexByIp(ip);
        if (vertex != null) {
            Map<String, Long> adjacentVertices = new HashMap<>();
            for (Edge edge : graphRepresentation.get(vertex)) {
                adjacentVertices.put(edge.getDestination().getIp(), edge.getPing());
            }
            return new AbstractMap.SimpleEntry<>(ip, adjacentVertices);

        }
        return null;
    }

    /**
     * @param ping edge weight
     * @return all edges with given ping value and all connected vertices with them
     */
    Map<Edge, List<Vertex>> getEdge(long ping) {
        Map<Edge, List<Vertex>> map = new HashMap<>();
        for (Edge e : edges) {
            if (e.getPing() == ping) {
                List<Vertex> vertices = new ArrayList<>();
                vertices.add(e.getSource());
                vertices.add(e.getDestination());
                map.put(e, vertices);
            }
        }
        return map;
    }

    /**
     * Get shortest path between two given IPs.
     *
     * @param firstServer  first vertex IP value
     * @param secondServer second vertex IP value
     * @return total combined ping between two IPs and a list of servers that the request passes
     */
    AbstractMap.SimpleEntry<Long, List<Vertex>> getPath(String firstServer, String secondServer) {
        Map<Vertex, Vertex> previousVertex = new HashMap<>();
        Map<Vertex, Long> visitedPingValue = new HashMap<>();
        Queue<Vertex> vertices = new LinkedList<>();

        for (Vertex vertex : graphRepresentation.keySet()) {
            visitedPingValue.put(vertex, Long.MAX_VALUE);
        }

        Vertex firstVertex = getVertexByIp(firstServer);
        visitedPingValue.put(firstVertex, 0L);
        previousVertex.put(firstVertex, null);
        vertices.add(firstVertex);

        while (vertices.peek() != null) {

            Vertex next = vertices.poll();
            for (String neighbourIp : getVertex(next.getIp()).getValue().keySet()) {
                Vertex neighbour = getVertexByIp(neighbourIp);
                long newPing = visitedPingValue.get(next) + getVertex(next.getIp()).getValue().get(neighbour.getIp());
                if (visitedPingValue.get(neighbour) == Long.MAX_VALUE) {
                    previousVertex.put(neighbour, next);
                    visitedPingValue.put(neighbour, newPing);
                    vertices.add(neighbour);
                } else {
                    if (visitedPingValue.get(neighbour) > newPing) {
                        previousVertex.put(neighbour, next);
                        visitedPingValue.put(neighbour, newPing);
                    }
                }


            }
        }

        List<Vertex> path = new ArrayList<>();
        Stack<Vertex> tmp = new Stack<>();
        Vertex v = getVertexByIp(secondServer);
        while (previousVertex.containsKey(v) && previousVertex.get(v) != null && v != null) {
            v = previousVertex.get(v);
            tmp.push(v);
        }
        while (!tmp.empty()) {
            path.add(tmp.pop());
        }
        path.add(getVertexByIp(secondServer));

        return new AbstractMap.SimpleEntry<>(visitedPingValue.get(getVertexByIp(secondServer)), path);

    }


    private Vertex getVertexByIp(String ip) {
        for (Vertex vertex : graphRepresentation.keySet()) {
            if (vertex.getIp().equals(ip)) {
                return vertex;
            }
        }
        return null;
    }

    public Set<Edge> getEdges() {
        return edges;
    }

    public Map<Vertex, Set<Edge>> getGraphRepresentation() {
        return graphRepresentation;
    }

    public static void main(String... ar) {
        Graph graph = new Graph();
        graph.addVertex("111.111.111.111");
        graph.addVertex("222.222.222.222");
        graph.addVertex("123.123.123.123");
        graph.addVertex("103.103.103.103");
        graph.addVertex("105.105.105.105");

        graph.addEdge("111.111.111.111", "222.222.222.222", 1L);
        graph.addEdge("111.111.111.111", "103.103.103.103", 10L);
        graph.addEdge("222.222.222.222", "123.123.123.123", 2L);
        graph.addEdge("123.123.123.123", "103.103.103.103", 3L);

        System.out.println(graph.getPath("111.111.111.111", "103.103.103.103").getKey());
        System.out.println(graph.getPath("111.111.111.111", "103.103.103.103").getValue().toString());

    }

}
