package tp3.provider;

import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class Provider implements IProvider {

	private Map<String, Integer> products;
	
	public int getPrice(String productName) {
		return products.get(productName);
	}

	public void order(String productName, int quantity, Map<String, Integer> stock) {
		stock.put(productName, stock.getOrDefault(productName, 0)+quantity);
	}

	
	
}
