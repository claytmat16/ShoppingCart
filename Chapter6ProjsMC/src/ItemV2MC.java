/**
 * 
 * @author Matthew Clayton
 * @version January 3, 2015
 * @assign.ment Shopping Cart
 * @descrip.tion This class creates item objects for use in the ShoppingCartV2MC
 *               class each containing cost and name data.
 * 
 * 
 */

public class ItemV2MC {
	String name;
	double cost;

	public ItemV2MC(String unitName, double unitCost) {
		name = unitName;
		cost = unitCost;
	}

	public double getPrice() {
		return cost;
	}

	public String getName() {
		return name;
	}
}
