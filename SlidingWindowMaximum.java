import java.util.*;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] arr = {7,2,4};
         int k =2;

         System.out.println(Arrays.toString(maxSlidingWindow(arr,k)));
    }
    public static int[] maxSlidingWindow(int[] nums, int k){
        List<Integer> ls = new ArrayList<>();
        int n=nums.length;

        Deque<Integer> q = new ArrayDeque<Integer>();

        for(int i =0;i<n; i++){
            while(!q.isEmpty() && q.peekFirst() <= i-k){
                q.pollFirst();
            }

            while(!q.isEmpty() && nums[i]>= nums[q.peekLast()]){
                q.pollLast();
            }

            q.addLast(i);


            if(i>= k-1){
                ls.add(nums[q.peekFirst()]);
            }
        }

        int[] ans = new int[ls.size()];
        for(int p =0; p<ls.size(); p++){
            ans[p] = ls.get(p);
        }

        return ans;

    }
}
