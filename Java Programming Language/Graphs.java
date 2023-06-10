import java.util.*;
import java.util.LinkedList;

public class Graphs {
    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    public static void bfs(ArrayList<Edge>[] graph) {
        Queue<Integer> q = new LinkedList<>();
        boolean visited[] = new boolean[graph.length];
        
        q.add(0);
        visited[0] = true;
        while(!q.isEmpty()) {
            int currNode = q.remove();
            System.out.println(currNode);
            for(int j=0; j<graph[currNode].size(); j++) {
                if(visited[graph[currNode].get(j).dest]==false) {
                    q.add(graph[currNode].get(j).dest);
                    visited[graph[currNode].get(j).dest] = true;
                }
            }
        }
    }

    public static void dfs(ArrayList<Edge>[] graph, boolean visited[], int curr) {
        System.out.println(curr);
        visited[curr] = true;

        for(int i=0; i<graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(!visited[e.dest]) {
                dfs(graph, visited, e.dest);
            }
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph) {
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0,1,1));
        graph[0].add(new Edge(0,2,1));

        graph[1].add(new Edge(1,0,1));
        graph[1].add(new Edge(1,3,1));

        graph[2].add(new Edge(2,0,1));
        graph[2].add(new Edge(2,4,1));

        graph[3].add(new Edge(3,1,1));
        graph[3].add(new Edge(3,4,1));
        graph[3].add(new Edge(3,5,1));

        graph[4].add(new Edge(4,2,1));
        graph[4].add(new Edge(4,3,1));
        graph[4].add(new Edge(4,5,1));

        graph[5].add(new Edge(5,3,1));
        graph[5].add(new Edge(5,4,1));
        graph[5].add(new Edge(5,6,1));

        graph[6].add(new Edge(6,5,1));
    }

    public static void main(String[] args) {
        // int V = 5;
        // ArrayList<Edge>[] graph = new ArrayList[V];
        
        // for(int i=0; i<graph.length; i++) {
        //     graph[i] = new ArrayList<>();
        // }

        // graph[0].add(new Edge(0,1,5));
        // graph[1].add(new Edge(1,0,5));
        // graph[1].add(new Edge(1,2,1));
        // graph[1].add(new Edge(1,3,3));
        // graph[2].add(new Edge(2,1,1));
        // graph[2].add(new Edge(2,3,1));
        // graph[2].add(new Edge(2,4,2));
        // graph[3].add(new Edge(3,1,3));
        // graph[3].add(new Edge(3,2,1));
        // graph[4].add(new Edge(4,2,2));

        //2's neighbours
        // for(int i=0; i<graph[1].size(); i++) {
        //     System.out.println(graph[1].get(i).dest);
        // }

        int V = 7;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        // bfs(graph);
        dfs(graph, new boolean[V], 0);
    }
}
