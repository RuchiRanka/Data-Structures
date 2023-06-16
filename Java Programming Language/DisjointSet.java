import java.lang.reflect.Array;
import java.util.*;

public class DisjointSet {
    static int n=8;
    static int par[] = new int[n];
    static int rank[] = new int[n];
    
    public static void init() {
        for(int i=0; i<n; i++) {
            par[i] = i;
        }
    }

    // public static int find(int x) {
    //     int leader = x;
    //     while(par[leader] != leader) {
    //         leader = par[leader];
    //     }
    //     return leader;
    // }

    public static int find(int x) {
        if(par[x]==x) {
            return x;
        }
        return par[x] = find(par[x]); //path compression
    }

    public static void union(int a, int b) {
        int parA = find(a);
        int parB = find(b);

        if(rank[parA]==rank[parB]) {
            par[parB] = parA;
            rank[parA]++;
        }
        else if(rank[parA]>rank[parB]) {
            par[parB] = parA;
        }
        else {
            par[parA] = parB;
        }
    }

    static class Edge implements Comparable<Edge> {
        int src;
        int dest;
        int wt;
        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }

        @Override
        public int compareTo(Edge e) {
            return this.wt - e.wt;
        }
    }

    public static int kruskals(ArrayList<Edge> graph, int V) {
        Collections.sort(graph);
        int finalCost = 0;
        int count = 0;
        
        for(int i=0; count<V-1; i++) {
            Edge e = graph.get(i);
            if(find(e.src) != find(e.dest)) {
                finalCost += e.wt;
                union(e.src, e.dest);
                count++;
            }
        }
        return finalCost;
    }

    public static void createGraph(ArrayList<Edge> graph) {
        graph.add(new Edge(0,1,10));
        graph.add(new Edge(1,3,40));
        graph.add(new Edge(2,3,50));
        graph.add(new Edge(0,2,15));
        graph.add(new Edge(0,3,30));
    }

    public static void main(String[] args) {
        init();
        // System.out.println(find(3));
        // union(1,3);
        // System.out.println(find(3));
        // union(2,4);
        // union(3,6);
        // union(1,4);
        // System.out.println(find(3));
        // System.out.println(find(4));
        // union(1,5);

        int V = 4;
        ArrayList<Edge> graph = new ArrayList<>();
        createGraph(graph);
        System.out.println(kruskals(graph, V));
    }
}
