/**
 * Created by luxuhui on 2018/1/28.
 */
class Solution {
    public String convert(String s, int numRows) {
        if (s.length() <= 2 || numRows <= 1) {
            return s;
        }

        int size = numRows * 2 - 2;
        int times = s.length() / size + 1;
        int length = times * (numRows);
        int width = numRows;
        char[][] matrix = new char[width][length];

        for (int i = 0;i < s.length();i++) {
            if ((i + 1) % size == 0) {
                matrix[2 * numRows - size - 1][(numRows - 1) * ((i + 1) / size - 1) + size - numRows] = s.charAt(i);
            }
            else if ((i + 1) % size <= numRows) {
                matrix[i % size][(numRows - 1) * ((i + 1) / size) ] = s.charAt(i);
            }
            else {
                matrix[2 * numRows - (i + 1 ) % size - 1][(numRows - 1) * ((i + 1) / size) + (i + 1) % size - numRows] = s.charAt(i);
            }
        }

        String re = "";

        for (int i = 0;i < width;i++) {
            int index = 0;

            if (i == 0 || i == numRows - 1){
                while (matrix[i][index] != '\0') {
                    re += matrix[i][index];
                    index += numRows - 1;
                }
            }
            else {
                boolean flag = true;
                while (matrix[i][index] != '\0') {
                    re += matrix[i][index];
                    if (flag) {
                        index += numRows - 1 - i;
                        flag = !flag;
                    }
                    else {
                        index += i;
                        flag = !flag;
                    }
                }
            }
        }

        return re;
    }
}