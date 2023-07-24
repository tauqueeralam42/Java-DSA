import java.util.ArrayList;
import java.util.PriorityQueue;

public class DijkistraAlgorithm {
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

        graph[1].add(new Edge(1, 3,7));
        graph[1].add(new Edge(1, 2,1));

        graph[2].add(new Edge(2, 4,3));

        graph[3].add(new Edge(3, 5,1));

        graph[4].add(new Edge(4, 5,5));
        graph[4].add(new Edge(4, 3,2));

    }
    static class Pair implements Comparable<Pair>{
        int  n;
        int path;

        Pair(int n, int p){
            this.n = n;
            this.path = p;
        }

        @Override
        public int compareTo(Pair p){
            return this.path - p.path;
        }
    }

    static void diskistra(ArrayList<Edge> graph[], int src){
        int dis[] = new int[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        boolean vis[] = new boolean[graph.length];

        for(int i=0; i<graph.length; i++){
            if(i != src){
                dis[i] = Integer.MAX_VALUE;
            }
        }

        pq.add(new Pair(src, 0));

        while(!pq.isEmpty()){
            Pair curr = pq.remove();

            if(!vis[curr.n]){
                vis[curr.n] = true;

                for(int i=0; i<graph[curr.n].size(); i++){
                    Edge e = graph[curr.n].get(i);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;

                    if(dis[u]+wt < dis[v]){
                        dis[v] = dis[u]+wt;
                        pq.add(new Pair(v, dis[v]));
                    }
                }
            }
        }

        for(int i=0; i<dis.length; i++){
            System.out.print(dis[i]+" ");
        }

    }

    public static void main(String[] args) {
        
        int v = 6;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);

        diskistra(graph, 0);
    }
}
