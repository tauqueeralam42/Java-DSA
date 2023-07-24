import java.util.ArrayList;

public class BellmanFordAlgorith {
    static class Edge{
        int src;
        int dest;
        int wt;

        Edge(int s, int d, int w){
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<Edge> ();
        }

        graph[0].add(new Edge(0, 1,2));
        graph[0].add(new Edge(0, 2,4));

        graph[1].add(new Edge(1, 2,-4));
        

        graph[2].add(new Edge(2, 3,2));

        graph[3].add(new Edge(3, 4,4));

        graph[4].add(new Edge(4, 1,-1));
        
    }
    public static void bellmanFord(ArrayList<Edge> graph[], int src){
        int dis[] = new int[graph.length];
        for(int i=0; i<graph.length; i++){
            if(i != src){
                dis[i] = Integer.MAX_VALUE;
            }
        }

        for(int k=0; k<graph.length-1; k++){
            for(int i=0; i<graph.length; i++){
                for(int j=0; j<graph[i].size(); j++){
                    Edge e = graph[i].get(j);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;

                    if(dis[u] != Integer.MAX_VALUE && dis[u]+wt < dis[v]){
                        dis[v] = dis[u]+wt;
                    }
                }
            }
        }

        for(int i=0; i<dis.length; i++){
            System.out.print(dis[i]+" ");
        }
    }

    public static void main(String[] args) {
         int v = 5;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);

        bellmanFord(graph, 0);
    }
}
