// Floyd's cycle detection to find the start of the cycle in the implicit linked list formed by nums[i] -> nums[nums[i]]. This start is the duplicate number. O(1) space, O(n) time.
public class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        do { // intersection point
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        slow = nums[0]; // reset slow, move both at slow pace. They'll meet at entrance.
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
