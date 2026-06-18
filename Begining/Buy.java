public class Buy{
    public static int buysellStock(int price[]){
        int buyPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int i = 0; i<price.length; i++){
            if(buyPrice < price[i]){
               int profit = price[i] - buyPrice;
               maxProfit = Math.max(maxProfit, profit); 
            }else{
                buyPrice = price[i];
            }
        }
         return maxProfit;
    }

    public static void main(String[] args) {
        int price[] = {2,4,6,7,8,9};
        System.out.println(buysellStock(price));
    }
   
}
