class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        int n=list1.length;
        int m=list2.length;
        int count=0;
        int min=n+m;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(list1[i].equals(list2[j])){
                    if(min>i+j){
                        min=i+j;
                        count=1;
                    }
                    else if(min==i+j){
                        count+=1;
                    }
                }
            }
        }
        String ans[]=new String[count];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(list1[i].equals(list2[j])){
                    if(min==i+j){
                        ans[count-1]=list1[i];
                        count--;
                    }
                }
            }
        }
        return ans;
    }
}