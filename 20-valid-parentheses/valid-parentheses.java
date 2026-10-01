class Solution {
    public boolean isValid(String s) {
        Stack<Character> s1=new Stack();
        for(char ch:s.toCharArray()){
            if(ch=='(' || ch=='[' || ch=='{'){
                s1.push(ch);
            }
            else{
                if(ch==')'){
                    if(s1.isEmpty() || s1.peek()!='(') return false;
                    s1.pop();
                }
                if(ch=='}'){
                    if(s1.isEmpty() || s1.peek()!='{') return false;
                    s1.pop();
                }
                if(ch==']'){
                    if(s1.isEmpty() || s1.peek()!='[') return false;
                    s1.pop();
                }
            }
        }
        return s1.isEmpty();
    }
}