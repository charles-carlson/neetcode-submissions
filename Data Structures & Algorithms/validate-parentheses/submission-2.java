class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            char bracket = s.charAt(i);
            if(bracket == '(' || bracket == '[' || bracket == '{'){
                stack.push(bracket);
            }
            if (bracket == ')' || bracket == ']' || bracket == '}'){
                if (stack.isEmpty()) return false;
                char top = stack.peek();
                if(top == '(' && bracket != ')'){
                    return false;
                }
                if(top == '[' && bracket != ']'){
                    return false;
                }
                if(top == '{' && bracket != '}'){
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
