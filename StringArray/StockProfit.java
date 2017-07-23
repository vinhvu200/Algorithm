// http://www.geeksforgeeks.org/stock-buy-sell/

public class StockProfit {

	public int maxProfit(int[] arr) {
	
		int start, current, profit;
		start = profit = 0;
		current = 1;
		boolean upwardTrend = false;

		while (current < arr.length) {
		
			if (arr[current] > arr[current-1])
				upwardTrend = true;
			else {
			
				if (upwardTrend) {
				
					profit += arr[current-1] - arr[start];
					int sell = current-1;
					System.out.println("Buy : " + start + " Sell : " + sell);
					upwardTrend = false;
				}
				start = current;
			}
			current++;
		}
		if (upwardTrend){
			profit += arr[current-1] - arr[start];
			int sell = current - 1;
			System.out.println("Buy : " + start + " Sell : " + sell);
		}

		return profit;
	}

	public static void main(String[] args) {
	
		int[] arr = {100,180,260,310,40,535,695};
		StockProfit obj = new StockProfit();
		System.out.println(obj.maxProfit(arr));
	}
}
