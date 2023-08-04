import java.util.ArrayList;
import java.util.PriorityQueue;

public class ProductOf3 {
    public static void main(String[] args) {
        int[] arr = {10,2,13,4};
        ArrayList<Integer> A = new ArrayList<>();

        for(int i =0;i<arr.length; i++){
            A.add(arr[i]);
        }

        System.out.println(productOfThree(A));
    }
    public static ArrayList<Integer> productOfThree(ArrayList<Integer> A){
        ArrayList<Integer> list = new ArrayList<>();

        if(A.size() < 1 || A.size() <2){
            for(int i =0; i<A.size(); i++){
                 list.add(-1);
            }

            return list;
        }

        PriorityQueue<Integer> minPQ = new PriorityQueue<>();

        //fill first two position as -1 also add only 3 elements in minPQ
        for(int i =0; i<3; i++){
            minPQ.add(A.get(i));

            if(i<2){
               list.add(-1);
            }
        }
        int max = getMaxOf3(minPQ);
        list.add(max);

        for (int i = 3; i < A.size(); i++) {
            int val = A.get(i);
            int minVal = minPQ.peek();

            if (val > minVal) {
                minPQ.poll();
                minPQ.add(val);
            }

            max = getMaxOf3(minPQ);
            list.add(max);
        }
      return list;
    }
    private static int getMaxOf3(PriorityQueue < Integer > minPQ) {
    int res = 1;
    for (int v: minPQ) {
      res = res * v;
    }
    return res;
    
    }
}
