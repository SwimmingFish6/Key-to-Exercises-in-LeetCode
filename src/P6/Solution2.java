/**
 * Created by luxuhui on 2018/1/28.
 */
public class Solution2 {
    public String convert(String s, int numRows) {
        if (s.length() <= 2 || numRows <= 1) {
            return s;
        }

        StringBuilder re = new StringBuilder();

        int index = 0;

        for (int i = 0;i < numRows;i++) {
            index = i;
            if (i == 0 || i == numRows - 1) {
                while (index < s.length()) {
                    re.append(s.charAt(index));
                    index += 2 * numRows - 2;
                }
            }
            else {
                boolean flag = true;

                while (index < s.length()) {
                    re.append(s.charAt(index));

                    if (flag) {
                        index += 2 * numRows - 2 - 2 * i;
                        flag = !flag;
                    }
                    else  {
                        index += 2 * i;
                        flag = !flag;
                    }

                }
            }
        }

        return re.toString();
    }
}
