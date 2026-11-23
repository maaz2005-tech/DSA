class ProductOfNumbers {
    List<Integer> list;
    int n;
    int lzi=-1;
    public ProductOfNumbers() {
        this.list=new ArrayList<>();
        this.n=0;
    }
    
    public void add(int num) {
        if(num==0){
            lzi=n;
        }
        if(n==0 || list.get(n-1)==0 ) list.add(num);
        else list.add(num*list.get(n-1));
        n+=1;
    }
    
    public int getProduct(int k) {
        int previ=n-1-k;
        if(lzi>previ) return 0;

        if(n>=k){
            if(n==k||list.get(previ)==0) return list.get(n-1);
            return list.get(n-1)/list.get(previ);
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