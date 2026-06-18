import java.util.*;
public class TwoSum {

    public static void main(String[] args) {
        int arr[] = {100,300,500,400};

        int windowSum = arr[0]+arr[1];
        int result = windowSum;

        for(int i=2; i<arr.length; i++){
            windowSum = windowSum - arr[i-2] + arr[i];
            result = Math.max(result, windowSum);
        }

        System.out.println(result);
    }
}
