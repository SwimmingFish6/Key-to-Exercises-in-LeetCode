/**
 * Created by luxuhui on 2018/1/31.
 */
import java.util.*;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();

        addParenthesis(list, "", n, n);

        return list;
    }

    public void addParenthesis(List<String> list, String seq, int left, int right) {

        if (left == 0 && right == 0) {
            list.add(seq);
            return;
        }

        if (left > 0) addParenthesis(list, seq + '(', left - 1, right);
        if (right > left) addParenthesis(list, seq + ')', left, right - 1);
    }
}
