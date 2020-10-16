package tp3.store;

public interface ILane {
	
	public void addItemToCart(String productName, int quantity);
	
	public void addItemToCart(String productName);
	
	public void pay(int accountNumber);

}
