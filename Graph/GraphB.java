
import java.util.*;

public class GraphB {
    public static class Edge{
        int src;
        int dest;
        int wt;
        

        public Edge(int s, int d,int w){
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    public static void bfs(ArrayList<Edge>[] graph){
         boolean vis[] = new boolean[graph.length];
         for(int i=0; i<graph.length; i++){
            if(!vis[i]){
                bfsUtil(graph, i,vis);
            }
         }
    }

    public static void bfsUtil(ArrayList<Edge>[] graph, int start, boolean vis[]){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        while(!q.isEmpty()){
            int curr = q.remove();

            if(!vis[curr]){
                System.out.print(curr+" ");
                vis[curr] = true;
                for(int i=0; i<graph[curr].size(); i++){
             
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    public static void dfs(ArrayList<Edge>[] graph){
        boolean vis[] = new boolean[graph.length];  
        for(int i=0; i<graph.length; i++){
            if(!vis[i]){
                dfsUtil(graph, i, vis);
            }
        }
    }

    public static void dfsUtil(ArrayList<Edge>[] graph, int curr,boolean vis[]){
        if(curr == graph.length){
            return;
        }
         vis[curr] = true;      
            System.out.print(curr+" ");
        for(int i = 0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
             if(!vis[e.dest]){
                dfsUtil(graph, e.dest, vis);
            }
        }
    }

    public static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean vis[]){
        if(src == dest){
            return true;
        }

        vis[src] = true;

        for(int i=0; i<graph[src].size(); i++){
            Edge e = graph[src].get(i);

            if(!vis[e.dest] && hasPath(graph, e.dest, dest, vis)){
                return true;
            }
        }
        return false;
    }

    public static boolean detectCycle(ArrayList<Edge>[] graph, int curr){
        boolean vis[] = new boolean[graph.length];
        for(int i=0; i<graph.length; i++){
            if(!vis[i]){
                if(detectCycleUtil(graph, vis, i, -1)){
                    return true;
                }
                
            }
        }
        return false;
    }

    public static boolean detectCycleUtil(ArrayList<Edge>[] graph, boolean vis[], int curr, int par){
        vis[curr] = true;
        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            //case3
            if(!vis[e.dest]){
                if( detectCycleUtil(graph, vis, e.dest, curr)){
                     return true;
                }
               
            }
            //case1
            else if(vis[e.dest] && e.dest != par){
                return true;
            }
            //case2 do nothing
        }
        return false;
    }

    public static boolean  isBipartite(ArrayList<Edge>[] graph){
        int[] color = new int[graph.length];
        for(int i=0; i<color.length; i++){
            color[i] = -1; //no color
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<graph.length; i++){
            if(color[i] == -1){
                q.add(i);
                color[i] = 0;
                while(!q.isEmpty()){
                    int curr = q.remove();
                    for(int j=0; j<graph[curr].size(); j++){
                        Edge e = graph[curr].get(j);
                         if(color[e.dest] == -1){
                        int nextCol = color[curr] == 0 ? 1: 0;
                        color[e.dest] = nextCol;
                        q.add(e.dest);
                    }else if(color[e.dest] == color[curr]){
                        return false; //NOT BIPARTITE
                    }
                    }
                   
                }
            }
        }
        return true;

    }

    public static boolean isCycle(ArrayList<Edge>[] graph){
        boolean vis[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];

        for(int i=0; i<graph.length; i++){
            if(!vis[i]){
                if(isCycleUtil(graph, i, vis, stack)){
                    return true;
                }
            }
        }
        return false; 
    }

    public static boolean isCycleUtil(ArrayList<Edge>[] graph, int curr, boolean  vis[], boolean  stack[]){
        vis[curr] = true;
        stack[curr] = true;

        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i); 
            if(stack[e.dest]){
                return true;
            }
            if(!vis[e.dest] && isCycleUtil(graph, e.dest, vis, stack)){
                return true;
            }
        }

        stack[curr] = false;
        return false;

    }

    // public static void topSort(ArrayList<Edge>[] graph){
    //     boolean vis[] = new boolean[graph.length];
    //     Stack<Integer> s = new Stack<>();

    //     for(int i=0; i<graph.length; i++){
    //         if(!vis[i]){
    //             topSortUtil(graph, i ,vis, s);
    //         }
    //     }

    //     while(!s.isEmpty()){
    //         System.out.print(s.pop()+" ");
    //     }
    // }

    // public static void topSortUtil(ArrayList<Edge>[] graph, int curr, boolean vis[], Stack<Integer> s){
    //     vis[curr] = true;

    //     for(int i=0; i<graph[curr].size(); i++){
    //         Edge e = graph[curr].get(i);
    //         if(!vis[e.dest]){
    //             topSortUtil(graph, e.dest, vis, s);
    //         }
    //     }
    //     s.push(curr);
    // }

    public static void calDeg(ArrayList<Edge>[] graph, int indeg[]){
        for(int i=0; i<graph.length; i++){
            for(int j=0; j<graph[i].size(); j++){
                Edge e = graph[i].get(j);
                indeg[e.dest]++;
            }
        }
    }

    public static void topSort(ArrayList<Edge>[] graph){
        int indeg[] = new int[graph.length];
        calDeg(graph, indeg);
        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<indeg.length; i++){
            if(indeg[i] == 0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int curr = q.remove();
            System.out.print(curr+" ");

            for(int i=0; i<graph[curr].size(); i++){
                Edge e = graph[curr].get(i);
                indeg[e.dest]--;
                if(indeg[e.dest] == 0){
                    q.add(e.dest);
                }
            }

        }

    }

    public static void findAllPath(ArrayList<Edge>[] graph, int src, int dest, String path){
        if(src == dest){
            System.out.println(path+dest);
            return;
        }

        for(int i=0; i<graph[src].size(); i++){
            Edge e = graph[src].get(i);
            findAllPath(graph, e.dest, dest, path+src+" ");
        }

    }

    public static class Pair implements Comparable<Pair>{
         int n;
         int path;

         public Pair(int n, int path){
            this.n = n;
            this.path = path;
         }

         @Override
         public int compareTo(Pair p2){
            return this.path - p2.path;
         }

    }

    public static void dijkstra(ArrayList<Edge>[] graph, int src){
        int dis[] = new int[graph.length];
        for(int i=0; i<graph.length; i++){
            if(i != src){
                dis[i] = Integer.MAX_VALUE;
            }
        }

        boolean vis[] = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0));
        //loop

