class Solution {
    public int[] resultArray(int[] nums) {
        int n=nums.length;
        Stack<Integer> s1=new Stack();
        Stack<Integer> s2=new Stack();
        s1.push(nums[0]);
        s2.push(nums[1]);
        int i=2;
        while(i<n){
            if(s1.peek()>s2.peek()){
                s1.push(nums[i]);
            }
            else{
                s2.push(nums[i]);
            }
            i++;
        }
        int ans[]=new int[n];
        i=n-1;
        while(!s2.isEmpty()){
            ans[i--]=s2.pop();
        }
        while(!s1.isEmpty()){
            ans[i--]=s1.pop();
        }
        return ans;
    }
}