import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int[] nums = new int[10];
            for (int k = 0; k < 10; k++) {
                nums[k] = sc.nextInt();
            }
            Arrays.sort(nums);
            System.out.println(nums[nums.length-3]);
        }
    }

}