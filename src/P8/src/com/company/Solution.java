package com.company;

class Solution {
    public int myAtoi(String str) {
        int index = 0;
        int flag = 1;
        long result = 0;

        if (str.equals("") || str == null) {
            return 0;
        }

        while (index < str.length() && (str.charAt(index) == ' ' || str.charAt(index) == '\t')) {
            index++;
        }

        if (index >= str.length()) {
            return 0;
        }
        else {
            if (str.charAt(index) == '-') {
                flag = -1;
                index++;
            }
            else if (str.charAt(index) == '+') {
                index++;
            }
        }

        for (int i = index;i < str.length();i++) {
            if (str.charAt(i) < '0' || str.charAt(i) > '9' ) return flag * (int) result;
            else {
                result = result * 10 + str.charAt(i) - '0';

                if (flag == -1) {
                    if (result > 2147483648L) {
                        return -2147483648;
                    }
                }
                else {
                    if (result > 2147483647) {
                        return 2147483647;
                    }
                }
            }
        }

        return flag * (int) result;
    }
}