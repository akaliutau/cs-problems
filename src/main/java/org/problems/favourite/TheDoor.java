package org.problems.favourite;

import java.util.LinkedList;
import java.util.Queue;

import org.problems.utils.Utils;

/**
 * The door
 * 
 * It can be used by customers either as an entrance or an exit. Sometimes
 * multiple customers want to pass through the door and their directions
 * can be different. The ith customer comes to the door at time[i] and
 * wants to either exit the store if direction [i] = 1 or enter the store if
 * direction[i] = 0. Customers form 2 queues, one to exit and one to enter. They
 * are ordered by the time when they came to the door and, if the times are
 * equal, by their indices.
 * 
 * If one customer wants to enter the store and another customer wants to exit
 * at the same moment, there are three cases:
 * 
 * If in the previous second the door was not used (maybe it was used
 * before, but not at the previous second), then the customer who wants to exit
 * goes first. 
 * If in the previous second the door was used as an exit, then
 * the customer who wants to leave goes first. 
 * If in the previous second the
 * door was used as an entrance, then the customer who wants to enter goes
 * first. Passing through the door takes 1 second.
 * 
 * Write an algorithm to find the time for each customer when they will pass
 * through the door.
 * 
 * Input
 * 
 * The function/method consists of three arguments:
 * 
 * numcustomers, an integer representing the number of customers (n);
 * 
 * arrTime, a list of integers where the value at indexi is the time in seconds
 * when the ith customer will come to the door;
 * 
 * direction, a list of integers where the value at indexi is the direction of
 * the ith customer.
 * 
 * Output
 * 
 * Return a list of integers where the value at index i is the time when the ith
 * customer will pass the door.
 * 
 * 
 * 
 * Constraints
 * 
 * 1 <= numCustomers <= 10^5
 * 0 <= arrTime[i] <= arrTime[i + 1] <= 10^9
 * 0 <= i <= numCustomers - 2
 * 0 <= direction[i] <= 1
 * 0 <= j <= numCustomers - 1
 * 
 * Examples
 * 
 * Example 1:
 * 
 * Input:
 * numCustomers = 4
 * arrTime =   [0, 0, 1, 5]
 * direction = [0, 1, 1, 0]
 * 
 * Output:
 * [2,0,1,5]
 * 
 * Explanation: At time 0, customer 0 and 1 want to pass through the door.
 * Customer 0 wants to enter the store and customer 1 wants to leave the store.
 * The door was not used in the previous second, so the priority is on the
 * side of the customer 1 At time 1, customers 0 and 2 want to pass through the
 * door. Customer 2 wants to leave the store and at the previous second the
 * door was used as an exit, so the customer 2 passes through the
 * door.
 * 
 * At time 2, customer 0 passes through the door.
 * 
 * At time 5, customer 3 passes through the door
 * 
 * 
 */
public class TheDoor {
	
	static class Customer {
		int arrTime;
		int dir;
		int passedTime;
		boolean passed = false;

		public Customer(int arrTime, int dir) {
			this.arrTime = arrTime;
			this.dir = dir;
		}
	}
	
	static class Time {
		int time = 0;
	}
	
	static class Door {
		int dir = -1; // last direction
		int time = -10; // last time the door used
		
		public void process(Queue<Customer> toExit, Queue<Customer> toEnter, Time t) {
			Customer c1 = update(toExit.peek(), t);
			Customer c2 = update(toEnter.peek(), t);
			if (c1 != null && c2 != null) {
				if (c1.arrTime == c2.arrTime) {
					t.time = c1.arrTime;
					if (t.time - time > 1) {// door was not used in prev second
						pass(toExit, 1, t.time);
					}else if (dir == 1){
						pass(toExit, 1, t.time);
					}else if (dir == 0) {
						pass(toEnter, 0, t.time);
					}
				}else if (c1.arrTime < c2.arrTime) {
					t.time = c1.arrTime;
					pass(toExit, 1, t.time);
				}else if (c1.arrTime > c2.arrTime) {
					t.time = c2.arrTime;				
					pass(toEnter, 0, t.time);
				}
			} else if (c1 != null) {
				t.time = c1.arrTime;
				pass(toExit, 1, t.time);
			} else if (c2 != null) {
				t.time = c2.arrTime;				
				pass(toEnter, 0, t.time);
			}
			this.time = t.time;
			t.time ++;
		}
		
		private Customer update(Customer c, Time time) {
			if (c == null) {
				return null;
			}
			if (c.arrTime < time.time) {
				c.arrTime = time.time;
			}
			return c;
		}
		
		private void pass(Queue<Customer> q, int dir, int time) {
			Customer c = q.remove();
			c.passed = true;
			c.passedTime = time;
			this.dir = dir;
		}
	}
	
	public static int[] turnsl(int numCustomers, int[] arrTime, int[] direction){
		int[] res = new int[numCustomers];
		Queue<Customer> toExit = new LinkedList<>();
		Queue<Customer> toEnter = new LinkedList<>();
		Customer[] customers = new Customer[numCustomers];
		for (int i = 0; i < numCustomers; i++) {
			customers[i] = new Customer(arrTime[i], direction[i]);
			if (customers[i].dir == 0) {
				toEnter.add(customers[i]);
			}else {
				toExit.add(customers[i]);
			}
		}
		Door door = new Door();
		Time t = new Time();
		while (!toExit.isEmpty() || !toEnter.isEmpty()) {
			door.process(toExit, toEnter, t);
		}
		for (int i = 0; i < numCustomers; i++) {
			res[i] = customers[i].passedTime;
		}		
		return res;
	}

	public static void main(String[] arg) {
		
		int[] arrTime = {0, 0, 1, 5};
		int[] direction = {0, 1, 1, 0};
		
		Utils.print(turnsl(4, arrTime, direction));
	}

}
