//1389. Create Target Array in the Given Order

class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i=0; i<index.length; i++) {
            ans.add(index[i],nums[i]);
        }

        int arr[] = new int[ans.size()];
        for(int i=0; i<ans.size(); i++) {
            arr[i] = ans.get(i);
        }
        return arr;
    }
}