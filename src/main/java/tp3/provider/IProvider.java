package tp3.provider;

import java.util.Collection;
import java.util.Map;

public interface IProvider {

	public int getPrice(String productName);
	
	public void order(String productName, int quantity, Map<String, Integer> stock);
}
