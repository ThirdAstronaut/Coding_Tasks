import java.util.*;

public class GraphImpl implements Graph {

    private Set<Edge> edges;
    private Map<Vertex, Set<Edge>> graphRepresentation;

    public GraphImpl() {

        edges = new HashSet<>();
        graphRepresentation = new HashMap<>();

    }

    @Override
    public boolean addVertex(String ip) {
        return false;
    }

    @Override
    public boolean addEdge(String firstServer, String secondServer, long ping) {
        return false;
    }

    @Override
    public AbstractMap.SimpleEntry<String, Map<String, Long>> getVertex(String ip) {
        return null;
    }

    @Override
    public Map<Edge, List<Vertex>> getEdge(long ping) {
        return null;
    }

    @Override
    public AbstractMap.SimpleEntry<Long, List<Vertex>> getPath(String firstServer, String secondServer) {
        return null;
    }
}
