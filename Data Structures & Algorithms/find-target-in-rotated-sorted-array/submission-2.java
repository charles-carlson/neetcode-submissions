class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        //binary search
        while(left <= right){
            int mid = left + (right - left) / 2;
            //check if found target
            if(nums[mid] == target){
                return mid;
            }
            //check for which half to eliminate from search
            if(nums[left] <= nums[mid]){
                //now check if target is inside the segment and narrow search
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            else {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

        }
        return -1;
    }
}