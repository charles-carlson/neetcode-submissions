class Solution {
    public int maxArea(int[] heights) {
        //water area, distaince from ith to jth heights
        //choose longest and tallest as possible
        //two pointers, left and right
        //take the area by distance * min(i,j)
        //increment moving smaller height bar inwards
        int best = 0;
        int i = 0;
        int j = heights.length - 1;
        while(i < j){
            int area = (j - i) * Math.min(heights[i],heights[j]);
            if(area > best){
                best = area;
            }
            if (heights[i] <= heights[j]){
                i++;
            } else {
                j--;
            }
        }
        return best;
    }
}
