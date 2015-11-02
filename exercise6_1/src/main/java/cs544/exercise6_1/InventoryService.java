package cs544.exercise6_1;

public class InventoryService implements IInvertoryService {

	public int getNumberInStock(int productNumber) {

		return productNumber - 200;
	}

}
