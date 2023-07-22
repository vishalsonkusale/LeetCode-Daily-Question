class Solution {
    int[] xDir = {-2, 2, 2, -2, -1, 1, 1, -1};
    int[] yDir = {-1, 1, -1, 1, 2, -2, 2, -2};
    public double knightProbability(int n, int k, int row, int column) {
        if(k == 0)
            return 1;
        double[][][] dp = new double[n+1][n+1][k+1];
        for(double[][] i : dp){
            for(double[] j : i){
                Arrays.fill(j, -1);
            }
        }
        return solve(n, k, row, column, dp);
    }
    public boolean valid(int x, int y, int n){
        if(x < 0 || y < 0 || x >= n || y >= n){
            return false;
        }
        return true;
    }
    public double solve(int n, int k, int i, int j, double[][][] dp){
        if(k == 0){
            return 1;
        }

        if(i < 0 || j < 0 || i>=n || j>=n){
            return 0;
        }
        if(dp[i][j][k] != -1)
            return dp[i][j][k];
        double ans = 0.0;
        for(int it = 0; it < 8; it++){
            int x = i + xDir[it];
            int y = j + yDir[it];
            if(valid(x, y, n)){
                ans += solve(n, k-1, x, y, dp)*(1.0/8.0);
            }
        }
        return dp[i][j][k] = ans;
    }
}
