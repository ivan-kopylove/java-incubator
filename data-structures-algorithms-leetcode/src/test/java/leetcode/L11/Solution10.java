package leetcode.L11;

class Solution10
{
    public int maxArea(int[] height)
    {
        int globalMax = 0;

        int leftIdx = 0;
        int rightIdx = height.length - 1;

        int rightHeight = height[rightIdx];
        int leftHeight = height[leftIdx];
        int bottomHeight = 0;

        int maxLeftHeight = leftHeight;
        int maxRightHeight = rightHeight;

        while (leftIdx != rightIdx)
        {
            // I can infer of the sides (a bottom) length just from indices, right?
        }

        return globalMax;
    }
}
