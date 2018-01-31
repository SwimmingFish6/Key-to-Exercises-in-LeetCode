class Solution {
    public String intToRoman(int num) {
        int x = num;
        String re = "";
        int power = 1000;
        int bit = num / power;



        for (int j = 0;j < bit;j++) {
            re +=  'M';
        }

        num -= power * (int) (num / power);
        power /= 10;
        bit = num / power;

        re = bitToRoman(re, bit, 'M', 'D', 'C');

        num -= power * (int) (num / power);
        power /= 10;
        bit = num / power;

        re = bitToRoman(re, bit, 'C', 'L', 'X');

        num -= power * (int) (num / power);
        power /= 10;
        bit = num / power;

        re = bitToRoman(re, bit, 'X', 'V', 'I');

        return re;


    }

    private String bitToRoman(String re, int bit, char high, char med, char low) {
        if (bit == 9) {
            re += low;
            re += high;

            return re;
        }


        if (bit >= 5) { re += med; bit -= 5;}

        if (bit <= 3) {
            for (int j = 0;j < bit;j++) {
                re += low;
            }
        }

        else {
            for (int j = 0;j < 5 - bit;j++) {
                re += low;
            }

            re += med;
        }
        return re;
    }
}