        while(!pq.isEmpty()){
            Pair curr = pq.remove();
            if(!vis[curr.n]){
                vis[curr.n] = true;
                //neighbours
                for(int i=0; i<graph[curr.n].size(); i++){
                    Edge e = graph[curr.n].get(i);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;

                    if(dis[u]+wt < dis[v]){
                        dis[v] = dis[u] + wt; 
                        pq.add(new Pair(v, dis[v]));
                    }
                }
            }

        }

        for(int i=0; i<dis.length; i++){
            System.out.print(dis[i]+" ");
        }

    }

    public static void bellmanFord(ArrayList<Edge>[] graph, int src){
        int dist[] = new int[graph.length];
        for(int i=0; i<dist.length; i++){
            if(i != src){
                dist[i] = Integer.MAX_VALUE;
            }
        }

        int V = graph.length;

        for(int i=0; i<V-1; i++){
            for(int j=0; j<graph.length; j++){
                for(int k=0; k<graph[j].size(); k++){
                    Edge e = graph[j].get(k);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;

                    if(dist[u]+wt < dist[v]){
                        dist[v] = dist[u]+wt;
                    }
                }
            }
        }

        for(int i=0; i<dist.length; i++){
            System.out.print(dist[i]+" ");
        }

    }

    public static class Pair2 implements Comparable<Pair2>{
        int vertex;
        int cost;

        public Pair2(int vertex, int cost){
            this.vertex = vertex;
            this.cost = cost;
        }

        @Override
        public int compareTo(Pair2 p2){
            return this.cost - p2.cost;
        }

    }

