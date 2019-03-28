package strings_arrays;

import java.util.ArrayList;

/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).

Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).

Example 1:

Input: [7,1,5,3,6,4]
Output: 7
Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
             Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
Example 2:

Input: [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
             Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
             engaging multiple transactions at the same time. You must sell before buying again.
Example 3:

Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.
*/

public class BuySellStock {
	
	public static int findLocalMin(int[] prices) {
		ArrayList<Integer> locMins = new ArrayList<Integer>();
		ArrayList<Integer> locMaxs = new ArrayList<Integer>();
		// find all local minimums:
		boolean down = false;
		boolean up = false;
		for (int i = 0; i < prices.length - 1; i++) {
			if (prices[i] > prices[i + 1]) {
				if (!(down || up)) {
					down = true;
					locMaxs.add(i);
				}
				if (up) {
					locMaxs.add(i);
					down = true;
					up = false;
				}
			} else if (prices[i] < prices[i + 1]) {
				if (!(down || up)) {
					up = true;
					locMins.add(i);
				}
				if (down) {
					down = false;
					up = true;
					locMins.add(i);
				}
			}
		}
		if (down) {
			locMins.add(prices.length - 1);
		}
		if (up) {
			locMaxs.add(prices.length - 1);
		}
		int total = 0;
		for (int i = 0, k = 0; i < locMins.size() && k < locMaxs.size();) {
			if (locMins.get(i) < locMaxs.get(k)) {
				total += prices[locMaxs.get(k)] - prices[locMins.get(i)];
				i++;
				k++;
			} else {
				k++;
			}
		}
		return total;
	}
	
	public static int simpleSolution(int[] prices) {
		int total = 0;
		for (int i = 0; i < prices.length - 1; i++) {
			if (prices[i] < prices[i + 1]) {
				total += prices[i + 1] - prices[i];
			}
		}
		return total;
	}
	
	public static int findLocalMax(int[] prices, int i) {
		if (i == prices.length - 1) {
			return -1;
		}
		for (int k = i + 1; k < prices.length; k++) {
			if (prices[k] > prices[k - 1]) {
				continue;
			} else {
				return k - 1;
			}
		}
		return -1;
	}
	
	public static int maxProfit2(int[] prices) {
        int i = 0;
        int valley = prices[0];
        int peak = prices[0];
        int maxprofit = 0;
        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i] >= prices[i + 1])
                i++;
            valley = prices[i];
            while (i < prices.length - 1 && prices[i] <= prices[i + 1])
                i++;
            peak = prices[i];
            maxprofit += peak - valley;
        }
        return maxprofit;
    }
	
	public static int calcProfit(int[] prices) {
		int profit = 0;
		int i = 0;
		while (i < prices.length - 1) {
			while (i < prices.length - 1 && prices[i] > prices[i + 1]) {
				i++;
			}
			int low = prices[i];
			while (i < prices.length - 1 && prices[i] < prices[i + 1]) {
				i++;
			}
			int high = prices[i];
			profit += high - low;
		}
		return profit;
	}
	
	public BuySellStock() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		int[] prices = {7,6,4,3,1};
		System.out.println(findLocalMin(prices));
//		System.out.println(simpleSolution(prices));
//		System.out.println(maxProfit2(prices));
		System.out.println(calcProfit(prices));
	}

}
