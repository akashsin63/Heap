import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class KPlaceApart {
    /**
     * @param args
     */
    public static void main(String[] args){
        int[] arr = {1,40,2,3};
        int k=2;

        System.out.println(Arrays.toString(KplaceApart(arr,k)));
    }
    public static int[] KplaceApart(int[] A, int B){
        List<Integer> ans = new ArrayList<>();
        PriorityQueue<Integer> minQ= new PriorityQueue<>();
        
        //slidimg window adding first 3 element till B in min queue\
        int minCount = Math.min(A.length, B + 1);
        for(int i =0; i<minCount; i++){
            minQ.add(A[i]);
        }

        int j=B+1;
        while(j<A.length){
            ans.add(minQ.peek());
            minQ.poll();
            minQ.add(A[j]);
            j++;
        }
        //remaining element in q we will simply just iterate in PriorityQueue
        Iterator<Integer> itr = minQ.iterator();
 
        while (itr.hasNext()) {
            ans.add(minQ.peek());
            minQ.poll();
        }
        
        int res[] = new int[A.length];
        for(int i =0; i<A.length; i++){
            res[i] = ans.get(i);
        }
        return res;
    }
}
