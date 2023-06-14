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
        boolean visited[] = new boolean[graph.length];
        for(int i=0; i<graph.length; i++) {
            if(!visited[i]) {
                bfsUtil(graph, visited);
            }
        }
    }

    public static void bfsUtil(ArrayList<Edge>[] graph, boolean visited[]) {
        Queue<Integer> q = new LinkedList<>();
        
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

    public static void dfs(ArrayList<Edge>[] graph) {
        boolean visited[] = new boolean[graph.length];
        for(int i=0; i<graph.length; i++) {
            if(!visited[i]) {
                dfsUtil(graph, visited, i);
            }
        }
    }

    public static void dfsUtil(ArrayList<Edge>[] graph, boolean visited[], int curr) {
        System.out.println(curr);
        visited[curr] = true;

        for(int i=0; i<graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(!visited[e.dest]) {
                dfsUtil(graph, visited, e.dest);
            }
        }
    }

    public static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean visited[]) {
        if(src==dest) {
            return true;
        }
        visited[src] = true;
        for(int i=0; i<graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            if(!visited[e.dest] && hasPath(graph, e.dest, dest, visited)) {
                return true;
            }
        }
        return false;
    }

    public static boolean detectCycle(ArrayList<Edge>[] graph) {
        boolean visited[] = new boolean[graph.length];
        for(int i=0; i<graph.length; i++) {
            if(!visited[i]) {
                if(detectCycleUtil(graph, visited, i, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean detectCycleUtil(ArrayList<Edge>[] graph, boolean visited[], int curr, int par) {
        visited[curr] = true;

        for(int i=0; i<graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            //case-3
            if(!visited[e.dest]) {
                if(detectCycleUtil(graph, visited, e.dest, curr)) {
                    return true;
                }
            }

            //case-1
            else if(visited[e.dest] && e.dest!=par) {
                return true;
            }

            //case-2 -> do nothing -> continue
        }

        return false;
    }

    public static boolean isBipartite(ArrayList<Edge>[] graph) {
        int col[] = new int[graph.length];
        for(int i=0; i<col.length; i++) {
            col[i] = -1;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<col.length; i++) {
            if(col[i]==-1) {
                col[i] = 0;
                q.add(i);
                if(isBipartiteUtil(graph, col, q, i)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isBipartiteUtil(ArrayList<Edge>[] graph, int col[], Queue<Integer> q, int curr) {

        q.remove(curr);
        for(int i=0; i<graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(col[e.dest] == -1) {
                col[e.dest] = col[curr]==0 ? 1 : 0;
                q.add(e.dest);
            }

            else if(col[e.dest] != -1 && col[curr]==col[e.dest]) {
                return false;
            }
        }

        if(q.isEmpty()) {
            return true;
        }

        return isBipartiteUtil(graph, col, q, q.peek());
    }

    public static boolean isCyclic(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];

        for(int i=0; i<graph.length; i++) {
            if(!vis[i]) {
                if(isCyclicUtil(graph, vis, stack, i)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isCyclicUtil(ArrayList<Edge>[] graph, boolean vis[], boolean stack[], int curr) {
        vis[curr] = true;
        stack[curr] = true;

        for(int i=0; i<graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(stack[e.dest]) {
                return true;
            }
            else if(!vis[e.dest] && isCyclicUtil(graph, vis, stack, e.dest)) {
                return true;
            }
        }

        stack[curr] = false;
        return false;
    }

    public static void topSort(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();

        for(int i=0; i<graph.length; i++) {
            if(!vis[i]) {
                topSortUtil(graph, vis, s, i);
            }
        }

        while(!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        }
    }

    public static void topSortUtil(ArrayList<Edge>[] graph, boolean vis[],  Stack<Integer> s, int curr) {
        vis[curr] = true;

        for(int i=0; i<graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]) {
                topSortUtil(graph, vis, s, e.dest);
            }
        }

        s.push(curr);
    }

    public static void topSortKahn(ArrayList<Edge>[] graph) {
        int indeg[] = new int[graph.length];
        for(int i=0; i<graph.length; i++) {
            for(int j=0; j<graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                indeg[e.dest]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<indeg.length; i++) {
            if(indeg[i]==0) {
                q.add(i);
            }
        }

        while(!q.isEmpty()) {
            int curr = q.remove();
            System.out.print(curr + " ");
            for(int i=0; i<graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                indeg[e.dest]--;
                if(indeg[e.dest]==0) {
                    q.add(e.dest);
                }
            }
        }
    }

    public static void allPaths(ArrayList<Edge>[] graph, int src, int dest, ArrayList<Integer> path) {
        path.add(src);
        if(src==dest) {
            System.out.print(path.get(0));
            for(int i=1; i<path.size(); i++) {
                System.out.print("->" + path.get(i));
            }
            System.out.println();
        }
        for(int i=0; i<graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            allPaths(graph, e.dest, dest, path);
        }
        path.remove(path.size()-1);
    }

    static class Pair implements Comparable<Pair> {
        int n;
        int path;
        public Pair(int n, int path) {
            this.n = n;
            this.path = path;
        }
        @Override
        public int compareTo(Pair p) {
            return this.path-p.path;
        }
    }

    public static void dijkstra(ArrayList<Edge>[] graph, int src) {
        int dist[] = new int[graph.length];
        for(int i=0; i<dist.length; i++) {
            if(i!=src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        boolean vis[] = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0));

        while(!pq.isEmpty()) {
            Pair curr = pq.remove();

            if(!vis[curr.n]) {
                vis[curr.n] = true;

                //neighbours
                for(int i=0; i<graph[curr.n].size(); i++) {
                    Edge e = graph[curr.n].get(i);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;

                    if(dist[u] + wt < dist[v]) {
                        dist[v] = dist[u] + wt;
                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }
        }

        for(int i=0; i<dist.length; i++) {
            System.out.print(dist[i] + " ");
        }
    }

    public static void bellmanFord(ArrayList<Edge>[] graph, int src) {
        int dist[] = new int[graph.length];
        for(int i=0; i<dist.length; i++) {
            if(i!=src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        int V = graph.length;
        for(int i=0; i<V-1; i++) {
            for(int j=0; j<graph.length; j++) {
                for(int k=0; k<graph[j].size(); k++) {
                    Edge e = graph[j].get(k);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;
                    if(dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                        dist[v] = dist[u] + wt;
                    }
                }
            }
        }

        for(int i=0; i<dist.length; i++) {
            System.out.print(dist[i] +" ");
        }
    }

    static class Pair1 implements Comparable<Pair1> {
        int n;
        int cost;

        public Pair1(int n, int cost) {
            this.n = n;
            this.cost = cost;
        }

        @Override
        public int compareTo(Pair1 p) {
            return this.cost - p.cost;
        }
    }
    public static int prims(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];

        PriorityQueue<Pair1> pq = new PriorityQueue<>();
        pq.add(new Pair1(0, 0));
        int mst = 0;

        while(!pq.isEmpty()) {
            Pair1 curr = pq.remove();
            if(!vis[curr.n]) {
                mst += curr.cost;
                vis[curr.n] = true;
                for(int i=0; i<graph[curr.n].size(); i++) {
                    Edge e = graph[curr.n].get(i);
                    pq.add(new Pair1(e.dest, e.wt));
                }
            }
        }

        return mst;
    }

    public static void createGraph(ArrayList<Edge>[] graph) {
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // // Undirected Graph 1
        // graph[0].add(new Edge(0,1,1));
        // graph[0].add(new Edge(0,2,1));
        
        // graph[1].add(new Edge(1,0,1));
        // graph[1].add(new Edge(1,3,1));
        
        // graph[2].add(new Edge(2,0,1));
        // graph[2].add(new Edge(2,4,1));
        
        // graph[3].add(new Edge(3,1,1));
        // graph[3].add(new Edge(3,4,1));
        // graph[3].add(new Edge(3,5,1));
        
        // graph[4].add(new Edge(4,2,1));
        // graph[4].add(new Edge(4,3,1));
        // graph[4].add(new Edge(4,5,1));
        
        // graph[5].add(new Edge(5,3,1));
        // graph[5].add(new Edge(5,4,1));
        // graph[5].add(new Edge(5,6,1));
        
        // graph[6].add(new Edge(6,5,1));
        
        
        // // Undirected Graph 2
        // graph[0].add(new Edge(0,1,1));
        // graph[0].add(new Edge(0,2,1));
        // graph[0].add(new Edge(0,3,1));
        
        // graph[1].add(new Edge(1,0,1));
        // graph[1].add(new Edge(1,2,1));
        
        // graph[2].add(new Edge(2,0,1));
        // graph[2].add(new Edge(2,1,1));
        
        // graph[3].add(new Edge(3,0,1));
        // graph[3].add(new Edge(3,4,1));
        
        // graph[4].add(new Edge(4,3,1));
        
        
        // // Undirected Graph 3
        // graph[0].add(new Edge(0,1,1));
        // graph[0].add(new Edge(0,2,1));
        
        // graph[1].add(new Edge(1,0,1));
        // graph[1].add(new Edge(1,3,1));
        
        // graph[2].add(new Edge(2,0,1));
        // graph[2].add(new Edge(2,4,1));

        // graph[3].add(new Edge(3,1,1));
        // graph[3].add(new Edge(3,4,1));

        // graph[4].add(new Edge(4,2,1));
        // graph[4].add(new Edge(4,3,1));


        // // Directed Graph 1
        // graph[0].add(new Edge(0,2,1));
        // graph[1].add(new Edge(1,0,1));
        // graph[2].add(new Edge(2,3,1));
        // graph[3].add(new Edge(3,0,1));


        // // Directed Graph 2
        // graph[0].add(new Edge(0,1,1));
        // graph[0].add(new Edge(0,2,1));
        // graph[1].add(new Edge(1,3,1));
        // graph[2].add(new Edge(2,3,1));

        // // Directed Graph 3 (Topological Sorting)
        // graph[2].add(new Edge(2,3,1));
        // graph[3].add(new Edge(3,1,1));
        // graph[4].add(new Edge(4,0,1));
        // graph[4].add(new Edge(4,1,1));
        // graph[5].add(new Edge(5,0,1));
        // graph[5].add(new Edge(5,2,1));

        // // Directed Graph 4
        // graph[0].add(new Edge(0,3,1));
        // graph[2].add(new Edge(2,3,1));
        // graph[3].add(new Edge(3,1,1));
        // graph[4].add(new Edge(4,0,1));
        // graph[4].add(new Edge(4,1,1));
        // graph[5].add(new Edge(5,0,1));
        // graph[5].add(new Edge(5,2,1));


        // // Directed Graph 5
        // graph[0].add(new Edge(0, 1, 2));
        // graph[0].add(new Edge(0, 2, 4));

        // graph[1].add(new Edge(1, 2, 1));
        // graph[1].add(new Edge(1, 3, 7));

        // graph[2].add(new Edge(2, 4, 3));

        // graph[3].add(new Edge(3, 5, 1));

        // graph[4].add(new Edge(4, 3, 2));
        // graph[4].add(new Edge(4, 5, 5));


        // // Directed Graph 6
        // graph[0].add(new Edge(0,1,2));
        // graph[0].add(new Edge(0,2,4));

        // graph[1].add(new Edge(1,2,-4));
        // graph[2].add(new Edge(2,3,2));
        // graph[3].add(new Edge(3,4,4));
        // graph[4].add(new Edge(4,1,-1));


        // Undirected Graph 4 (Prim's Algorithm)
        graph[0].add(new Edge(0,1,10));
        graph[0].add(new Edge(0,2,15));
        graph[0].add(new Edge(0,3,30));

        graph[1].add(new Edge(1,0,10));
        graph[1].add(new Edge(1,3,40));

        graph[2].add(new Edge(2,0,15));
        graph[2].add(new Edge(2,3,50));

        graph[3].add(new Edge(3,0,30));
        graph[3].add(new Edge(3,1,40));
        graph[3].add(new Edge(3,2,50));
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

        // int V = 7;
        // ArrayList<Edge>[] graph = new ArrayList[V];
        // createGraph(graph);
        // bfs(graph);
        // dfs(graph);

        // System.out.println(hasPath(graph, 0, 7, new boolean[V]));

        // int V = 5;
        // ArrayList<Edge>[] graph = new ArrayList[V];
        // createGraph(graph);
        // System.out.println(detectCycle(graph));

        // System.out.println(isBipartite(graph));

        // int V = 4;
        // ArrayList<Edge>[] graph = new ArrayList[V];
        // createGraph(graph);
        // System.out.println(isCyclic(graph));

        // int V = 6;
        // ArrayList<Edge>[] graph = new ArrayList[V];
        // createGraph(graph);
        // topSort(graph);
        // topSortKahn(graph);

        // allPaths(graph, 5, 1, new ArrayList<>());
        
        // int src = 0;
        // dijkstra(graph, src);

        // int V= 5;
        // ArrayList<Edge>[] graph = new ArrayList[V];
        // createGraph(graph);
        // bellmanFord(graph, 0);
        
        int V = 4;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        System.out.println(prims(graph));
    }
}
