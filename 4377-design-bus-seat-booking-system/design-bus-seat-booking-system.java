class BusBooking {
    int seats[][];
    int bookedTime;
    int minTime;
    public BusBooking(int n) {
        this.seats=new int[n][4];
        this.minTime=0;
        this.bookedTime=0;
    }
    
    public void toggle(String seat) {
        char lab=seat.charAt(0);
        int no=Integer.parseInt(seat.substring(1,seat.length()));
        if(lab=='A'){
            if(seats[no-1][0]!=0){
                minTime-=1;
                bookedTime-=seats[no-1][0];
            
                seats[no-1][0]=0;
            } 
            else{
                minTime+=1;
                if(seats[no-1][1]!=0){
                    seats[no-1][0]=3;
                    bookedTime+=3;
                }
                else{
                    seats[no-1][0]=1;
                    bookedTime+=1;
                }
            }
        }
        else if(lab=='D'){
            if(seats[no-1][3]!=0){
                minTime-=1;
                bookedTime-=seats[no-1][3];
                seats[no-1][3]=0;
            } 
            else{
                minTime+=1;
                if(seats[no-1][2]!=0){
                    seats[no-1][3]=3;
                    bookedTime+=3;
                }
                else{
                    seats[no-1][3]=1;
                    bookedTime+=1;
                }
            }
        }
        else{
            if(seats[no-1][lab-'A']!=0){
                // already booked 
                minTime-=1;
                bookedTime-=1;
                seats[no-1][lab-'A']=0;
            }
            else{
                bookedTime+=1;
                minTime+=1;
                seats[no-1][lab-'A']=1;
            }
        }
    }
    
    public int getTotalTime() {
        return bookedTime;
    }
    
    public int getMinTime() {
        return minTime;
    }
}

/**
 * Your BusBooking object will be instantiated and called as such:
 * BusBooking obj = new BusBooking(n);
 * obj.toggle(seat);
 * int param_2 = obj.getTotalTime();
 * int param_3 = obj.getMinTime();
 */