package tp3.store;

public interface IFastLane {
	
	public void oneShotOrder(String productName, int quantity, int accountNumber);
	
	public void oneShotOrder(String productName, int accountNumber);

}
