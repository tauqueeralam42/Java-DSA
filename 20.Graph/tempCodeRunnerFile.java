import java.util.ArrayList;

public class GraphBasic {
    public static class Edge{
        int src;
        int dst;
        int wt;

        Edge(int s, int d, int w){
            this.src = s;
            this.dst = d;
            this.wt = w;
        }
    }

    public static void main(String[] args) {
        /*
                      (5)
                    0------ 1
                           / \
                      (1) /   \ (3)
                         /     \
                        2-------3
                        |  (1)
                   (2)  |
                        |
                        4
         */
        int v = 5;
        ArrayList<Edge> graph[] = new ArrayList[v];

        for(int i=0; i<v; i++){
            graph[i] = new ArrayList<Edge>();