class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Comparator.reverseOrder());
        for(int x:nums) pq.add(x);
        while(k>1){
            pq.remove();
            k--;
        }
        return pq.peek();
    }
}