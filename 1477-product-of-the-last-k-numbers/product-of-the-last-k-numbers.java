class ProductOfNumbers {
    List<Integer> list;
    int n;
    public ProductOfNumbers() {
        this.list=new ArrayList<>();
        this.n=0;
    }
    
    public void add(int num) {
        list.add(num);
        n+=1;
    }
    
    public int getProduct(int k) {
        if(n>=k){
            int ans=1;
            for(int i=n-1;i>=(n-k);i--){
                ans*=list.get(i);
            }
            return ans;
        }
        return -1;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */