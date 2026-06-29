
import java.util.*;

public class GraphB {
    public static class Edge{
        int src;
        int dest;
        

        public Edge(int s, int d){
            this.src = s;
            this.dest = d;
           
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

    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge>[] graph = new ArrayList[V];

        for(int i=0; i<V; i++){
            graph[i] = new ArrayList<>();
        }

        // graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 3));
        // graph[0].add(new Edge(0, 2));
        // graph[0].add(new Edge(0, 3));

        // graph[1].add(new Edge(1, 2));
        // graph[1].add(new Edge(1, 3));
    

        graph[2].add(new Edge(2, 3));
        // graph[2].add(new Edge(2, 4));
    

        // graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 1));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));


        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));

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

        findAllPath(graph, 5, 1, "");

    }

}
