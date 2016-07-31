import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Hristo on 28.07.2016 г..
 */
public class MostFrequentNumber {
    public static void main(String[] args) {

        int[] nums = Arrays.stream(new Scanner(System.in).nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int tempCounter = 0;
        int counter = 0;
        int tempValue = 0;
        int value = 0;

        for (int i = 0; i < nums.length; i++) {

            for (int num : nums) {
                if (nums[i] == num){
                    tempCounter++;
                }
            }
            if (tempCounter > counter){
                counter = tempCounter;
                value = nums[i];
            }
            tempCounter = 0;
        }
        System.out.println(value);
    }
}
