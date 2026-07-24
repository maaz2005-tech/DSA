class Solution {
    public String rearrangeString(String s, char x, char y) {
        int numX=0,numY=0;
        for(char ch:s.toCharArray()){
            if(ch==x) numX++;
            else if(ch==y) numY++;
        }
        StringBuilder sb=new StringBuilder();
        while(numY>0){
            sb.append(y);
            numY--;
        }
        while(numX>0){
            sb.append(x);
            numX--;
        }
        for(char ch:s.toCharArray()){
            if(ch==x || ch==y) continue;
            sb.append(ch);
        }
        return sb.toString();
    }
}