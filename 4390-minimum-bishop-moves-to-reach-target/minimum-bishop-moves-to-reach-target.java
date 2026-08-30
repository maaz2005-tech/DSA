class Solution {
    public int minBishopMoves(int[] s, int[] t) {
        if((s[0]+s[1])%2!=(t[0]+t[1])%2) return -1;
        if(Math.abs(s[0]-t[0])==Math.abs(s[1]-t[1])){
            return 1;
        }
        return 2;
    }
}