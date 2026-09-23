class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        helper(0,nums,ans);
        return ans;
    }
    public void helper(int idx,int nums[],List<List<Integer>> ans){
        if(idx == nums.length){
            List<Integer> current = new ArrayList<>();
            for (int num : nums) current.add(num);
            ans.add(new ArrayList<>(current));
            return;
        }
        Set<Integer> used = new HashSet<>();
        for(int i=idx;i<nums.length;i++){
            if(used.contains(nums[i])) continue;
            used.add(nums[i]);
            swap(i,idx,nums);
            helper(idx+1,nums,ans);
            swap(i,idx,nums);
        }
    }
    public void swap(int i, int j, int nums[]){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}