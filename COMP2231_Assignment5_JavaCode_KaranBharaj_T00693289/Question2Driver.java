//******************************************************************************
// Question2Driver.java
// 
// Karan Bharaj T00693289
// COMP2231 Assignment 5: Question 2
// Graph.java is updated to complete the remaining methods, where all the previously 
// incomplete methods (that can be executed) are tested.
//******************************************************************************

import java.util.Arrays;
import jsjf.Graph;

public class Question2Driver {
    public static void main(String[] args)
	{
            System.out.println("         ======== QUESTION 2 ========\n");
            System.out.println("----- New graph is created: -----");
            Graph<String> graph = new Graph<String>();
            System.out.println("");
            
            System.out.println("----- Check to see if graph is empty (\"true\" if yes)-----");
            System.out.println(graph.isEmpty());
            System.out.println("");
            
            System.out.println("--- Four vertices added to the graph (A, B, C & D) ---");
            graph.addVertex("A");
            graph.addVertex("B");
            graph.addVertex("C");
            graph.addVertex("D");
            System.out.println("");
            
            System.out.println("----- Check to see if graph is empty (\"false\" if no)-----");
            System.out.println(graph.isEmpty());
            System.out.println("");
            
            System.out.println("--- Edges are added between \"A\" & \"B\", and \"B\" & \"C\" ---");
            graph.addEdge("A", "B");
            graph.addEdge("B", "C");
            System.out.println("");
            
            System.out.println("--- Edges are added between \"A\" & \"C\", and \"B\" & \"D\" using their indices ---");
            graph.addEdge(0, 2);
            graph.addEdge(1, 3);
            System.out.println("");
            
            System.out.println("--- Printout of the graph ---");
            System.out.println(graph);
            
            System.out.println("--- Is the graph connected? (\"true\" means yes) ---");
            System.out.println(graph.isConnected() + "\n");
            
            System.out.println("--- An edge is removed to undo graph connection ---");
            graph.removeEdge("B", "D");
            System.out.println("");
            
            System.out.println("--- Is the graph connected now? (\"false\" means no) ---");
            System.out.println(graph.isConnected() + "\n");
            
            System.out.println("--- Add an empty vertex, and then remove it using index number ---");
            graph.addVertex();
            graph.removeVertex(4);
            System.out.println("");
            
            System.out.println("--- Add two more vertices, \"E\" and \"F\" ---");
            graph.addVertex("E");
            graph.addVertex("F");
            System.out.println("");
            
            System.out.println("--- Six  new edges are added to this graph ---");
            graph.addEdge(0, 4);
            graph.addEdge(1, 3);
            graph.addEdge(2, 3);
            graph.addEdge("B", "F");
            graph.addEdge("E", "F");
            graph.addEdge("D", "F");
            System.out.println("");
            
            System.out.println("--- Printout of the graph ---");
            System.out.println(graph);
            
            System.out.println("--- Two edges are removed ---");
            graph.removeEdge("C", "D");
            graph.removeEdge(3, 5);
            System.out.println("");
            
            System.out.println("--- Printout of the graph ---");
            System.out.println(graph);
            
            System.out.println("--- Try to remove two non-existent edges ---");
            graph.removeEdge(0, 5);
            graph.removeEdge("C", "E");
            System.out.println("");
            
            System.out.println("--- Printout of the graph ---");
            System.out.println(graph);
            
            System.out.println("--- Return the vertices of the graph---");
            System.out.println(Arrays.toString(graph.getVertices()) + "\n");
            
            System.out.println("--- Return the number of vertices in the graph---");
            System.out.println((graph.size()) + "\n");

            System.out.println("--- Remove Vertex \"D\" by its index ---");
            graph.removeVertex(3);
            
            System.out.println("--- Printout of the graph ---");
            System.out.println(graph);
            
            System.out.println("--- Remove Vertex \"E\" using the element itself ---");
            graph.removeVertex("E");
            
            System.out.println("--- Printout of the graph ---");
            System.out.println(graph);
        }
}
