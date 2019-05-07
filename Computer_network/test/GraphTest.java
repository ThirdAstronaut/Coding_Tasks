import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class GraphTest {

    @Test(expected = IllegalArgumentException.class)
    public void addVertexEmptyIp() {
        Graph graph = new Graph();
        graph.addVertex("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void addVertexNullIp() {
        Graph graph = new Graph();
        graph.addVertex(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addVertexWrongValueIp() {
        Graph graph = new Graph();
        graph.addVertex("256.256.256.256");
    }

    @Test
    public void addVertex() {
        Graph graph = new Graph();
        assertEquals(0, graph.getGraphRepresentation().size());
        String correctIP = "111.111.111.111";
        String correctIP2 = "222.222.222.222";
        List<String> ipAddresses = new ArrayList<>();
        ipAddresses.add(correctIP);
        ipAddresses.add(correctIP2);
        graph.addVertex(correctIP);
        assertFalse(graph.addVertex(correctIP)); //not unique IP

        graph.addVertex(correctIP2);

        assertEquals(2, graph.getGraphRepresentation().size());
        int i = 0;
        for (Vertex v : graph.getGraphRepresentation().keySet()) {
            assertEquals(v.getIp(), ipAddresses.get(i));
            i++;
        }

    }

    @Test
    public void addEdge() {
        Graph graph = new Graph();
        Vertex v1 = new Vertex("111.111.111.111");
        Vertex v2 = new Vertex("222.222.222.222");
        String emptyString = "";
        graph.getGraphRepresentation().put(v1, new HashSet<>());
        graph.getGraphRepresentation().put(v2, new HashSet<>());
        assertTrue(graph.addEdge(v1.getIp(), v2.getIp(), 10L));
        assertTrue(graph.addEdge(v1.getIp(), v2.getIp(), 10L));
        assertFalse(graph.addEdge(v1.getIp(), emptyString, 10L));
        assertFalse(graph.addEdge(v1.getIp(), v1.getIp(), 10L));
    }



    @Test
    public void getVertex() {
        Graph graph = new Graph();
        assertEquals(0, graph.getEdge(0).size());
    }

    @Test
    public void getEdge() {
        Graph graph = new Graph();
        assertEquals(0, graph.getEdge(0).size());
    }

    @Test
    public void getPath() {

    }
}
