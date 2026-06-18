import java.util.*;

public class IndianCoins {
    public static void main(String[] args) {
        int coins[] = {1,5,10,20,50,100,500,2000};
        int val = 590;

        Arrays.sort(coins);

        int count = 0;
        for(int i=coins.length-1; i>=0; i--){
            if(coins[i] <= val){
                while(coins[i] <= val){
                     val = val - coins[i];
                count++;
                }
            }
        }
        System.out.println(count);
    }
}
