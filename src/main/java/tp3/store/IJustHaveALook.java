package tp3.store;

public interface IJustHaveALook {

	public int getPrice(String productName);
	
	public boolean isAvailable(String productName, int quantity);
	
	public boolean isAvailable(String productName);
}
