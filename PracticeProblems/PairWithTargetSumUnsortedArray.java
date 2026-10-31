import java.util.HashSet;

public class PairWithTargetSumUnsortedArray {

    static boolean hasPairWithSum(int[] nums, int target) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (set.contains(target - num)) {
                return true;
            }

            set.add(num);
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, 6};
        int target = 20;

        System.out.println(hasPairWithSum(nums, target));
    }
}
