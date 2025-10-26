class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        vector<vector<int>> res;

        // Step 1: Sort the array
        sort(nums.begin(), nums.end());

        // Step 2: Loop through the array
        for (int k = 0; k < nums.size(); k++) {
            if (k > 0 && nums[k] == nums[k - 1]) continue;

            int target = -nums[k];
            int left = k + 1;
            int right = nums.size() - 1;

            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == target) {
                    res.push_back({nums[k], nums[left], nums[right]});
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    while (left < right && nums[right] == nums[right + 1]) right--;
                } 
                else if (sum < target) {
                    left++;
                } 
                else {
                    right--;
                }
            }
        }

        return res;
    }
};
