class Solution {
    void solve(String s,int i,StringBuilder sb,List<String> res,int n){
        if(i==n){
            res.add(sb.toString());
            return ;
        }
        for(char ch:arr[s.charAt(i)-'0'].toCharArray()){
            sb.append(ch);
            solve(s,i+1,sb,res,n);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    String arr[]={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> res=new ArrayList<>();
        solve(digits,0,new StringBuilder(),res,digits.length());
        return res;
    }
}