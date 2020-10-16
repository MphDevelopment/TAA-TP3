package tp3.bank;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class Bank implements IBank{

	Map<Integer, Integer> accounts;
	
	public Bank()
	{
		this.accounts = new HashMap<Integer, Integer>();
		accounts.put(0, 2);
		accounts.put(1, 10000);
		
	}
	
	public boolean transfert(int senderNumber, int receiverNumber, int amount) {
		accounts.put(senderNumber, accounts.getOrDefault(senderNumber, 0) - amount);
		accounts.put(receiverNumber, accounts.getOrDefault(receiverNumber, 0) + amount);
		
		return true;
	}
	
	public Map<Integer, Integer> getAccounts()
	{
		return accounts;
	}
	

}
