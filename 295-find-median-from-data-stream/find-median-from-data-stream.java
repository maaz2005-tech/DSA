class MedianFinder {
    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;
    public MedianFinder() {
        this.left=new PriorityQueue<>(Comparator.reverseOrder());
        this.right=new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        left.add(num);
        right.add(left.poll());
        while(right.size()>left.size()){
            left.add(right.poll());
        }
    }
    
    public double findMedian() {
        if(left.size()>right.size()){
            return (double)left.peek();
        }
        else{
            return (left.peek()+(double)right.peek())/2;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */