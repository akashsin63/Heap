import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class KSmallest{
    public static void main(String[] args) {
        int[] arr = {8,3,10,4,11,2,7,1,14,9};
        int k =4;

        System.out.println(Arrays.toString(kSmallestEmement(arr, k)));
    }
    public static int[] kSmallestEmement(int[] arr , int k){
        int[] ans = new int[k];
        
        //max heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        //add first k elements in maxHeap
        for(int i =0; i<k; i++){
            maxHeap.add(arr[i]);
        }

        //know check if the current A[k] is smaller than maxHeap.peek than remove maxHeap 1 element and 
        for(int i =k; i<arr.length; i++){
            int temp = maxHeap.peek();
            if(arr[i]< temp){
                maxHeap.poll();
                maxHeap.add(arr[i]);
            }
        }

        //know simply just extract all the max heap element as only smallest are left in MaxHeap

        for(int i=0; i<ans.length; i++){
            ans[i] = maxHeap.poll();
        }

        return ans;
    }
}