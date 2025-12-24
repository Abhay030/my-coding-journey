class Solution {
    public String interpret(String command) {
        Stack<Character> st  = new Stack<>();
        StringBuilder s = new StringBuilder();

        for(int i = 0; i < command.length(); i++){
            char ch = command.charAt(i);
            if(!st.isEmpty() && (st.peek() == '(' && ch == ')')){
                s.append("o");
                st.pop();
            }
            else if(!st.isEmpty() && (st.peek() == '(' && ch == 'a')){
                s.append("al");
                st.pop();
                i = i + 1;
            }
            else if(ch == 'G'){
                s.append("G");
            }
            else{
                st.push(ch);
            }
        }

        return s.toString();
    }
}