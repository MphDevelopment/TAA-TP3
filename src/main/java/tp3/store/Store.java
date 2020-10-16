package tp3.store;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import tp3.bank.IBank;
import tp3.provider.IProvider;

@Component
public class Store implements IFastLane, ILane, IJustHaveALook {
	@Autowired
	IBank bank;
	
	@Autowired
	IProvider provider;
	
	Map<String, Integer> prices;
	Map<String, Integer> stocks;
	Map<String, Integer> cart;
	
	@Value("${storeAccountNumber}")
	private int storeAccountNumber;
	
	public Store()
	{
		prices = new HashMap();
		stocks = new HashMap();
		cart = new HashMap();
		
		prices.put("pain", 2);
		stocks.put("pain", 10);
	}
	
	public int getPrice(String productName) {
		// TODO Auto-generated method stub
		return prices.get(productName);
	}
	public boolean isAvailable(String productName, int quantity) {
		// TODO Auto-generated method stub
		return stocks.get(productName) >= quantity;
	}
	public boolean isAvailable(String productName) {
		// TODO Auto-generated method stub
		return isAvailable(productName, 1);
	}
	
	public void addItemToCart(String productName, int quantity) {
		if(stocks.get(productName)<quantity)
		{
			System.err.println("Product isn't available in this quantity.");
			return;
		}
		cart.put(productName, cart.getOrDefault(productName, 0) + quantity);
				
	}
	
	public void addItemToCart(String productName) {
		addItemToCart(productName, 1);
		
	}
	public void pay(int accountNumber) {
		int amount = 0;
		for(Entry<String, Integer> entry : cart.entrySet())
		{
			amount += getPrice(entry.getKey()) * entry.getValue();
		}
		if(bank.transfert(accountNumber, storeAccountNumber, amount))
		{
			for(Entry<String, Integer> entry : cart.entrySet())
			{
				String productName = entry.getKey();
				int quantity = entry.getValue();
				
				int newQuantity = stocks.get(productName) - quantity;
				stocks.put(productName, newQuantity);
				
				if(newQuantity<3)
				{
					provider.order(productName, 10, stocks);
				}
			}
		}else
		{
			System.err.println("The bank refused the payment");
		}
		
		
		cart = new HashMap<String, Integer>();
		
	}
	public void oneShotOrder(String productName, int quantity, int accountNumber) {
		this.addItemToCart(productName, quantity);
		this.pay(accountNumber);		
	}
	
	public void oneShotOrder(String productName, int accountNumber) {
		this.oneShotOrder(productName, accountNumber);
		
	}
}
