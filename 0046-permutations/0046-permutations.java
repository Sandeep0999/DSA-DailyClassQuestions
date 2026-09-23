class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(new ArrayList<>(), used, nums);
        return ans;
    }
    public void backtrack(List<Integer> curr, boolean []used, int nums[]){
        if(curr.size() == nums.length){
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int i=0; i<nums.length; i++){
            if(used[i]) continue;
            used[i] = true;
            curr.add(nums[i]);
            backtrack(curr, used, nums);
            curr.remove(curr.size()-1);
            used[i] = false;
        }
    }
}