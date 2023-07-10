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
        }

        //0 vertex
        graph[0].add(new Edge(0, 1, 5));

        //1 vertex
        graph[1].add(new Edge(1,0,5));
        graph[1].add(new Edge(1,2,1));
        graph[1].add(new Edge(1,3,3));

        //2 vertex
        graph[2].add(new Edge(2,1,1));
        graph[2].add(new Edge(2,3,1));
        graph[2].add(new Edge(2,4,2));

        //3 vertex
        graph[3].add(new Edge(3,1,3));
        graph[3].add(new Edge(3,2,1));
        
         //4 vertex
        graph[4].add(new Edge(4,2,2));
        
    }
}
