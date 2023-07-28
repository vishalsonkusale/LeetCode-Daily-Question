class Solution {
    public int solve(int i,int j,int turn,int[] nums,int[][][] dp)
    {
        if(i>j)
            return 0;
        if(dp[i][j][turn]!=0)
            return dp[i][j][turn];
        if(turn==1)
            return dp[i][j][turn]= Math.max(nums[i]+solve(i+1,j,0,nums,dp),nums[j]+solve(i,j-1,0,nums,dp));
        else
            return dp[i][j][turn]= Math.min(solve(i+1,j,1,nums,dp),solve(i,j-1,1,nums,dp));
        
    }
    public boolean PredictTheWinner(int[] nums) {
        int player1=0,player2=0,sum=0;
        int[][][] dp=new int[nums.length+1][nums.length+1][2];
        for(int i=0;i<nums.length;i++)
            sum+=nums[i];
        player1=solve(0,nums.length-1,1,nums,dp);
        player2=sum-player1;
        if(player1>=player2)
            return true;
        return false;
    }
}
