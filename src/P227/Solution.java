import java.util.*;

import java.util.*;

class Solution {
    public int calculate(String s) {
        LinkedList<Character> opStack = new LinkedList<Character>();
        LinkedList<Integer> numStack = new LinkedList<Integer>();
        int index = 0;

        while (index < s.length()) {
            if (s.charAt(index) == ' ') {
                index++;
                continue;
            }

            if (s.charAt(index) >= '0' && s.charAt(index) <= '9') {
                int tmp = 0;

                while (index < s.length() && s.charAt(index) >= '0' && s.charAt(index) <= '9') {
                    tmp = tmp * 10 + s.charAt(index) - '0';
                    index++;
                }

                numStack.push(tmp);
            }
            else {

                while (!opStack.isEmpty() && priority(s.charAt(index), opStack.peek())) {
                    char op = opStack.pop();
                    int num2 = numStack.pop();
                    int num1 = numStack.pop();
                    numStack.push(operator(num1, num2, op));
                }

                opStack.push(s.charAt(index));
                index++;
            }

        }

        while (!opStack.isEmpty()) {
            char op = opStack.pop();
            int num2 = numStack.pop();
            int num1 = numStack.pop();
            numStack.push(operator(num1, num2, op));
        }

        return numStack.peek();
    }

    public boolean priority(char op1, char op2) {

        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')) {
            return false;
        }


        return true;
    }

    public int operator(int num1, int num2, char op) {
        if (op == '+') {
            return num1 + num2;
        }
        else if (op == '-') {
            return num1 - num2;
        }
        else if (op == '*') {
            return num1 * num2;
        }
        else {
            return num1 / num2;
        }

    }
}