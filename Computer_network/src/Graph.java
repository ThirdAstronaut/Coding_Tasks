import java.util.AbstractMap;
import java.util.List;
import java.util.Map;

public interface Graph {

    /**
     * Add vertex with given unique IP
     *
     * @param ip vertex value
     * @return true if addition was correct
     */
    boolean addVertex(String ip);

    /**
     * Add edge between two given vertices with given ping
     *
     * @param firstServer  first vertex IP value
     * @param secondServer second vertex IP value
     * @param ping         edge weight
     * @return true if addition was correct
     */
    boolean addEdge(String firstServer, String secondServer, long ping);

    /**
     * @param ip vertex value
     * @return vertex IP and adjacent vertices IP with ping between them
     */
    AbstractMap.SimpleEntry<String, Map<String, Long>> getVertex(String ip);

    /**
     * @param ping edge weight
     * @return all edges with given ping value and all connected vertices with them
     */
    Map<Edge, List<Vertex>> getEdge(long ping);

    /**
     * Get shortest path between two given IPs.
     *
     * @param firstServer  first vertex IP value
     * @param secondServer second vertex IP value
     * @return total combined ping between two IPs and a list of servers that the request passes
     */
    AbstractMap.SimpleEntry<Long, List<Vertex>> getPath(String firstServer, String secondServer);

}
