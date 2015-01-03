// **********************************************************************
// Represents a shopping cart as an array of items
// **********************************************************************

/**
 * NOTE
 * 
 * Instructions regarding capacity are unclear. Does capacity reference the 
 * number of different items? That is, the number of times that the while loop
 * of the main method is executed? Or does it reference the sum quantities of items?
 * That is, the curItemQuantity values summed together.
 * 
 * This class assumes that capacity references the number of items by quantity,
 * so five carrots and twelve potatoes results in a capacity of seventeen.
 * 
 * Find class template provided to be rather unclear and complex.
 */
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Scanner;

public class ShoppingCartMC {
	private static int itemCount; // total number of items in the cart
	private static double totalPrice; // total price of items in the cart
	private static int capacity; // current cart capacity
	private static ItemMC[] cart;

	// -----------------------------------------------------------
	// Creates an empty shopping cart with a capacity of 5 items.
	// -----------------------------------------------------------
	public ShoppingCartMC() {
		capacity = 5;
		itemCount = 0;
		totalPrice = 0.0;
		cart = new ItemMC[capacity];
	}

	public static void main(String[] args) {
		// ShoppingCartMC shopCart = new ShoppingCartMC();
		// int spaceAvailable = shopCart.capacity;

		// values for current item by user input for purposes of args for
		// ItemMC()
		String curItemName;
		double curItemPrice;
		int curItemQuantity;

		Scanner scan = new Scanner(System.in); // scanner for user input
		// int iterationNum = 0; // track placement in array cart

		boolean keepShopping = true; // conditional on shopping loop

		System.out.println("Welcome to shopping.");
		System.out
				.println("For each item, you will input the name, price in dollars, and quantity on separate lines\n");
		while (keepShopping == true) {
			// get current item values
			System.out.println("Please give the name of the item: ");
			curItemName = scan.nextLine();
			System.out
					.println("Please enter the item price in the format xx.xx: $");
			curItemPrice = scan.nextDouble();
			System.out
					.println("Please enter a whole number value for the quantity of the item: ");
			curItemQuantity = scan.nextInt();
			// add ItemMC object for current item values to cart
			// shopCart.cart[iterationNum] = new ItemMC(curItemName,
			// curItemPrice, curItemQuantity);
			// iterationNum++;
			addToCart(curItemName, curItemPrice, curItemQuantity);
		}
		scan.close();
	}

	// -------------------------------------------------------
	// Adds an item to the shopping cart.
	// -------------------------------------------------------
	public static void addToCart(String itemName, double price, int quantity) {
		// int curCartPlace = 0;
		for (int i = 0; i < cart.length; i++) {
			// if cart is full, increase size
			if (cart[i] != null)
				continue;
			cart[i] = new ItemMC(itemName, price, quantity);
			totalPrice += price * quantity;
			itemCount += quantity;
		}
	}

	// -------------------------------------------------------
	// Returns the contents of the cart together with
	// summary information.
	// -------------------------------------------------------
	public String toString() {
		NumberFormat fmt = NumberFormat.getCurrencyInstance();
		String contents = "\nShopping Cart\n";
		contents += "\nItem\t\tUnit Price\tQuantity\tTotal\n";
		for (int i = 0; i < itemCount; i++)
			contents += cart[i].toString() + "\n";
		contents += "\nTotal Price: " + fmt.format(totalPrice);
		contents += "\n";
		return contents;
	}

	// ---------------------------------------------------------
	// Increases the capacity of the shopping cart by 3
	// ---------------------------------------------------------
	public void increaseSize() {
		cart = Arrays.copyOf(cart, cart.length + 3);
		capacity += 3;
	}
}