class Solution {
    public List<List<Integer>> result = new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> road = new LinkedList<Integer>();

        backtrack(road, nums);
        return result;
    }

    public void backtrack(List<Integer> road, int[] nums){
        if(road.size() == nums.length){
            result.add(new ArrayList(road));
            return;
        }
        int num;
        for(int i = 0; i < nums.length; i++){
            num = nums[i];
            if(road.contains(num))
                continue;

            road.add(num);
            backtrack(road, nums);

            road.remove(num);
        }

    }
}