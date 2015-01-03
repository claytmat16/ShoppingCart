/**
 * 
 * @author Matthew Clayton
 * @version January 2, 2015
 * @assign.ment Shopping Cart
 * @descrip.tion
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
