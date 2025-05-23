package Test;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import org.junit.jupiter.api.Test;

import src.Graph;
import src.Vertex;

public class ComparisonSingleSource {
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
        int[] parentss = new int[10];
        int[] costss = new int[10];
        Random random = new Random();
        int src = random.nextInt(10);
        long start,end,avg = 0;
        graphGenerator(10, 10);
        
        int[][] parents = new int[10][10];
        int[][] costs = new int[10][10];
        
        for(int i=0;i<10;i++){            
            start = System.nanoTime();
            Graph graph = new Graph("temp.txt");
            Vertex source = graph.getVertices().get(src);

            graph.BellmanFord(source, parentss, costss);
                
            end = System.nanoTime();
            avg += (end-start)/1000;
            }           
            
      
        System.out.println("Average time for 10 nodes and 10 edges by Bellman Ford: " + avg/10 + " microseconds");
        avg = 0;
        for(int i=0;i<10;i++){            
            start = System.nanoTime();
            Graph graph = new Graph("temp.txt");
            Vertex source = graph.getVertices().get(src);

             graph.Dijekstra(source, parentss, costss);
                
            end = System.nanoTime();
            avg += (end-start)/1000;
            }   
        System.out.println("Average time for 10 nodes and 10 edges by Dijkstra: " + avg/10 + " microseconds");
        avg = 0;
        