    public static void  primsAlgo(ArrayList<Edge>[] graph){
        boolean vis[] = new boolean[graph.length];
        PriorityQueue<Pair2> pq = new PriorityQueue<>();
        pq.add(new Pair2(0, 0));
        int finalCost = 0;

        while(!pq.isEmpty()){
            Pair2 curr = pq.remove();
            if(!vis[curr.vertex]){
                vis[curr.vertex] = true;
                finalCost += curr.cost;
                for(int i=0;i<graph[curr.vertex].size(); i++){
                    Edge e = graph[curr.vertex].get(i);
                    pq.add(new Pair2(e.dest, e.wt));
                }
            }
        }
        System.out.println("Final cost of MST: "+finalCost);
    }

    public static class Kstops implements Comparable<Kstops>{
        int n;
        int path;
        int stops;

        public Kstops(int n, int path,int stops){
            this.n = n;
            this.path = path;
            this.stops = stops;
        }

        @Override
        public int compareTo(Kstops p2){
            return this.stops - p2.stops;
        }

    }

    public static int cheapestFlight(ArrayList<Edge>[] graph, int src, int dest,int k){
        int[] dist = new int[k+2];
        for(int i=0; i<dist.length; i++){
            if(i != src){
                dist[i] = Integer.MAX_VALUE;
            }
        }
        PriorityQueue<Kstops> pq = new PriorityQueue<>();
        boolean vis[] = new boolean[k+2];
        pq.add(new Kstops(src, 0,0));

      while(!pq.isEmpty()){
         Kstops curr = pq.remove();
         if (curr.stops > k) {
        break;
    }
       
             for(int j=0; j<graph[curr.n].size(); j++){
            Edge e = graph[curr.n].get(j);
            int u = e.src;
            int v = e.dest;
            int wt = e.wt;
            if(dist[u] + wt < dist[v] && curr.stops <= k){
                dist[v] = dist[u] + wt;
                pq.add(new Kstops(e.dest, dist[v], curr.stops +1));
            }
        }
        
       
       
       }

       if(dist[dest] == Integer.MAX_VALUE){
        return -1;
       }else{

return dist[dest];
       }

       

    }


    public static void main(String[] args) {
        int V = 3;
        ArrayList<Edge>[] graph = new ArrayList[V];

        for(int i=0; i<V; i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1,100));
        graph[0].add(new Edge(0, 2,500));
        // graph[0].add(new Edge(0, 2,15));
        // graph[0].add(new Edge(0, 3,30));
        // graph[0].add(new Edge(0, 3));
        // graph[0].add(new Edge(0, 2,4));
        // graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 2,100));
        // graph[1].add(new Edge(1, 3,40));
        // graph[1].add(new Edge(1, 2,-4));
        // graph[1].add(new Edge(1, 3,7));
    

        // graph[2].add(new Edge(2,0, 15));
        // graph[2].add(new Edge(2,3, 50));
        // graph[2].add(new Edge(2,3, 2));
        // graph[2].add(new Edge(2, 4));
    

        // graph[3].add(new Edge(3, 0,30));
        // graph[3].add(new Edge(3, 1,40));
        // graph[3].add(new Edge(3, 2,50));
        // graph[3].add(new Edge(3, 4,4));

        // graph[4].add(new Edge(4, 1,-1));
        // graph[4].add(new Edge(4, 5,5));


        // graph[5].add(new Edge(5, 0));
        // graph[5].add(new Edge(5, 2));

        // for(int i=0; i<graph[2].size(); i++){
        //     Edge e = graph[2].get(i);
        //     System.out.println(e.dest);
        // }

        // bfs(graph);
        // System.out.println();
        // dfs(graph, 0, new boolean[V]);

        // System.out.println(hasPath(graph, 0, 6, new boolean[V]));

        // System.out.println(detectCycle(graph, V));

        // System.out.println(isCycle(graph));

        // topSort(graph);

        // findAllPath(graph, 5, 1, "");

        // dijkstra(graph, 0);

        // bellmanFord(graph, 0);

        // primsAlgo(graph);
        System.out.println(cheapestFlight(graph, 0, 2, 1));

    }

}
