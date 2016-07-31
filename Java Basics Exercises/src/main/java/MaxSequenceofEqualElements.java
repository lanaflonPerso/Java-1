import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Hristo on 28.07.2016 г..
 */
public class MaxSequenceofEqualElements {
    public static void main(String[] args) {
        int[] nums = Arrays.stream(new Scanner(System.in).nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int tempCounter = 1;
        int counter = 0;
        int tempValue = 0;
        int value = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i != nums.length - 1 && nums[i] == nums[i + 1]){
                tempCounter++;
                tempValue = nums[i];
            }
            else {
                if (tempCounter > counter){
                    counter = tempCounter;
                    tempCounter = 1;
                    value = tempValue;
                    tempValue = 0;
                }
                else{
                    tempCounter = 1;
                    tempValue = 0;
                }
            }
        }
        for (int i = 0; i < counter; i++) {
            System.out.print(value + " ");
        }
    }
}
