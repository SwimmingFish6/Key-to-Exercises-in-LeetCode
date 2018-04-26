class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int res = Math.abs(A - C) * Math.abs(D - B) + Math.abs(E - G) * Math.abs(F - H);
        
        if (E > C || G < A || H < B || F > D) {
            return res;
        }
        
        int width = Math.min(H, D) - Math.max(F, B);
        
        int length = Math.min(G, C) - Math.max(A, E);
        
        res -= width * length;
        
        return res;
    }
}