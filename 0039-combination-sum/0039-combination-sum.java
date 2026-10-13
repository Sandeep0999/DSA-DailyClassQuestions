class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        findCombination(0,candidates,target ,list, new ArrayList<>());
        return list;
    }
    public void findCombination(int idx,int candidates[],int t,List<List<Integer>>list,List<Integer>ele){
        // base condition : 
        if(idx == candidates.length){
            if(t == 0){
                list.add(new ArrayList<>(ele));
            }
            return;
        }
        // work : 
        // 1st step : to pick :
            if(candidates[idx] <= t){
                ele.add(candidates[idx]);
                findCombination(idx,candidates,t-candidates[idx],list,ele);
                ele.remove(ele.size()-1);
            }
        // 2nd step  :to not pick :
        findCombination(idx + 1,candidates,t,list,ele);
    }
}