import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class KLargestElements {
    public static void main(String[] args) {
        
    
     int[] arr = {8,3,10,4,11,2,7,1,14,9};
     int k =4;

        System.out.println(Arrays.toString(kLargestEmement(arr, k)));
    }
    public static int[] kLargestEmement(int[] arr , int k){
        int[] ans = new int[k];
        
        //max heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        //add first k elements in minHeap
        for(int i =0; i<k; i++){
            minHeap.add(arr[i]);
        }

        //know check if the current A[k] is larger than minHeap.peek than remove maxHeap 1 element and 
        for(int i =k; i<arr.length; i++){
            int temp = minHeap.peek();
            if(arr[i]> temp){
                minHeap.poll();
                minHeap.add(arr[i]);
            }
        }

        //know simply just extract all the max heap element as only smallest are left in MaxHeap

        for(int i=0; i<ans.length; i++){
            ans[i] = minHeap.poll();
        }

        return ans;
    }
}
