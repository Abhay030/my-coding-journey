class Solution {
    public boolean isValid(String s) {
        if(s.length() == 1) return false;
        return balanceParen(s);
    }

    private static boolean balanceParen(String s){
        Stack<Character> paren = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);

            // Push if opening bracket
            if(ch == '(' || ch == '{' || ch == '['){
                paren.push(ch);
            }
            // Handle closing brackets
            else if(ch == ')' && !paren.isEmpty() && paren.peek() == '('){
                paren.pop();
            }
            else if(ch == '}' && !paren.isEmpty() && paren.peek() == '{'){
                paren.pop();
            }
            else if(ch == ']' && !paren.isEmpty() && paren.peek() == '['){
                paren.pop();
            }
            else {
                // Closing bracket without matching opening
                return false;
            }
        }
        return paren.isEmpty();
    }
}
