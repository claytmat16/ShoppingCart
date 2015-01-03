/**
 * 
 * @author Matthew Clayton
 * @version January 3, 2015
 * @assign.ment Shopping Cart
 * @descrip.tion
 * 
 * 
 */

import java.util.Arrays;
import java.util.Scanner;

public class ShoppingCartV2MC {
	int capacity;
	double subtotal;
	ItemV2MC[] cart;

	public ShoppingCartV2MC() {
		capacity = 10;
		subtotal = 0.00;
		cart = new ItemV2MC[capacity];
	}

	public static void main(String[] args) {
		ShoppingCartV2MC shopCart = new ShoppingCartV2MC();

		// declare variables for ItemV2MC object assignments
		String curItemName;
		double curItemPrice;
		int curItemQuantity;

		Scanner scan = new Scanner(System.in); // scanner for user input

		int cartLocation = 0; // track placement in array cart
		int cartStart = 0; // for holding start position for loop argument

		boolean keepShopping = true; // conditional on shopping loop
		String keepGoing; // whether or not to keep shopping

		System.out.println("Welcome to shopping.");
		System.out
				.println("For each item, please input the name, price in dollars, and quantity on separate lines.\n");

		while (keepShopping == true) {
			// get current item values
			System.out.print("Please give the name of the item: ");
			curItemName = scan.nextLine();
			// for (int i = 0; i < 5; i++) {
			System.out
					.print("Please enter the item price in the format xx.xx: $");
			// try { // test for proper input
			curItemPrice = scan.nextDouble();
			// break; // exit loop at proper input
			// } catch (InputMismatchException e) {
			// System.out.println("Price entries must be numerical.");
			// }
			// }
			// for (int i = 0; i < 5; i++) {
				System.out
						.print("Please enter a whole number value for the quantity of the item: ");
			// try { // test for proper input
					curItemQuantity = scan.nextInt();
			// break; // exit loop at proper input
			// } catch (InputMismatchException e) {
			// System.out.println("Quantity entries must be integers.");
			// }
			// }

			for (int i = cartLocation; i < curItemQuantity + cartStart; i++) { // for
				// each
				// item
				try { // check for space in cart
					shopCart.cart[cartLocation] = new ItemV2MC(curItemName,
							curItemPrice);
				} catch (ArrayIndexOutOfBoundsException e) {
					shopCart.increaseSize();
					shopCart.cart[cartLocation] = new ItemV2MC(curItemName,
							curItemPrice);
				}
				// shopCart.subtotal += curItemPrice; // add individual item
				// price
				// to subtotal
				cartLocation++; // advance to next position in cart
			}

			cartStart = cartLocation;
			System.out
					.print("If you would like to quit shopping, enter 'q', otherwise enter any other key to continue: ");
			keepGoing = scan.nextLine();
			keepGoing = scan.nextLine();
			if (keepGoing.equalsIgnoreCase("q")) // if wants to quit
				keepShopping = false; // avoid continuation of loop
			else
				System.out.println(); // blank line before next item
		}
		scan.close(); // close scanner resource

		// add together item prices
		for (int i = 0; i < shopCart.cart.length; i++) {
			try { // check that there is an item
				shopCart.subtotal += shopCart.cart[i].getPrice();
			} catch (NullPointerException e) { // if no item, end loop
				break;
			}
		}

		// print price to nearest whole cent
		System.out.printf("\nPlease pay $" + "%.2f", shopCart.subtotal);
	}

	// ---------------------------------------------------------
	// Increases the capacity of the shopping cart by 3
	// ---------------------------------------------------------
	public void increaseSize() {
		cart = Arrays.copyOf(cart, cart.length + 3); // copy array to new array
		// of current size + 3
		capacity += 3; // add three spaces
	}
}