class Solution {
    double radius;
    double x_center;
    double y_center;

    public Solution(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.x_center = x_center;
        this.y_center = y_center;
    }
    
    public double[] randPoint() {
        double angle = Math.random() * 2 * Math.PI;
        double[] res = new double[2];
        double len = Math.sqrt(Math.random()) * radius;
        
        res[0] = x_center + len * Math.cos(angle);
        res[1] = y_center + len * Math.sin(angle);
        
        return res;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(radius, x_center, y_center);
 * double[] param_1 = obj.randPoint();
 */