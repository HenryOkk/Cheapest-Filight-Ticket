import static org.junit.jupiter.api.Assertions.*;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.Test;

class GraphTest {
  /**
   * Test whether inserting the city to the vertex correctly or not
   */
  @SuppressWarnings({"rawtypes", "unchecked"})
  @Test
  public void testInsertingVertex() {
    Graph graph = new Graph();
    graph.insertVertex("Chicago");
    graph.insertVertex("Minneapolis");
    graph.insertVertex("Detroit");

    assertTrue(graph.containsVertex("Chicago"));
    assertTrue(graph.containsVertex("Minneapolis"));
    assertTrue(graph.containsVertex("Detroit"));
  }

  /**
   * Test whether removing the vertex function works correctly or not
   */
  @SuppressWarnings({"unchecked", "rawtypes"})
  @Test
  public void testRemovingVertex() {
    Graph graph = new Graph();
    graph.insertVertex("Chicago");
    graph.insertVertex("Minneapolis");
    graph.insertVertex("Detroit");
    graph.removeVertex("Chicago");
    assertFalse(graph.containsVertex("Chicago"));

  }

  /**
   * Test the weight between two vertices is correct or not. If there is no directy connected edge
   * between two vertices throw NoSuchElementException
   */
  @SuppressWarnings({"rawtypes", "unchecked", "static-access"})
  @Test
  public void testGetWeight() {
    Graph graph = new Graph();
    graph = graph.dataSave();
    assertEquals(150, graph.getWeight("Chicago", "Minneapolis"));
    try {
      assertEquals(150, graph.getWeight("Chicago", "Austin"));
    } catch (NoSuchElementException e) {
      System.out.println("No edge between these vertices");
    }
  }

  /**
   * Test data(vertex and edge)from text file is correctly inserted.
   */
  @Test
  public void testEdgeAndVertexCount() {
    Graph graph = new Graph();
    graph = graph.dataSave();
    assertEquals(12, graph.getVertexCount());
    assertEquals(62, graph.getEdgeCount());
  }

  /**
   * Check whether the price is the cheapest or not
   * 
   * @throws FileNotFoundException
   */
  @SuppressWarnings({"static-access", "unchecked", "rawtypes"})
  @Test
  public void testCheapest() throws FileNotFoundException {
    Graph graph = new Graph();
    graph = graph.dataSave();
    assertEquals(500, graph.getPathCost("Chicago", "New York"));
    assertEquals(640, graph.getPathCost("Los Angeles", "Dallas"));
  }

}
