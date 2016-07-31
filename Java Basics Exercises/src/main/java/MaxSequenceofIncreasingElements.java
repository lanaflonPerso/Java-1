import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Hristo on 28.07.2016 г..
 */
public class MaxSequenceofIncreasingElements {
    public static void main(String[] args) {
        int[] nums = Arrays.stream(new Scanner(System.in).nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int tempCounter = 1;
        int counter = 0;
        ArrayList<Integer> tempList = new ArrayList<Integer>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (i != nums.length - 1 && nums[i] < nums[i + 1]){
                tempCounter++;
                tempList.add(nums[i]);
            }
            else {
                if (tempCounter > counter){
                    counter = tempCounter;
                    tempCounter = 1;
                    tempList.add(nums[i]);
                    list = tempList;
                    tempList = new ArrayList<Integer>();
                }
                else{
                    tempCounter = 1;
                    tempList.removeAll(tempList);
                }
            }
        }
        for (int n : list) {
            System.out.print(n + " ");
        }
    }
}
