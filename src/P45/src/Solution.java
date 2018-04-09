class Solution {
    public int jump(int[] nums) {
        int[][] map = new int[nums.length][nums.length];
        int[][] path = new int[nums.length][nums.length];
        int[] dist = new int[nums.length];

        for (int i = 0;i < nums.length;i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        int validNode = 0;
        dist[0] = 0;

        while (validNode < nums.length) {

            for (int i = validNode + 1; i < nums.length; i++) {
                if (validNode + nums[validNode] >= i) {
                    if (1 + dist[validNode] < dist[i]) {
                        dist[i] = 1 + dist[validNode];
                    }
                }
            }

            validNode++;
        }

        return dist[nums.length - 1];
    }
}