package org.problems.datastructures;

/**
 * https://leetcode.com/problems/apply-discount-every-n-orders/
 * 
 * 
 * There is a sale in a supermarket, there will be a discount every n customer.
 * There are some products in the supermarket where the id of the i-th product
 * is products[i] and the price per unit of this product is prices[i]. The
 * system will count the number of customers and when the n-th customer arrive
 * he/she will have a discount on the bill. (i.e if the cost is x the new cost
 * is x - (discount * x) / 100). Then the system will start counting customers
 * again. The customer orders a certain amount of each product where product[i]
 * is the id of the i-th product the customer ordered and amount[i] is the
 * number of units the customer ordered of that product.
 * 
 * Implement the Cashier class:
 * 
 * Cashier(int n, int discount, int[] products, int[] prices) Initializes the
 * object with n, the discount, the products and their prices. double
 * getBill(int[] product, int[] amount) returns the value of the bill and apply
 * the discount if needed. Answers within 10^-5 of the actual value will be
 * accepted as correct.
 *
 * 
 * Runtime: 104 ms, faster than 100.00% of Java online submissions for Apply
 * Discount Every n Orders. Memory Usage: 63 MB, less than 100.00% of Java
 * online submissions for Apply Discount Every n Orders.
 */
public class ApplyDiscount {

	class Cashier {

		int counter;
		int n;

		int discount;
		int[] products;
		int[] prices;

		public Cashier(int n, int discount, int[] products, int[] prices) {
			counter = 0;
			this.n = n;
			this.discount = discount;
			this.products = new int[256];
			this.prices = new int[256];
			for (int i = 0; i < products.length; i++) {
				this.products[products[i]] = products[i];
				this.prices[products[i]] = prices[i];
			}
		}

		public double getBill(int[] product, int[] amount) {
			counter++;
			double sum = 0.0d;
			for (int p = 0; p < product.length; p++) {
				int id = product[p];
				sum += prices[id] * amount[p];
			}
			return counter % n == 0 ? (sum - (discount * sum) / 100) : sum;
		}
	}

	/**
	 * Your Cashier object will be instantiated and called as such: Cashier obj =
	 * new Cashier(n, discount, products, prices); double param_1 =
	 * obj.getBill(product,amount);
	 */
	public static void main(String[] arg) {

	}

}