        for(int i=0;i<10;i++){            
            start = System.nanoTime();
            Graph graph = new Graph("temp.txt");     
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
        int[] parentss = new int[10];
        int[] costss = new int[10];
        Random random = new Random();
        int src = random.nextInt(10);
        
        long start,end,avg = 0;
        graphGenerator(10, 100);
        for(int i=0;i<10;i++){            
            start = System.nanoTime();
            Graph graph = new Graph("temp.txt");
            Vertex source = graph.getVertices().get(src);

            graph.BellmanFord(source, parentss, costss);
                
            end = System.nanoTime();
            avg += (end-start)/1000;
            }
        System.out.println("Average time for 10 nodes and 100 edges by Bellman Ford: " + avg/10 + " microseconds");
        avg = 0;
        for(int i=0;i<10;i++){            
            start = System.nanoTime();
            Graph graph = new Graph("temp.txt");
            Vertex source = graph.getVertices().get(src);

             graph.Dijekstra(source, parentss, costss);
                
            end = System.nanoTime();
            avg += (end-start)/1000;
            } 
        System.out.println("Average time for 10 nodes and 100 edges by Dijkstra: " + avg/10 + " microseconds");
        avg = 0;
        for(int i=0;i<10;i++){            
            start = System.nanoTime();
            Graph graph = new Graph("temp.txt");     
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
        int[] parentss = new int[10];
        int[] costss = new int[10];
        Random random = new Random();
        int src = random.nextInt(10);
        
        long start,end,avg = 0;
        graphGenerator(10, 1000);
        for(int i=0;i<10;i++){            
            start = System.nanoTime();
            Graph graph = new Graph("temp.txt");
            Vertex source = graph.getVertices().get(src);

            graph.BellmanFord(source, parentss, costss);
                
            end = System.nanoTime();
            avg += (end-start)/1000;
            }
        System.out.println("Average time for 10 nodes and 1000 edges by Bellman Ford: " + avg/10 + " microseconds");
        avg = 0;
        for(int i=0;i<10;i++){            
            start = System.nanoTime();
            Graph graph = new Graph("temp.txt");
            Vertex source = graph.getVertices().get(src);

             graph.Dijekstra(source, parentss, costss);
                
            end = System.nanoTime();
            avg += (end-start)/1000;
            } 
        System.out.println("Average time for 10 nodes and 1000 edges by Dijkstra: " + avg/10 + " microseconds");
        avg = 0;
        for(int i=0;i<10;i++){            
            start = System.nanoTime();
            Graph graph = new Graph("temp.txt");     
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
        int[] parentss = new int[10];
        int[] costss = new int[10];
        Random random = new Random();
        int src = random.nextInt(10);
        
        long start,end,avg = 0;
        graphGenerator(10, 10000);
        for(int i=0;i<10;i++){            
            start = System.nanoTime();
            Graph graph = new Graph("temp.txt");
            Vertex source = graph.getVertices().get(src);

            graph.BellmanFord(source, parentss, costss);
                
            end = System.nanoTime();
            avg += (end-start)/1000;
            }
        System.out.println("Average time for 10 nodes and 10000 edges by Bellman Ford: " + avg/10 + " microseconds");
        avg = 0;
        for(int i=0;i<10;i++){            
            start = System.nanoTime();
            Graph graph = new Graph("temp.txt");
            Vertex source = graph.getVertices().get(src);

             graph.Dijekstra(source, parentss, costss);
                
            end = System.nanoTime();
            avg += (end-start)/1000;
            }  
        System.out.println("Average time for 10 nodes and 10000 edges by Dijkstra: " + avg/10 + " microseconds");
        avg = 0;
        for(int i=0;i<10;i++){            
            start = System.nanoTime();
            Graph graph = new Graph("temp.txt");     
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
        int[] parentss = new int[10];
        int[] costss = new int[10];
        Random random = new Random();
        int src = random.nextInt(10);
        
        long start,end,avg = 0;
        graphGenerator(10, 100000);
        for(int i=0;i<10;i++){            
            start = System.nanoTime();
            Graph graph = new Graph("temp.txt");
            Vertex source = graph.getVertices().get(src);

            graph.BellmanFord(source, parentss, costss);
                
            end = System.nanoTime();
            avg += (end-start)/1000;
            }
        System.out.println("Average time for 10 nodes and 100000 edges by Bellman Ford: " + avg/10 + " microseconds");
        avg = 0;
        for(int i=0;i<10;i++){            
            start = System.nanoTime();
            Graph graph = new Graph("temp.txt");
            Vertex source = graph.getVertices().get(src);

             graph.Dijekstra(source, parentss, costss);
                
            end = System.nanoTime();
            avg += (end-start)/1000;
            }  
        System.out.println("Average time for 10 nodes and 100000 edges by Dijkstra: " + avg/10 + " microseconds");
        avg = 0;
        for(int i=0;i<10;i++){            
            start = System.nanoTime();
            Graph graph = new Graph("temp.txt");     
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
        int[] parentss = new int[100];
        int[] costss = new int[100];
        Random random = new Random();
        int src = random.nextInt(100);
        
        long start,end,avg = 0;
        graphGenerator(100, 10);
        for(int i=0;i<10;i++){            
            start = System.nanoTime();
            Graph graph = new Graph("temp.txt");
            Vertex source = graph.getVertices().get(src);

            graph.BellmanFord(source, parentss, costss);
                
            end = System.nanoTime();
            avg += (end-start)/1000;
            }
        System.out.println("Average time for 100 nodes and 10 edges by Bellman Ford: " + avg/10 + " microseconds");
        avg = 0;
        for(int i=0;i<10;i++){            
            start = System.nanoTime();
            Graph graph = new Graph("temp.txt");
            Vertex source = graph.getVertices().get(src);

             graph.Dijekstra(source, parentss, costss);
                
            end = System.nanoTime();
            avg += (end-start)/1000;
            } 
        System.out.println("Average time for 100 nodes and 10 edges by Dijkstra: " + avg/10 + " microseconds");
        avg = 0;
        for(int i=0;i<10;i++){            
            start = System.nanoTime();
            Graph graph = new Graph("temp.txt");     
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
        int[] parentss = new int[100];
        int[] costss = new int[100];
        Random random = new Random();
        int src = random.nextInt(100);
        
        long start,end,avg = 0;
        graphGenerator(100, 100);
        for(int i=0;i<10;i++){            
            start = System.nanoTime();
            Graph graph = new Graph("temp.txt");
            Vertex source = graph.getVertices().get(src);

            graph.BellmanFord(source, parentss, costss);
                
            end = System.nanoTime();
            avg += (end-start)/1000;
            }
        System.out.println("Average time for 100 nodes and 100 edges by Bellman Ford: " + avg/10 + " microseconds");
        avg = 0;
        for(int i=0;i<10;i++){            
            start = System.nanoTime();
            Graph graph = new Graph("temp.txt");
            Vertex source = graph.getVertices().get(src);

             graph.Dijekstra(source, parentss, costss);
                
            end = System.nanoTime();
            avg += (end-start)/1000;
            }   
        System.out.println("Average time for 100 nodes and 100 edges by Dijkstra: " + avg/10 + " microseconds");
        avg = 0;
        for(int i=0;i<10;i++){            
            start = System.nanoTime();
            Graph graph = new Graph("temp.txt");     
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
        int[] parentss = new int[100];
        int[] costss = new int[100];
        Random random = new Random();
        int src = random.nextInt(100);
        
        long start,end,avg = 0;
        graphGenerator(100, 1000);
        for(int i=0;i<10;i++){            
            start = System.nanoTime();
            Graph graph = new Graph("temp.txt");
            Vertex source = graph.getVertices().get(src);

            graph.BellmanFord(source, parentss, costss);
                
            end = System.nanoTime();
            avg += (end-start)/1000;
            }
        System.out.println("Average time for 100 nodes and 1000 edges by Bellman Ford: " + avg/10 + " microseconds");
        avg = 0;
        for(int i=0;i<10;i++){            
            start = System.nanoTime();
            Graph graph = new Graph("temp.txt");
            Vertex source = graph.getVertices().get(src);

             graph.Dijekstra(source, parentss, costss);
                
            end = System.nanoTime();
            avg += (end-start)/1000;
            }  
        System.out.println("Average time for 100 nodes and 1000 edges by Dijkstra: " + avg/10 + " microseconds");
        avg = 0;
        for(int i=0;i<10;i++){            
            start = System.nanoTime();
            Graph graph = new Graph("temp.txt");     
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
        int[] parentss = new int[100];
        int[] costss = new int[100];
        Random random = new Random();
        int src = random.nextInt(100);
        
        long start,end,avg = 0;
        graphGenerator(100, 10000);
        for(int i=0;i<10;i++){            
            start = System.nanoTime();
            Graph graph = new Graph("temp.txt");
            Vertex source = graph.getVertices().get(src);

            graph.BellmanFord(source, parentss, costss);
                
            end = System.nanoTime();
            avg += (end-start)/1000;
            }
        System.out.println("Average time for 100 nodes and 10000 edges by Bellman Ford: " + avg/10 + " microseconds");
        avg = 0;
        for(int i=0;i<10;i++){            
            start = System.nanoTime();
            Graph graph = new Graph("temp.txt");
            Vertex source = graph.getVertices().get(src);

             graph.Dijekstra(source, parentss, costss);
                
            end = System.nanoTime();
            avg += (end-start)/1000;
            } 
        System.out.println("Average time for 100 nodes and 10000 edges by Dijkstra: " + avg/10 + " microseconds");
        avg = 0;
        for(int i=0;i<10;i++){            
            start = System.nanoTime();
            Graph graph = new Graph("temp.txt");     
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
        int[] parentss = new int[100];
        int[] costss = new int[100];
        Random random = new Random();
        int src = random.nextInt(100);
        
        long start,end,avg = 0;
        graphGenerator(100, 100000);
        for(int i=0;i<10;i++){            
            start = System.nanoTime();
            Graph graph = new Graph("temp.txt");
            Vertex source = graph.getVertices().get(src);

            graph.BellmanFord(source, parentss, costss);
                
            end = System.nanoTime();
            avg += (end-start)/1000;
            }
        System.out.println("Average time for 100 nodes and 100000 edges by Bellman Ford: " + avg/10 + " microseconds");
        avg = 0;
        for(int i=0;i<10;i++){            
            start = System.nanoTime();
            Graph graph = new Graph("temp.txt");
            Vertex source = graph.getVertices().get(src);

             graph.Dijekstra(source, parentss, costss);
                
            end = System.nanoTime();
            avg += (end-start)/1000;
            }  
        System.out.println("Average time for 100 nodes and 100000 edges by Dijkstra: " + avg/10 + " microseconds");
        avg = 0;
        for(int i=0;i<10;i++){            
            start = System.nanoTime();
            Graph graph = new Graph("temp.txt");     
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
        int[] parentss = new int[1000];
        int[] costss = new int[1000];
        Random random = new Random();
        int src = random.nextInt(1000);
        
        long start,end,avg = 0;
        graphGenerator(1000, 100);
        for(int i=0;i<10;i++){            
            start = System.nanoTime();
            Graph graph = new Graph("temp.txt");
            Vertex source = graph.getVertices().get(src);

            graph.BellmanFord(source, parentss, costss);
                
            end = System.nanoTime();
            avg += (end-start)/1000;
            }
        System.out.println("Average time for 1000 nodes and 100 edges by Bellman Ford: " + avg/10 + " microseconds");
        avg = 0;
        for(int i=0;i<10;i++){            
            start = System.nanoTime();
            Graph graph = new Graph("temp.txt");
            Vertex source = graph.getVertices().get(src);

             graph.Dijekstra(source, parentss, costss);
                
            end = System.nanoTime();
            avg += (end-start)/1000;
            }    
        System.out.println("Average time for 1000 nodes and 100 edges by Dijkstra: " + avg/10 + " microseconds");
        avg = 0;
        for(int i=0;i<10;i++){            
            start = System.nanoTime();
            Graph graph = new Graph("temp.txt");     
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
        int[] parentss = new int[1000];
        int[] costss = new int[1000];
        Random random = new Random();
        int src = random.nextInt(1000);
        
        long start,end,avg = 0;
        graphGenerator(1000, 1000);
        for(int i=0;i<10;i++){            
            start = System.nanoTime();
            Graph graph = new Graph("temp.txt");
            Vertex source = graph.getVertices().get(src);

            graph.BellmanFord(source, parentss, costss);
                
            end = System.nanoTime();
            avg += (end-start)/1000;
            }
        System.out.println("Average time for 1000 nodes and 1000 edges by Bellman Ford: " + avg/10 + " microseconds");
        avg = 0;
        for(int i=0;i<10;i++){            
            start = System.nanoTime();
            Graph graph = new Graph("temp.txt");
            Vertex source = graph.getVertices().get(src);

             graph.Dijekstra(source, parentss, costss);
                
            end = System.nanoTime();
            avg += (end-start)/1000;
            }   
        System.out.println("Average time for 1000 nodes and 1000 edges by Dijkstra: " + avg/10 + " microseconds");
        avg = 0;
        for(int i=0;i<10;i++){            
            start = System.nanoTime();
            Graph graph = new Graph("temp.txt");     
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
        int[] parentss = new int[1000];
        int[] costss = new int[1000];
        Random random = new Random();
        int src = random.nextInt(1000);
        
        long start,end,avg = 0;
        graphGenerator(1000, 10000);
        for(int i=0;i<10;i++){            
            start = System.nanoTime();
            Graph graph = new Graph("temp.txt");
            Vertex source = graph.getVertices().get(src);

            graph.BellmanFord(source, parentss, costss);
                
            end = System.nanoTime();
            avg += (end-start)/1000;
            }
        System.out.println("Average time for 1000 nodes and 10000 edges by Bellman Ford: " + avg/10 + " microseconds");
        avg = 0;
        for(int i=0;i<10;i++){            
            start = System.nanoTime();
            Graph graph = new Graph("temp.txt");
            Vertex source = graph.getVertices().get(src);

             graph.Dijekstra(source, parentss, costss);
                
            end = System.nanoTime();
            avg += (end-start)/1000;
            }   
        System.out.println("Average time for 1000 nodes and 10000 edges by Dijkstra: " + avg/10 + " microseconds");
        avg = 0;
        for(int i=0;i<10;i++){            
            start = System.nanoTime();
            Graph graph = new Graph("temp.txt");     
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
        int[] parentss = new int[1000];
        int[] costss = new int[1000];
        Random random = new Random();
        int src = random.nextInt(1000);
        
        long start,end,avg = 0;
        graphGenerator(1000, 100000);
        for(int i=0;i<10;i++){            
            start = System.nanoTime();
            Graph graph = new Graph("temp.txt");
            Vertex source = graph.getVertices().get(src);

            graph.BellmanFord(source, parentss, costss);
                
            end = System.nanoTime();
            avg += (end-start)/1000;
            }
        System.out.println("Average time for 1000 nodes and 100000 edges by Bellman Ford: " + avg/10 + " microseconds");
        avg = 0;
        for(int i=0;i<10;i++){            
            start = System.nanoTime();
            Graph graph = new Graph("temp.txt");
            Vertex source = graph.getVertices().get(src);

             graph.Dijekstra(source, parentss, costss);
                
            end = System.nanoTime();
            avg += (end-start)/1000;
            }    
        System.out.println("Average time for 1000 nodes and 100000 edges by Dijkstra: " + avg/10 + " microseconds");
        avg = 0;
        for(int i=0;i<10;i++){            
            start = System.nanoTime();
            Graph graph = new Graph("temp.txt");     
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
        int[] parentss = new int[1000];
        int[] costss = new int[1000];
        Random random = new Random();
        int src = random.nextInt(1000);
        
        long start,end,avg = 0;
        graphGenerator(1000, 1000000);
        for(int i=0;i<10;i++){            
            start = System.nanoTime();
            Graph graph = new Graph("temp.txt");
            Vertex source = graph.getVertices().get(src);

            graph.BellmanFord(source, parentss, costss);
                
            end = System.nanoTime();
            avg += (end-start)/1000;
            }
        System.out.println("Average time for 1000 nodes and 1000000 edges by Bellman Ford: " + avg/10 + " microseconds");
        avg = 0;
        for(int i=0;i<10;i++){            
            start = System.nanoTime();
            Graph graph = new Graph("temp.txt");
            Vertex source = graph.getVertices().get(src);

             graph.Dijekstra(source, parentss, costss);
                
            end = System.nanoTime();
            avg += (end-start)/1000;
            }  
        System.out.println("Average time for 1000 nodes and 1000000 edges by Dijkstra: " + avg/10 + " microseconds");
        avg = 0;
        for(int i=0;i<10;i++){            
            start = System.nanoTime();
            Graph graph = new Graph("temp.txt");     
            graph.FloydWarshall(parents, costs);       
            end = System.nanoTime();
            avg += (end-start)/1000;
        }
        System.out.println("Average time for 1000 nodes and 1000000 edges by Floyed Warshall: " + avg/10 + " microseconds");
    }
    @Test
public void test_multiple_combinations() throws IOException {
    int[][] testCases = {
        {5, 5},
        {10, 10},
        {15, 20},
        {20, 40},
        {25, 60},
        {30, 90},
        {40, 120},
        {50, 150},
        {60, 200},
        {75, 300},
        {90, 400},
        {100, 500},
        {110, 600},
        {120, 700},
        {130, 800},
        {140, 1000},
        {150, 1200},
        {160, 1400},
        {170, 1600},
        {180, 1800},
        {190, 2000},
        {200, 2200},
        {220, 2500},
        {250, 3000}
    };

    for (int[] testCase : testCases) {
        int nodes = testCase[0];
        int edges = testCase[1];
        int[][] parents = new int[nodes][nodes];
        int[][] costs = new int[nodes][nodes];
        int[] parentss = new int[nodes];
        int[] costss = new int[nodes];
        Random random = new Random();
        int src = random.nextInt(nodes);
        long start, end, avg = 0;
        graphGenerator(nodes, edges);

        // Bellman-Ford
        for(int i=0;i<10;i++){            
            start = System.nanoTime();
            Graph graph = new Graph("temp.txt");
            Vertex source = graph.getVertices().get(src);

            graph.BellmanFord(source, parentss, costss);
                
            end = System.nanoTime();
            avg += (end-start)/1000;
            }
        System.out.println("Average time for " + nodes + " nodes and " + edges + " edges by Bellman-Ford: " + avg / 10 + " microseconds");
        
        // Dijkstra
        avg = 0;
        for(int i=0;i<10;i++){            
            start = System.nanoTime();
            Graph graph = new Graph("temp.txt");
            Vertex source = graph.getVertices().get(src);

             graph.Dijekstra(source, parentss, costss);
                
            end = System.nanoTime();
            avg += (end-start)/1000;
            } 
        System.out.println("Average time for " + nodes + " nodes and " + edges + " edges by Dijkstra: " + avg / 10 + " microseconds");

        // Floyd-Warshall
        avg = 0;
        for (int i = 0; i < 10; i++) {
            start = System.nanoTime();
            Graph graph = new Graph("temp.txt");
            graph.FloydWarshall(parents, costs);
            end = System.nanoTime();
            avg += (end - start) / 1000;
        }
        System.out.println("Average time for " + nodes + " nodes and " + edges + " edges by Floyd-Warshall: " + avg / 10 + " microseconds");
        System.out.println("--------------------------------------------------");
    }
}
}