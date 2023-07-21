class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n]; // dp[i] will store the length of the LIS that ends at index i
        int[] count = new int[n]; // count[i] will store the number of LIS that ends at index i
        
        int maxLen = 0; // Variable to keep track of the maximum length of LIS found so far
        
        for (int i = 0; i < n; i++) {
            dp[i] = 1; // Every element itself forms a valid LIS of length 1
            
            // For each element before nums[i], check if it can be added to form a longer LIS
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    // If nums[i] can be added to the LIS ending at index j to form a longer LIS, update dp[i]
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            
            // Update the maximum length of LIS found so far
            maxLen = Math.max(maxLen, dp[i]);
        }
        
        int ans = 0;
        // Count the number of LIS with maximum length
        for (int i = 0; i < n; i++) {
            if (dp[i] == maxLen) {
                ans += countLIS(nums, dp, count, i, maxLen);
            }
        }
        
        return ans;
    }
    
    public int countLIS(int[] nums, int[] dp, int[] count, int i, int len) {
        // If the LIS at index i has already been computed, return the count
        if (count[i] > 0) {
            return count[i];
        }
        
        // Base case: if the length of the LIS is 1, there is only one possible LIS
        if (len == 1) {
            return 1;
        }
        
        int ans = 0;
        // Recursively count the LIS by considering elements before index i
        for (int j = 0; j < i; j++) {
            if (nums[i] > nums[j] && dp[i] == dp[j] + 1) {
                ans += countLIS(nums, dp, count, j, len - 1);
            }
        }
        
        // Update the count for the current index
        count[i] = ans;
        return ans;
    }
}
