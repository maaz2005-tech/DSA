class Solution {
    class Info{
        int x,c;
        public Info(int x,int c){
            this.x=x;
            this.c=c;
        }
    }
    public long shadowPairs(int[] nums) {
        Stack<Info> s=new Stack();
        long ans=0;
        int n=nums.length;
        long total=0;
        for(int i=0;i<n;i++){
            while(!s.isEmpty() && s.peek().x>nums[i]){
                total-=s.pop().c;
            }
            if(s.isEmpty()){
                s.push(new Info(nums[i],1));
                total++;
            }
            else if(s.peek().x==nums[i]){
                s.peek().c++;
                total++;
                ans+=total-s.peek().c;
            }
            else{
                s.push(new Info(nums[i],1));
                ans+=total;
                total++;
            }
            
        }
        return ans;
    }
}