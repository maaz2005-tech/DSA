class Solution {
    public int minInsertions(String str) {
        int ans=0;
        int x=0;
        boolean prev=false;
        Stack<Boolean> s=new Stack();
        for(char ch:str.toCharArray()){
            if(ch=='('){
                if(prev){
                    if(s.isEmpty()){
                        ans+=2;
                    }
                    else{
                        ans++;
                        s.pop();
                    }
                    prev=false;
                }
                s.push(true);
            }
            else{
                if(!prev){
                    prev=true;
                }
                else{
                    if(s.isEmpty()){
                        x++;
                    }
                    else{
                        s.pop();
                    }
                    prev=false;
                }
            }
        }
        if(prev){
            if(s.isEmpty()) ans+=2;
            else{
                ans++;
                s.pop();
            }
        }
        return ans+s.size()*2+x;
    }
}