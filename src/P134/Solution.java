class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int res = -1;
        int bPos = 0;
        int curGas = 0;
        int step = 0;
        int totalStep = 0;

        while (bPos < gas.length) {
            int index = bPos + step + 1 != gas.length?(bPos + step + 1) % gas.length - 1:gas.length - 1;

            curGas += gas[index] - cost[index];

            if (curGas < 0) {
                bPos = bPos + step + 1;
                step = 0;
                curGas = 0;
            }
            else {
                if (step + 1 == gas.length) return bPos;

                step++;
            }
        }

        return -1;
    }
}