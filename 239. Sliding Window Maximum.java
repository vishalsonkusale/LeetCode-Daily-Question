class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int i = 0, j = 0;
        int[] ans = new int[nums.length - k + 1];
        int p = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());
        while(j < nums.length){
            int winSize = j - i + 1;
            hm.put(nums[j], hm.getOrDefault(nums[j], 0) + 1);
            set.add(nums[j]);
            if(winSize < k){
                j++;
            }
            if(winSize == k){
                ans[p++] = set.first();
                if(hm.get(nums[i]) == 1){
                    hm.remove(nums[i]);
                    set.remove(nums[i]);
                }else{
                    hm.put(nums[i], hm.get(nums[i]) - 1);
                }
                i++;
                j++;
            }
        }
        return ans;
    }
}
