class Solution {
    public boolean isValid(String s) {
        if(s.length() == 1) return false;
        return balanceParen(s);
    }

    private static boolean balanceParen(String s){
        Stack<Character> paren = new Stack<>();

        for(int i = 0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '(' || ch == '{' || ch == '[' || paren.isEmpty()){
                paren.push(ch);
            }
            else if((!paren.isEmpty())
                    && (paren.peek() == '(' && ch == ')' 
                    || paren.peek() == '{' && ch == '}' 
                    || paren.peek() == '[' && ch == ']')){
                paren.pop();
            }
            else paren.push(ch);
        }
        return paren.isEmpty();
    }
}