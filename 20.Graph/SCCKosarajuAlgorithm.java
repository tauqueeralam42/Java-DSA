import java.util.*;
public class SCCKosarajuAlgorithm {
    
    static class Edge{
        int src;
        int dest;
        

        Edge(int s, int d){
            this.src = s;
            this.dest = d;
            
        }
    }

    static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0; i<graph.length;i++){
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0,3));
        graph[0].add(new Edge(0,2));

        graph[1].add(new Edge(1,0));

        graph[2].add(new Edge(2,1));

        graph[3].add(new Edge(3,4));

    }

    static void topSort(ArrayList<Edge> graph[], boolean vis[], int curr, Stack<Integer> s){
        vis[curr] = true;
        
        for(int i=0; i<graph[curr].size(); i++){
            Edge e= graph[curr].get(i);
            if(!vis[e.dest]){
                topSort(graph, vis, e.dest, s);
            }
        }

        s.push(curr);
    }

    static void dfs(ArrayList<Edge> graph[], int curr, boolean vis[]){
        vis[curr] = true;
        System.out.print(curr+" ");

        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                dfs(graph, e.dest, vis);
            }
        }
    }

    static void kosarajuAlgo(ArrayList<Edge> graph[]){
        //step -1
        Stack<Integer> s = new Stack<>();
        boolean vis[] = new boolean[graph.length];

        for(int i=0; i<graph.length; i++){
            if(!vis[i]){
                topSort(graph, vis, i, s);
            }
        }

        //step 2 transpose
        ArrayList<Edge> transpose[] = new ArrayList[graph.length];
        for(int i=0; i<graph.length;i++){
            vis[i] = false;
            transpose[i] = new ArrayList<Edge>();
        }

        for(int i=0; i<graph.length; i++){
            for(int j=0; j<graph[i].size(); j++){
                Edge e = graph[i].get(j);
                transpose[e.dest].add(new Edge(e.dest, i));
            }
        }

        //step3
        while(!s.isEmpty()){
            int curr = s.pop();
            if(!vis[curr]){
                dfs(transpose, curr, vis);
                System.out.println();
            }
            
    }
    }

    public static void main(String[] args) {
        int v = 5;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);

        kosarajuAlgo(graph);
        
    }
}
