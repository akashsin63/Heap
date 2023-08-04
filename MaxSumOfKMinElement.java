import java.util.*;

public class MaxSumOfKMinElement {
    public static void main(String[] args) {
        int[] arr = {24, -68, -29, -9, 84};
        int K = 4;

       System.out.println(maxSum(arr, K));
    }
    
    public static int maxSum(int[] A , int B){
       int totalSum =0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        //add all elements in minHeap 
        for(int i=0; i<A.length; i++){
            minHeap.add(A[i]);
        }
        //now only k smaller element and change it  
        for(int i=0; i<B; i++){
            int temp=minHeap.remove();
            minHeap.add(-temp);
        }  
        
        // know simply add all the maxest element remains add them
        while(minHeap.size()>0){
            totalSum+=minHeap.remove();
        }
        
        return totalSum;
    }
}
