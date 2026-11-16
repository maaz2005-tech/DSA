class Solution {
    public String digitSum(String s, int k) {
        StringBuilder sb=new StringBuilder(s);
        while(sb.length()>k){
            int sum=0;
            StringBuilder temp=new StringBuilder();
            for(int i=0;i<sb.length();i++){
                sum+=(sb.charAt(i)-'0');
                if((i+1)%k==0 || i==sb.length()-1){
                    temp.append(String.valueOf(sum));
                    sum=0;
                }
            }
            sb=temp;
        }
        return sb.toString();
    }
}