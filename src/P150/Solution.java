class Solution {
    public int evalRPN(String[] tokens) {
        LinkedList<Integer> stack = new LinkedList<Integer>();
        int op1, op2;
        
        for (int i = 0;i < tokens.length;i++) {
            if (tokens[i].equals("+")) {
                op2 = stack.pop();
                op1 = stack.pop();
                
                stack.push(op1 + op2);
            }
            else if (tokens[i].equals("-")) {
                op2 = stack.pop();
                op1 = stack.pop();
                
                stack.push(op1 - op2);
            }
            else if (tokens[i].equals("*")) {
                op2 = stack.pop();
                op1 = stack.pop();
                
                stack.push(op1 * op2);
            }
            else if (tokens[i].equals("/")) {
                op2 = stack.pop();
                op1 = stack.pop();
                
                stack.push(op1 / op2);
            }
            else {
                stack.push(Integer.parseInt(tokens[i]));
            }
            
        }
        
        return stack.pop();
    }
}