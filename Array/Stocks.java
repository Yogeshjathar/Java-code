public class Stocks {
    public static void main(String args[]){
        int prices[] = {7,1,5,3,6,4};
        System.out.println(buyAndSellStocks(prices));
    }

    public static int buyAndSellStocks(int price[]){

        int buyingPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int i=0; i<price.length; i++){
            if(buyingPrice < price[i]){
                int profit = price[i] - buyingPrice;
                maxProfit = Math.max(maxProfit , profit);
            }
            else{
                buyingPrice = price[i];
            }
        }

        return maxProfit;
    }
}