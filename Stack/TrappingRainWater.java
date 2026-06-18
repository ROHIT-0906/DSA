
import java.util.Stack;

public class TrappingRainWater {
    
    public static int trappingWater(int[] arr){
        Stack<Integer> s = new Stack<>();
        int totalWater = 0;
        for(int i=0; i<arr.length; i++){

            while(!s.empty() && arr[i] > arr[s.peek()]){
                int top =s.pop();

                if(s.isEmpty()){
                    break;
                }
                int width = i - s.peek()-1;
                int height = Math.min(arr[i], arr[s.peek()]) - arr[top];
                int water = width * height;
                totalWater = totalWater + water;
            }
            s.push(i);
        }
        return totalWater;
    }

    public static void main(String[] args) {
        int[] arr = {7,0,4,2,5,0,6,4,0,6};

        System.out.println(trappingWater(arr));
    }
}
