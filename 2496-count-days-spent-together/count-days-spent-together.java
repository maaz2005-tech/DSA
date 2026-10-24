class Solution {
    boolean isGreater(String a, String b){
        return a.compareTo(b) >= 0;
    }
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int months[]={31,28,31,30,31,30,31,31,30,31,30,31};
        int ans=0;
        for(int i=1;i<=12;i++){
            String month=(i<10)?("0"+String.valueOf(i)):(String.valueOf(i));
            // System.out.println(month);
            for(int j=1;j<=months[i-1];j++){
                String day=(j<10)?("0"+String.valueOf(j)):(String.valueOf(j));
                String date=month+"-"+day;
                if(isGreater(date,arriveAlice)&&isGreater(leaveAlice,date) && isGreater(date,arriveBob) && isGreater(leaveBob,date)) ans++;
            }
        }
        return ans;
    }
}