import java.util.*;

public class KClosePointToOrigin {
    public static void main(String args[]){
        int[][] points = {
            {1,3},{-2,2}
        };
        int k=1;

        System.out.println(Arrays.deepToString(kClosest(points,k)));
    }
    public static int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> pq= new PriorityQueue<>((a,b) -> Integer.compare(a.key,b.key));

        int[] dist=new int[points.length];

        //calculating distance
        for(int i =0; i<points.length; i++){
            int x = points[i][0];
            int y = points[i][1];

            dist[i] = (x*x) + (y*y);

            pq.add(new Pair(dist[i] , points[i])); 
        }


        //know just finding k answer from minQueue
        int i=0;

        int[][] ans = new int[k][2];
        while(i<k){
            ans[i]= pq.remove().p;
            i++;
        }
        return ans;
    }
}
class Pair{
    int key;
    int[] p;

    public Pair(int key, int[] p){
        this.key= key;
        this.p = p;
    }
}
