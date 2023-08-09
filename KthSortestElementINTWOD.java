import java.util.PriorityQueue;

public class KthSortestElementINTWOD {
    public static void main(String[] args) {
        int[][] arr = {{9, 11, 15},
       {10, 15, 17}};
       int k = 6;

       System.out.println(solve(arr,k));
    }
     public static int solve(int[][] A, int B) {
      PriorityQueue<Integer> minHeap = new PriorityQueue<>();

      //max heap will only carry the greater B no. of smaller element we will remove max element if we get any min val
      int n = A.length;
      int m = A[0].length;

     
        for(int i=0;i<n;i++){
            for(int j=0; j<m; j++){
                minHeap.add(A[i][j]);
            }
        }
        int count =1;
        while(count<= B-1){
            minHeap.remove();
            count++;
        }

     return minHeap.peek();   
    }
}
