package Test;

import src.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.PrintWriter;
import java.util.Random;

public class ComparisonAllPaths {
    public void graphGenerator(int nodes, int edges){
        Random random = new Random();
        try {
            PrintWriter writer = new PrintWriter("temp.txt", "UTF-8");
            writer.println(nodes + " " + edges);
            int source;
            int destination;
            int weight;
            for (int i = 0; i < edges; i++) {
                source = random.nextInt(nodes);
                destination = random.nextInt(nodes);
                weight = random.nextInt(1000000);
                writer.println(source + " " + destination + " " + weight);
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }
                                                        /*10 nodes*/
    /*===============================================================================================================*/
    @Test
    public void test_10_10() throws IOException {
        int[][] parents = new int[10][10];
        int[][] costs = new int[10][10];
        
        long start,end,avg = 0;
        graphGenerator(10, 10);
        for(int i=0;i<10;i++){            
            start = System.nanoTime();
            Graph graph = new Graph("C:\\Users\\DELL\\lab 2 DSA\\Shortest_Path_Algorithms\\temp.txt");
     
            for (int j = 0; j < graph.Size(); j++) {
                int[] singleParents = new int[graph.Size()];
                int[] singleCosts = new int[graph.Size()];
                graph.BellmanFord(graph.getVertices().get(i), singleParents, singleCosts);
                
                for (int k = 0; k < graph.Size(); k++) {
                    parents[j][k] = singleParents[k];
                    costs[j][k] = singleCosts[k];
                }
            }           
            end = System.nanoTime();
            avg += (end-start)/1000;
        }
        System.out.println("Average time for 10 nodes and 10 edges by Bellman Ford: " + avg/10 + " microseconds");
        avg = 0;
        for(int i=0;i<10;i++){            
            start = System.nanoTime();
            Graph graph = new Graph("C:\\Users\\DELL\\lab 2 DSA\\Shortest_Path_Algorithms\\temp.txt");
     
            for (int j = 0; j < graph.Size(); j++) {
                int[] singleParents = new int[graph.Size()];
                int[] singleCosts = new int[graph.Size()];
                graph.Dijekstra(graph.getVertices().get(i), singleParents, singleCosts);
                
                for (int k = 0; k < graph.Size(); k++) {
                    parents[j][k] = singleParents[k];
                    costs[j][k] = singleCosts[k];
                }
            }           
            end = System.nanoTime();
            avg += (end-start)/1000;
        }   
        System.out.println("Average time for 10 nodes and 10 edges by Dijkstra: " + avg/10 + " microseconds");
        avg = 0;
        for(int i=0;i<10;i++){            
            start = System.nanoTime();
            Graph graph = new Graph("C:\\Users\\DELL\\lab 2 DSA\\Shortest_Path_Algorithms\\temp.txt");     
            graph.FloydWarshall(parents, costs);       
            end = System.nanoTime();
            avg += (end-start)/1000;
        }
        System.out.println("Average time for 10 nodes and 10 edges by Floyed Warshall: " + avg/10 + " microseconds");
    }

    @Test
    public void test_10_100() throws IOException {
        int[][] parents = new int[10][10];
        int[][] costs = new int[10][10];
        
        long start,end,avg = 0;
        graphGenerator(10, 100);
        for(int i=0;i<10;i++){            
            start = System.nanoTime();
            Graph graph = new Graph("C:\\Users\\DELL\\lab 2 DSA\\Shortest_Path_Algorithms\\temp.txt");
     
            for (int j = 0; j < graph.Size(); j++) {
                int[] singleParents = new int[graph.Size()];
                int[] singleCosts = new int[graph.Size()];
                graph.BellmanFord(graph.getVertices().get(i), singleParents, singleCosts);
                
                for (int k = 0; k < graph.Size(); k++) {
                    parents[j][k] = singleParents[k];
                    costs[j][k] = singleCosts[k];
                }
            }           
            end = System.nanoTime();
            avg += (end-start)/1000;
        }
        System.out.println("Average time for 10 nodes and 100 edges by Bellman Ford: " + avg/10 + " microseconds");
        avg = 0;
        for(int i=0;i<10;i++){            
            start = System.nanoTime();
            Graph graph = new Graph("C:\\Users\\DELL\\lab 2 DSA\\Shortest_Path_Algorithms\\temp.txt");
     
            for (int j = 0; j < graph.Size(); j++) {
                int[] singleParents = new int[graph.Size()];
                int[] singleCosts = new int[graph.Size()];
                graph.Dijekstra(graph.getVertices().get(i), singleParents, singleCosts);
                
                for (int k = 0; k < graph.Size(); k++) {
                    parents[j][k] = singleParents[k];
                    costs[j][k] = singleCosts[k];
                }
            }           
            end = System.nanoTime();
            avg += (end-start)/1000;
        }   
        System.out.println("Average time for 10 nodes and 100 edges by Dijkstra: " + avg/10 + " microseconds");
        avg = 0;
        for(int i=0;i<10;i++){            
            start = System.nanoTime();
            Graph graph = new Graph("C:\\Users\\DELL\\lab 2 DSA\\Shortest_Path_Algorithms\\temp.txt");     
            graph.FloydWarshall(parents, costs);       
            end = System.nanoTime();
            avg += (end-start)/1000;
        }
        System.out.println("Average time for 10 nodes and 100 edges by Floyed Warshall: " + avg/10 + " microseconds");
    }
    @Test
    public void test_10_1000() throws IOException {
       int[][] parents = new int[10][10];
        int[][] costs = new int[10][10];
        
        long start,end,avg = 0;
        graphGenerator(10, 1000);
        for(int i=0;i<10;i++){            
            start = System.nanoTime();
            Graph graph = new Graph("C:\\Users\\DELL\\lab 2 DSA\\Shortest_Path_Algorithms\\temp.txt");
     
            for (int j = 0; j < graph.Size(); j++) {
                int[] singleParents = new int[graph.Size()];
                int[] singleCosts = new int[graph.Size()];
                graph.BellmanFord(graph.getVertices().get(i), singleParents, singleCosts);
                
                for (int k = 0; k < graph.Size(); k++) {
                    parents[j][k] = singleParents[k];
                    costs[j][k] = singleCosts[k];
                }
            }           
            end = System.nanoTime();
            avg += (end-start)/1000;
        }
        System.out.println("Average time for 10 nodes and 1000 edges by Bellman Ford: " + avg/10 + " microseconds");
        avg = 0;
        for(int i=0;i<10;i++){            
            start = System.nanoTime();
            Graph graph = new Graph("C:\\Users\\DELL\\lab 2 DSA\\Shortest_Path_Algorithms\\temp.txt");
     
            for (int j = 0; j < graph.Size(); j++) {
                int[] singleParents = new int[graph.Size()];
                int[] singleCosts = new int[graph.Size()];
                graph.Dijekstra(graph.getVertices().get(i), singleParents, singleCosts);
                
                for (int k = 0; k < graph.Size(); k++) {
                    parents[j][k] = singleParents[k];
                    costs[j][k] = singleCosts[k];
                }
            }           
            end = System.nanoTime();
            avg += (end-start)/1000;
        }   
        System.out.println("Average time for 10 nodes and 1000 edges by Dijkstra: " + avg/10 + " microseconds");
        avg = 0;
        for(int i=0;i<10;i++){            
            start = System.nanoTime();
            Graph graph = new Graph("C:\\Users\\DELL\\lab 2 DSA\\Shortest_Path_Algorithms\\temp.txt");     
            graph.FloydWarshall(parents, costs);       
            end = System.nanoTime();
            avg += (end-start)/1000;
        }
        System.out.println("Average time for 10 nodes and 1000 edges by Floyed Warshall: " + avg/10 + " microseconds");
    }
    @Test
    public void test_10_10000() throws IOException {
        int[][] parents = new int[10][10];
        int[][] costs = new int[10][10];
        
        long start,end,avg = 0;
        graphGenerator(10, 10000);
        for(int i=0;i<10;i++){            
            start = System.nanoTime();
            Graph graph = new Graph("C:\\Users\\DELL\\lab 2 DSA\\Shortest_Path_Algorithms\\temp.txt");
     
            for (int j = 0; j < graph.Size(); j++) {
                int[] singleParents = new int[graph.Size()];
                int[] singleCosts = new int[graph.Size()];
                graph.BellmanFord(graph.getVertices().get(i), singleParents, singleCosts);
                
                for (int k = 0; k < graph.Size(); k++) {
                    parents[j][k] = singleParents[k];
                    costs[j][k] = singleCosts[k];
                }
            }           
            end = System.nanoTime();
            avg += (end-start)/1000;
        }
        System.out.println("Average time for 10 nodes and 10000 edges by Bellman Ford: " + avg/10 + " microseconds");
        avg = 0;
        for(int i=0;i<10;i++){            
            start = System.nanoTime();
            Graph graph = new Graph("C:\\Users\\DELL\\lab 2 DSA\\Shortest_Path_Algorithms\\temp.txt");
     
            for (int j = 0; j < graph.Size(); j++) {
                int[] singleParents = new int[graph.Size()];
                int[] singleCosts = new int[graph.Size()];
                graph.Dijekstra(graph.getVertices().get(i), singleParents, singleCosts);
                
                for (int k = 0; k < graph.Size(); k++) {
                    parents[j][k] = singleParents[k];
                    costs[j][k] = singleCosts[k];
                }
            }           
            end = System.nanoTime();
            avg += (end-start)/1000;
        }   
        System.out.println("Average time for 10 nodes and 10000 edges by Dijkstra: " + avg/10 + " microseconds");
        avg = 0;
        for(int i=0;i<10;i++){            
            start = System.nanoTime();
            Graph graph = new Graph("C:\\Users\\DELL\\lab 2 DSA\\Shortest_Path_Algorithms\\temp.txt");     
            graph.FloydWarshall(parents, costs);       
            end = System.nanoTime();
            avg += (end-start)/1000;
        }
        System.out.println("Average time for 10 nodes and 10000 edges by Floyed Warshall: " + avg/10 + " microseconds");
    }
    @Test
    public void test_10_100000() throws IOException {
        int[][] parents = new int[10][10];
        int[][] costs = new int[10][10];
        
        long start,end,avg = 0;
        graphGenerator(10, 100000);
        for(int i=0;i<10;i++){            
            start = System.nanoTime();
            Graph graph = new Graph("C:\\Users\\DELL\\lab 2 DSA\\Shortest_Path_Algorithms\\temp.txt");
     
            for (int j = 0; j < graph.Size(); j++) {
                int[] singleParents = new int[graph.Size()];
                int[] singleCosts = new int[graph.Size()];
                graph.BellmanFord(graph.getVertices().get(i), singleParents, singleCosts);
                
                for (int k = 0; k < graph.Size(); k++) {
                    parents[j][k] = singleParents[k];
                    costs[j][k] = singleCosts[k];
                }
            }           
            end = System.nanoTime();
            avg += (end-start)/1000;
        }
        System.out.println("Average time for 10 nodes and 100000 edges by Bellman Ford: " + avg/10 + " microseconds");
        avg = 0;
        for(int i=0;i<10;i++){            
            start = System.nanoTime();
            Graph graph = new Graph("C:\\Users\\DELL\\lab 2 DSA\\Shortest_Path_Algorithms\\temp.txt");
     
            for (int j = 0; j < graph.Size(); j++) {
                int[] singleParents = new int[graph.Size()];
                int[] singleCosts = new int[graph.Size()];
                graph.Dijekstra(graph.getVertices().get(i), singleParents, singleCosts);
                
                for (int k = 0; k < graph.Size(); k++) {
                    parents[j][k] = singleParents[k];
                    costs[j][k] = singleCosts[k];
                }
            }           
            end = System.nanoTime();
            avg += (end-start)/1000;
        }   
        System.out.println("Average time for 10 nodes and 100000 edges by Dijkstra: " + avg/10 + " microseconds");
        avg = 0;
        for(int i=0;i<10;i++){            
            start = System.nanoTime();
            Graph graph = new Graph("C:\\Users\\DELL\\lab 2 DSA\\Shortest_Path_Algorithms\\temp.txt");     
            graph.FloydWarshall(parents, costs);       
            end = System.nanoTime();
            avg += (end-start)/1000;
        }
        System.out.println("Average time for 10 nodes and 100000 edges by Floyed Warshall: " + avg/10 + " microseconds");
    }


    
                                                        /*100 nodes*/
    /*===============================================================================================================*/
    @Test
    public void test_100_10() throws IOException {
        int[][] parents = new int[100][100];
        int[][] costs = new int[100][100];
        
        long start,end,avg = 0;
        graphGenerator(100, 10);
        for(int i=0;i<10;i++){            
            start = System.nanoTime();
            Graph graph = new Graph("C:\\Users\\DELL\\lab 2 DSA\\Shortest_Path_Algorithms\\temp.txt");
     
            for (int j = 0; j < graph.Size(); j++) {
                int[] singleParents = new int[graph.Size()];
                int[] singleCosts = new int[graph.Size()];
                graph.BellmanFord(graph.getVertices().get(i), singleParents, singleCosts);
                
                for (int k = 0; k < graph.Size(); k++) {
                    parents[j][k] = singleParents[k];
                    costs[j][k] = singleCosts[k];
                }
            }           
            end = System.nanoTime();
            avg += (end-start)/1000;
        }
        System.out.println("Average time for 100 nodes and 10 edges by Bellman Ford: " + avg/10 + " microseconds");
        avg = 0;
        for(int i=0;i<10;i++){            
            start = System.nanoTime();
            Graph graph = new Graph("C:\\Users\\DELL\\lab 2 DSA\\Shortest_Path_Algorithms\\temp.txt");
     
            for (int j = 0; j < graph.Size(); j++) {
                int[] singleParents = new int[graph.Size()];
                int[] singleCosts = new int[graph.Size()];
                graph.Dijekstra(graph.getVertices().get(i), singleParents, singleCosts);
                
                for (int k = 0; k < graph.Size(); k++) {
                    parents[j][k] = singleParents[k];
                    costs[j][k] = singleCosts[k];
                }
            }           
            end = System.nanoTime();
            avg += (end-start)/1000;
        }   
        System.out.println("Average time for 100 nodes and 10 edges by Dijkstra: " + avg/10 + " microseconds");
        avg = 0;
        for(int i=0;i<10;i++){            
            start = System.nanoTime();
            Graph graph = new Graph("C:\\Users\\DELL\\lab 2 DSA\\Shortest_Path_Algorithms\\temp.txt");     
            graph.FloydWarshall(parents, costs);       
            end = System.nanoTime();
            avg += (end-start)/1000;
        }
        System.out.println("Average time for 100 nodes and 10 edges by Floyed Warshall: " + avg/10 + " microseconds");
    }
    @Test
    public void test_100_100() throws IOException {
        int[][] parents = new int[100][100];
        int[][] costs = new int[100][100];
        
        long start,end,avg = 0;
        graphGenerator(100, 100);
        for(int i=0;i<10;i++){            
            start = System.nanoTime();
            Graph graph = new Graph("C:\\Users\\DELL\\lab 2 DSA\\Shortest_Path_Algorithms\\temp.txt");
     
            for (int j = 0; j < graph.Size(); j++) {
                int[] singleParents = new int[graph.Size()];
                int[] singleCosts = new int[graph.Size()];
                graph.BellmanFord(graph.getVertices().get(i), singleParents, singleCosts);
                
                for (int k = 0; k < graph.Size(); k++) {
                    parents[j][k] = singleParents[k];
                    costs[j][k] = singleCosts[k];
                }
            }           
            end = System.nanoTime();
            avg += (end-start)/1000;
        }
        System.out.println("Average time for 100 nodes and 100 edges by Bellman Ford: " + avg/10 + " microseconds");
        avg = 0;
        for(int i=0;i<10;i++){            
            start = System.nanoTime();
            Graph graph = new Graph("C:\\Users\\DELL\\lab 2 DSA\\Shortest_Path_Algorithms\\temp.txt");
     
            for (int j = 0; j < graph.Size(); j++) {
                int[] singleParents = new int[graph.Size()];
                int[] singleCosts = new int[graph.Size()];
                graph.Dijekstra(graph.getVertices().get(i), singleParents, singleCosts);
                
                for (int k = 0; k < graph.Size(); k++) {
                    parents[j][k] = singleParents[k];
                    costs[j][k] = singleCosts[k];
                }
            }           
            end = System.nanoTime();
            avg += (end-start)/1000;
        }   
        System.out.println("Average time for 100 nodes and 100 edges by Dijkstra: " + avg/10 + " microseconds");
        avg = 0;
        for(int i=0;i<10;i++){            
            start = System.nanoTime();
            Graph graph = new Graph("C:\\Users\\DELL\\lab 2 DSA\\Shortest_Path_Algorithms\\temp.txt");     
            graph.FloydWarshall(parents, costs);       
            end = System.nanoTime();
            avg += (end-start)/1000;
        }
        System.out.println("Average time for 100 nodes and 100 edges by Floyed Warshall: " + avg/10 + " microseconds");
    }
    @Test
    public void test_100_1000() throws IOException {
        int[][] parents = new int[100][100];
        int[][] costs = new int[100][100];
        
        long start,end,avg = 0;
        graphGenerator(100, 1000);
        for(int i=0;i<10;i++){            
            start = System.nanoTime();
            Graph graph = new Graph("C:\\Users\\DELL\\lab 2 DSA\\Shortest_Path_Algorithms\\temp.txt");
     
            for (int j = 0; j < graph.Size(); j++) {
                int[] singleParents = new int[graph.Size()];
                int[] singleCosts = new int[graph.Size()];
                graph.BellmanFord(graph.getVertices().get(i), singleParents, singleCosts);
                
                for (int k = 0; k < graph.Size(); k++) {
                    parents[j][k] = singleParents[k];
                    costs[j][k] = singleCosts[k];
                }
            }           
            end = System.nanoTime();
            avg += (end-start)/1000;
        }
        System.out.println("Average time for 100 nodes and 1000 edges by Bellman Ford: " + avg/10 + " microseconds");
        avg = 0;
        for(int i=0;i<10;i++){            
            start = System.nanoTime();
            Graph graph = new Graph("C:\\Users\\DELL\\lab 2 DSA\\Shortest_Path_Algorithms\\temp.txt");
     
            for (int j = 0; j < graph.Size(); j++) {
                int[] singleParents = new int[graph.Size()];
                int[] singleCosts = new int[graph.Size()];
                graph.Dijekstra(graph.getVertices().get(i), singleParents, singleCosts);
                
                for (int k = 0; k < graph.Size(); k++) {
                    parents[j][k] = singleParents[k];
                    costs[j][k] = singleCosts[k];
                }
            }           
            end = System.nanoTime();
            avg += (end-start)/1000;
        }   
        System.out.println("Average time for 100 nodes and 1000 edges by Dijkstra: " + avg/10 + " microseconds");
        avg = 0;
        for(int i=0;i<10;i++){            
            start = System.nanoTime();
            Graph graph = new Graph("C:\\Users\\DELL\\lab 2 DSA\\Shortest_Path_Algorithms\\temp.txt");     
            graph.FloydWarshall(parents, costs);       
            end = System.nanoTime();
            avg += (end-start)/1000;
        }
        System.out.println("Average time for 100 nodes and 1000 edges by Floyed Warshall: " + avg/10 + " microseconds");
    }
    @Test
    public void test_100_10000() throws IOException {
        int[][] parents = new int[100][100];
        int[][] costs = new int[100][100];
        
        long start,end,avg = 0;
        graphGenerator(100, 10000);
        for(int i=0;i<10;i++){            
            start = System.nanoTime();
            Graph graph = new Graph("C:\\Users\\DELL\\lab 2 DSA\\Shortest_Path_Algorithms\\temp.txt");
     
            for (int j = 0; j < graph.Size(); j++) {
                int[] singleParents = new int[graph.Size()];
                int[] singleCosts = new int[graph.Size()];
                graph.BellmanFord(graph.getVertices().get(i), singleParents, singleCosts);
                
                for (int k = 0; k < graph.Size(); k++) {
                    parents[j][k] = singleParents[k];
                    costs[j][k] = singleCosts[k];
                }
            }           
            end = System.nanoTime();
            avg += (end-start)/1000;
        }
        System.out.println("Average time for 100 nodes and 10000 edges by Bellman Ford: " + avg/10 + " microseconds");
        avg = 0;
        for(int i=0;i<10;i++){            
            start = System.nanoTime();
            Graph graph = new Graph("C:\\Users\\DELL\\lab 2 DSA\\Shortest_Path_Algorithms\\temp.txt");
     
            for (int j = 0; j < graph.Size(); j++) {
                int[] singleParents = new int[graph.Size()];
                int[] singleCosts = new int[graph.Size()];
                graph.Dijekstra(graph.getVertices().get(i), singleParents, singleCosts);
                
                for (int k = 0; k < graph.Size(); k++) {
                    parents[j][k] = singleParents[k];
                    costs[j][k] = singleCosts[k];
                }
            }           
            end = System.nanoTime();
            avg += (end-start)/1000;
        }   
        System.out.println("Average time for 100 nodes and 10000 edges by Dijkstra: " + avg/10 + " microseconds");
        avg = 0;
        for(int i=0;i<10;i++){            
            start = System.nanoTime();
            Graph graph = new Graph("C:\\Users\\DELL\\lab 2 DSA\\Shortest_Path_Algorithms\\temp.txt");     
            graph.FloydWarshall(parents, costs);       
            end = System.nanoTime();
            avg += (end-start)/1000;
        }
        System.out.println("Average time for 100 nodes and 10000 edges by Floyed Warshall: " + avg/10 + " microseconds");
    }
    @Test
    public void test_100_100000() throws IOException {
        int[][] parents = new int[100][100];
        int[][] costs = new int[100][100];
        
        long start,end,avg = 0;
        graphGenerator(100, 100000);
        for(int i=0;i<10;i++){            
            start = System.nanoTime();
            Graph graph = new Graph("C:\\Users\\DELL\\lab 2 DSA\\Shortest_Path_Algorithms\\temp.txt");
     
            for (int j = 0; j < graph.Size(); j++) {
                int[] singleParents = new int[graph.Size()];
                int[] singleCosts = new int[graph.Size()];
                graph.BellmanFord(graph.getVertices().get(i), singleParents, singleCosts);
                
                for (int k = 0; k < graph.Size(); k++) {
                    parents[j][k] = singleParents[k];
                    costs[j][k] = singleCosts[k];
                }
            }           
            end = System.nanoTime();
            avg += (end-start)/1000;
        }
        System.out.println("Average time for 100 nodes and 100000 edges by Bellman Ford: " + avg/10 + " microseconds");
        avg = 0;
        for(int i=0;i<10;i++){            
            start = System.nanoTime();
            Graph graph = new Graph("C:\\Users\\DELL\\lab 2 DSA\\Shortest_Path_Algorithms\\temp.txt");
     
            for (int j = 0; j < graph.Size(); j++) {
                int[] singleParents = new int[graph.Size()];
                int[] singleCosts = new int[graph.Size()];
                graph.Dijekstra(graph.getVertices().get(i), singleParents, singleCosts);
                
                for (int k = 0; k < graph.Size(); k++) {
                    parents[j][k] = singleParents[k];
                    costs[j][k] = singleCosts[k];
                }
            }           
            end = System.nanoTime();
            avg += (end-start)/1000;
        }   
        System.out.println("Average time for 100 nodes and 100000 edges by Dijkstra: " + avg/10 + " microseconds");
        avg = 0;
        for(int i=0;i<10;i++){            
            start = System.nanoTime();
            Graph graph = new Graph("C:\\Users\\DELL\\lab 2 DSA\\Shortest_Path_Algorithms\\temp.txt");     
            graph.FloydWarshall(parents, costs);       
            end = System.nanoTime();
            avg += (end-start)/1000;
        }
        System.out.println("Average time for 100 nodes and 10000 edges by Floyed Warshall: " + avg/10 + " microseconds");
    }

                                                    /*1,000 nodes*/
    /*===============================================================================================================*/
    @Test
    public void test_1000_100() throws IOException {
        int[][] parents = new int[1000][1000];
        int[][] costs = new int[1000][1000];
        
        long start,end,avg = 0;
        graphGenerator(1000, 100);
        for(int i=0;i<10;i++){            
            start = System.nanoTime();
            Graph graph = new Graph("C:\\Users\\DELL\\lab 2 DSA\\Shortest_Path_Algorithms\\temp.txt");
     
            for (int j = 0; j < graph.Size(); j++) {
                int[] singleParents = new int[graph.Size()];
                int[] singleCosts = new int[graph.Size()];
                graph.BellmanFord(graph.getVertices().get(i), singleParents, singleCosts);
                
                for (int k = 0; k < graph.Size(); k++) {
                    parents[j][k] = singleParents[k];
                    costs[j][k] = singleCosts[k];
                }
            }           
            end = System.nanoTime();
            avg += (end-start)/1000;
        }
        System.out.println("Average time for 1000 nodes and 100 edges by Bellman Ford: " + avg/10 + " microseconds");
        avg = 0;
        for(int i=0;i<10;i++){            
            start = System.nanoTime();
            Graph graph = new Graph("C:\\Users\\DELL\\lab 2 DSA\\Shortest_Path_Algorithms\\temp.txt");
     
            for (int j = 0; j < graph.Size(); j++) {
                int[] singleParents = new int[graph.Size()];
                int[] singleCosts = new int[graph.Size()];
                graph.Dijekstra(graph.getVertices().get(i), singleParents, singleCosts);
                
                for (int k = 0; k < graph.Size(); k++) {
                    parents[j][k] = singleParents[k];
                    costs[j][k] = singleCosts[k];
                }
            }           
            end = System.nanoTime();
            avg += (end-start)/1000;
        }   
        System.out.println("Average time for 1000 nodes and 100 edges by Dijkstra: " + avg/10 + " microseconds");
        avg = 0;
        for(int i=0;i<10;i++){            
            start = System.nanoTime();
            Graph graph = new Graph("C:\\Users\\DELL\\lab 2 DSA\\Shortest_Path_Algorithms\\temp.txt");     
            graph.FloydWarshall(parents, costs);       
            end = System.nanoTime();
            avg += (end-start)/1000;
        }
        System.out.println("Average time for 1000 nodes and 100 edges by Floyed Warshall: " + avg/10 + " microseconds");
    }
    @Test
    public void test_1000_1000() throws IOException {
        int[][] parents = new int[1000][1000];
        int[][] costs = new int[1000][1000];
        
        long start,end,avg = 0;
        graphGenerator(1000, 1000);
        for(int i=0;i<10;i++){            
            start = System.nanoTime();
            Graph graph = new Graph("C:\\Users\\DELL\\lab 2 DSA\\Shortest_Path_Algorithms\\temp.txt");
     
            for (int j = 0; j < graph.Size(); j++) {
                int[] singleParents = new int[graph.Size()];
                int[] singleCosts = new int[graph.Size()];
                graph.BellmanFord(graph.getVertices().get(i), singleParents, singleCosts);
                
                for (int k = 0; k < graph.Size(); k++) {
                    parents[j][k] = singleParents[k];
                    costs[j][k] = singleCosts[k];
                }
            }           
            end = System.nanoTime();
            avg += (end-start)/1000;
        }
        System.out.println("Average time for 1000 nodes and 1000 edges by Bellman Ford: " + avg/10 + " microseconds");
        avg = 0;
        for(int i=0;i<10;i++){            
            start = System.nanoTime();
            Graph graph = new Graph("C:\\Users\\DELL\\lab 2 DSA\\Shortest_Path_Algorithms\\temp.txt");
     
            for (int j = 0; j < graph.Size(); j++) {
                int[] singleParents = new int[graph.Size()];
                int[] singleCosts = new int[graph.Size()];
                graph.Dijekstra(graph.getVertices().get(i), singleParents, singleCosts);
                
                for (int k = 0; k < graph.Size(); k++) {
                    parents[j][k] = singleParents[k];
                    costs[j][k] = singleCosts[k];
                }
            }           
            end = System.nanoTime();
            avg += (end-start)/1000;
        }   
        System.out.println("Average time for 1000 nodes and 1000 edges by Dijkstra: " + avg/10 + " microseconds");
        avg = 0;
        for(int i=0;i<10;i++){            
            start = System.nanoTime();
            Graph graph = new Graph("C:\\Users\\DELL\\lab 2 DSA\\Shortest_Path_Algorithms\\temp.txt");     
            graph.FloydWarshall(parents, costs);       
            end = System.nanoTime();
            avg += (end-start)/1000;
        }
        System.out.println("Average time for 1000 nodes and 1000 edges by Floyed Warshall: " + avg/10 + " microseconds");
    }
    @Test
    public void test_1000_10000() throws IOException {
        int[][] parents = new int[1000][1000];
        int[][] costs = new int[1000][1000];
        
        long start,end,avg = 0;
        graphGenerator(1000, 10000);
        for(int i=0;i<10;i++){            
            start = System.nanoTime();
            Graph graph = new Graph("C:\\Users\\DELL\\lab 2 DSA\\Shortest_Path_Algorithms\\temp.txt");
     
            for (int j = 0; j < graph.Size(); j++) {
                int[] singleParents = new int[graph.Size()];
                int[] singleCosts = new int[graph.Size()];
                graph.BellmanFord(graph.getVertices().get(i), singleParents, singleCosts);
                
                for (int k = 0; k < graph.Size(); k++) {
                    parents[j][k] = singleParents[k];
                    costs[j][k] = singleCosts[k];
                }
            }           
            end = System.nanoTime();
            avg += (end-start)/1000;
        }
        System.out.println("Average time for 1000 nodes and 10000 edges by Bellman Ford: " + avg/10 + " microseconds");
        avg = 0;
        for(int i=0;i<10;i++){            
            start = System.nanoTime();
            Graph graph = new Graph("C:\\Users\\DELL\\lab 2 DSA\\Shortest_Path_Algorithms\\temp.txt");
     
            for (int j = 0; j < graph.Size(); j++) {
                int[] singleParents = new int[graph.Size()];
                int[] singleCosts = new int[graph.Size()];
                graph.Dijekstra(graph.getVertices().get(i), singleParents, singleCosts);
                
                for (int k = 0; k < graph.Size(); k++) {
                    parents[j][k] = singleParents[k];
                    costs[j][k] = singleCosts[k];
                }
            }           
            end = System.nanoTime();
            avg += (end-start)/1000;
        }   
        System.out.println("Average time for 1000 nodes and 10000 edges by Dijkstra: " + avg/10 + " microseconds");
        avg = 0;
        for(int i=0;i<10;i++){            
            start = System.nanoTime();
            Graph graph = new Graph("C:\\Users\\DELL\\lab 2 DSA\\Shortest_Path_Algorithms\\temp.txt");     
            graph.FloydWarshall(parents, costs);       
            end = System.nanoTime();
            avg += (end-start)/1000;
        }
        System.out.println("Average time for 1000 nodes and 10000 edges by Floyed Warshall: " + avg/10 + " microseconds");
    }
    @Test
    public void test_1000_100000() throws IOException {
        int[][] parents = new int[1000][1000];
        int[][] costs = new int[1000][1000];
        
        long start,end,avg = 0;
        graphGenerator(1000, 100000);
        for(int i=0;i<10;i++){            
            start = System.nanoTime();
            Graph graph = new Graph("C:\\Users\\DELL\\lab 2 DSA\\Shortest_Path_Algorithms\\temp.txt");
     
            for (int j = 0; j < graph.Size(); j++) {
                int[] singleParents = new int[graph.Size()];
                int[] singleCosts = new int[graph.Size()];
                graph.BellmanFord(graph.getVertices().get(i), singleParents, singleCosts);
                
                for (int k = 0; k < graph.Size(); k++) {
                    parents[j][k] = singleParents[k];
                    costs[j][k] = singleCosts[k];
                }
            }           
            end = System.nanoTime();
            avg += (end-start)/1000;
        }
        System.out.println("Average time for 1000 nodes and 100000 edges by Bellman Ford: " + avg/10 + " microseconds");
        avg = 0;
        for(int i=0;i<10;i++){            
            start = System.nanoTime();
            Graph graph = new Graph("C:\\Users\\DELL\\lab 2 DSA\\Shortest_Path_Algorithms\\temp.txt");
     
            for (int j = 0; j < graph.Size(); j++) {
                int[] singleParents = new int[graph.Size()];
                int[] singleCosts = new int[graph.Size()];
                graph.Dijekstra(graph.getVertices().get(i), singleParents, singleCosts);
                
                for (int k = 0; k < graph.Size(); k++) {
                    parents[j][k] = singleParents[k];
                    costs[j][k] = singleCosts[k];
                }
            }           
            end = System.nanoTime();
            avg += (end-start)/1000;
        }   
        System.out.println("Average time for 1000 nodes and 100000 edges by Dijkstra: " + avg/10 + " microseconds");
        avg = 0;
        for(int i=0;i<10;i++){            
            start = System.nanoTime();
            Graph graph = new Graph("C:\\Users\\DELL\\lab 2 DSA\\Shortest_Path_Algorithms\\temp.txt");     
            graph.FloydWarshall(parents, costs);       
            end = System.nanoTime();
            avg += (end-start)/1000;
        }
        System.out.println("Average time for 1000 nodes and 100000 edges by Floyed Warshall: " + avg/10 + " microseconds");
    }
    @Test
    public void test_1000_1000000() throws IOException {
        int[][] parents = new int[1000][1000];
        int[][] costs = new int[1000][1000];
        
        long start,end,avg = 0;
        graphGenerator(1000, 1000000);
        for(int i=0;i<10;i++){            
            start = System.nanoTime();
            Graph graph = new Graph("C:\\Users\\DELL\\lab 2 DSA\\Shortest_Path_Algorithms\\temp.txt");
     
            for (int j = 0; j < graph.Size(); j++) {
                int[] singleParents = new int[graph.Size()];
                int[] singleCosts = new int[graph.Size()];
                graph.BellmanFord(graph.getVertices().get(i), singleParents, singleCosts);
                
                for (int k = 0; k < graph.Size(); k++) {
                    parents[j][k] = singleParents[k];
                    costs[j][k] = singleCosts[k];
                }
            }           
            end = System.nanoTime();
            avg += (end-start)/1000;
        }
        System.out.println("Average time for 1000 nodes and 1000000 edges by Bellman Ford: " + avg/10 + " microseconds");
        avg = 0;
        for(int i=0;i<10;i++){            
            start = System.nanoTime();
            Graph graph = new Graph("C:\\Users\\DELL\\lab 2 DSA\\Shortest_Path_Algorithms\\temp.txt");
     
            for (int j = 0; j < graph.Size(); j++) {
                int[] singleParents = new int[graph.Size()];
                int[] singleCosts = new int[graph.Size()];
                graph.Dijekstra(graph.getVertices().get(i), singleParents, singleCosts);
                
                for (int k = 0; k < graph.Size(); k++) {
                    parents[j][k] = singleParents[k];
                    costs[j][k] = singleCosts[k];
                }
            }           
            end = System.nanoTime();
            avg += (end-start)/1000;
        }   
        System.out.println("Average time for 1000 nodes and 1000000 edges by Dijkstra: " + avg/10 + " microseconds");
        avg = 0;
        for(int i=0;i<10;i++){            
            start = System.nanoTime();
            Graph graph = new Graph("C:\\Users\\DELL\\lab 2 DSA\\Shortest_Path_Algorithms\\temp.txt");     
            graph.FloydWarshall(parents, costs);       
            end = System.nanoTime();
            avg += (end-start)/1000;
        }
        System.out.println("Average time for 1000 nodes and 1000000 edges by Floyed Warshall: " + avg/10 + " microseconds");
    }
}