class Solution {
    public String multiply(String num1, String num2) {
        int flag = 0;
        int length1 = num1.length(), length2 = num2.length();
        int[] result = new int[length1 + length2];
        StringBuilder sb = new StringBuilder();

        for (int i = length1 - 1;i >= 0;i--) {
            for (int j = length2 - 1;j >= 0;j--) {
                int temp = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                temp += result[i + j + 1];

                result[i + j] += temp / 10;
                result[i + j + 1] = temp % 10;
            }
        }

        int p;

        for (p = 0;result[p]==0;p++);

        for (;p < result.length;p++) sb.append(result[p]);

        return sb.toString().equals("")?"0":sb.toString();
    }
}