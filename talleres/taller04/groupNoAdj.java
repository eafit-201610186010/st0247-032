
/**
 * Write a description of class g here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class groupNoAdj
{
    public boolean groupNoAdj(int start, int[] nums, int target) {
        if (start >= nums.length) return target == 0; // 5
        if(groupNoAdj(start + 2, nums, target - nums[start])) return true; // 3 + T(n-2) 
        if(groupNoAdj(start + 1, nums, target)) return true; // 3 + T(n-1)
        return false; // 1
    }
}
