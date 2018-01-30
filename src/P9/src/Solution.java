class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;

        int num = x;
        int length = 0;

        while (num !=0 ) {
            num /= 10;
            length++;
        }

        num = x;

        if (length <= 1) {
            return true;
        }

        int power_end = (int) Math.pow(10, length - 1);
        int power_begin = 10;


        while (num != 0) {
            int endBit = num / power_end;
            int beginBit = num % power_begin;

            if ( endBit != beginBit) {
                return false;
            }
            else {
                num = (num % power_end) / 10;
                power_end /= 100;
            }
        }

        return true;
    }
}
//class Solution {
//    public boolean isPalindrome(int x) {
//        if (x < 0) return false;
//
//        String num = new Integer(x).toString();
//        int length = num.toString().length();
//        int bit = 0;
//
//        if (length == 1) {
//            return true;
//        }
//
//        while (bit < length / 2) {
//            char endBit = num.charAt(bit);
//            char beginBit = num.charAt(length - bit - 1);
//
//            if ( endBit != beginBit) {
//                return false;
//            }
//            else {
//                bit++;
//            }
//        }
//
//        return true;
//    }
//}