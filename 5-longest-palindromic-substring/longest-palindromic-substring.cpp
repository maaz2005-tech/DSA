class Solution {
public:
    vector<int> solve(string s,int i){
        int l=i-1,r=i+1;
        vector<int>ans={i,i};
        while(r<s.length() && s[i]==s[r]){
            ans[1]=r++;
        }
        while(l>=0 && r<s.length()){
            if(s[l]!=s[r]) break;
            ans[0]=l--;
            ans[1]=r++;
        }
        return ans;
    }
    string longestPalindrome(string s) {
        int n=s.length();
        int len=0;
        string ans="";
        for(int i=0;i<n;i++){
            vector<int>curr=solve(s,i);
            if(len<curr[1]-curr[0]+1){
                len=curr[1]-curr[0]+1;
                ans=s.substr(curr[0],len);
            }
        }
        return ans;
    }
};

/*
        int n=s.length();
        int maxLen=1;
        for(int i=1;i<n-1;i++){
            int len=0;
            if(s[i]!=s[i-1] && s[i]!=s[i+1]){
                int l=i-1,r=i+1;
                while(s[l]==s[r]) l--,r++;
            }
            
            
        }

*/
