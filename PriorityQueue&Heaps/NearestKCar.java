
import java.util.PriorityQueue;

public class NearestKCar {
    
    public static class Point implements Comparable<Point>{
        int x;
        int y;
        int destSq;
        int idx;

        public Point(int x, int y, int destSq, int idx){
            this.x = x;
            this.y = y;
            this.destSq = destSq;
            this.idx = idx;
        }

        @Override
        public int compareTo(Point p2){
            return this.destSq - p2.destSq;
        }
    }

    public static void main(String[] args) {
        int pts[][] = {{3,3}, {5,-1}, {-2,4}};
        int k = 2;

        PriorityQueue<Point> pq = new PriorityQueue<>();

        for(int i = 0; i<pts.length; i++){
            int destSq = pts[i][0]*pts[i][0] + pts[i][1]*pts[i][1];
            pq.add(new Point(pts[i][0], pts[i][1], destSq, i));
        }

        for(int i=0; i<k; i++){
            System.out.println("C"+pq.remove().idx );
        }

    }
}
