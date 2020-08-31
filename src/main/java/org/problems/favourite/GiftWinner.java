package org.problems.favourite;

/**
 * Gift winner
 * 
 * Consider the following secret code list: 
 * [[apple, apple], [banana, any, banana]] 
 * Based on the above secret code list, a customer who made either of
 * the following purchases would win the prize: 
 * orange, apple, apple, banana, orange, banana 
 * apple, apple, orange, orange, banana, apple, banana, banana
 * Write an algorithm to output true if the customer is a winner else output false.
 * Both the order of the groups within the code list and the order of the fruits within the groups matter. 
 * However, between the groups of fruits, any number, and type of fruit is allowable
 * 
 * 
 * Input 
 * The input to the function/method consists of two arguments: 
 * 
 * codes, a list of lists of strings representing the order and grouping of specific
 * fruits that must be purchased in order to win the prize for the day.
 * 
 * shoppingCart, a list of strings representing the order in which a customer
 * purchases fruit. 
 * 
 */
public class GiftWinner {
	
	static final String ANY = "any";
	
	private static boolean isWinnder(String[][] codes, String[] shoppingCart) {
		int len = codes.length;
		int n = shoppingCart.length;
		if(codes == null || len == 0) {
			return true;
		}
		if(shoppingCart == null || n == 0) {
			return false;
		}
		int block = 0;
		int item = 0;
		for(String fruit : shoppingCart) {
			if(codes[block][item].equals(fruit) || codes[block][item].equals(ANY)) {
				item ++;
				if(item == codes[block].length) {
					block ++;
					item = 0;
				}
				if(block == len) {
					return true;
				}
			}else {
				item = codes[block][0].equals(ANY) ? 1 : 0;
			}
		}
		return false;
	}

	public static void main(String[] arg) {

		String[][] codes0 = {  };
		String[] shoppingCart0 = {"orange", "apple", "orange", "banana"};
		System.out.println(isWinnder(codes0, shoppingCart0));

		String[][] codes1 = { { "apple", "apple" }, { "banana", "any", "banana" } };
		String[] shoppingCart1 = {"orange", "apple", "apple", "banana", "orange", "banana"};
		System.out.println(isWinnder(codes1, shoppingCart1));
		
		String[][] codes2 = { { "apple", "apple" }, { "banana", "any", "banana" } };
		String[] shoppingCart2 = {"banana", "orange", "banana", "apple", "apple"};
		System.out.println(isWinnder(codes2, shoppingCart2));
		
		String[][] codes3 = { { "apple", "apple" }, { "banana", "any", "banana" } };
		String[] shoppingCart3 = {"apple", "banana", "apple", "banana", "orange", "banana"};
		System.out.println(isWinnder(codes3, shoppingCart3));
		
		String[][] codes4 = { { "apple", "apple" }, { "apple", "apple", "banana" } };
		String[] shoppingCart4 = {"apple", "apple", "apple", "banana"};
		System.out.println(isWinnder(codes4, shoppingCart4));
		
		String[][] codes5 = { { "apple", "apple" }, { "banana", "any", "banana" } };
		String[] shoppingCart5 = {"orange", "apple", "apple", "banana", "orange", "banana"};
		System.out.println(isWinnder(codes5, shoppingCart5));
		
		String[][] codes6 = { { "apple", "apple" }, { "banana", "any", "banana" }  };
		String[] shoppingCart6 = {"apple", "apple", "orange", "orange", "banana", "apple", "banana", "banana"};
		System.out.println(isWinnder(codes6, shoppingCart6));
		
		String[][] codes7= { { "any", "apple" }, { "banana", "any", "banana" }  };
		String[] shoppingCart7 = {"orange", "grapes", "apple", "orange", "orange", "banana", "apple", "banana", "banana"};
		System.out.println(isWinnder(codes7, shoppingCart7));


	}

}
