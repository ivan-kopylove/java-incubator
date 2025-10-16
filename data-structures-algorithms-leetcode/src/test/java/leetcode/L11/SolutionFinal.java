package leetcode.L11;

class SolutionFinal
{
    int maxArea(int[] height)
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
            bottomHeight = rightIdx - leftIdx;

            int localMax = 0;
            if (leftHeight <= rightHeight)
            {
                localMax = leftHeight * bottomHeight;
            }
            else
            {
                localMax = rightHeight * bottomHeight;
            }

            globalMax = Math.max(globalMax, localMax);

            if (leftHeight <= rightHeight)
            {
                leftHeight = height[++leftIdx];
            }
            else
            {
                rightHeight = height[--rightIdx];
            }
        }

        return globalMax;
    }
}
