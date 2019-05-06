import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

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
//Edge edge = new Edge();
//Vertex vertex = new Vertex();
//Vertex vertex1 = new Vertex();
        //       assertFalse(addEdge());
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
