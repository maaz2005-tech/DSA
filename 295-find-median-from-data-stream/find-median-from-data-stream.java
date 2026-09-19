class MedianFinder {
    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;
    public MedianFinder() {
        this.left=new PriorityQueue<>(Comparator.reverseOrder());
        this.right=new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        left.add(num);
        right.add(left.remove());
        while(left.size()<right.size()){
            left.add(right.remove());
        }
    }
    
    public double findMedian() {
        if(left.size()==right.size()){
            double x=left.peek()+right.peek();
            return x/2;
        }
        return (double)left.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */